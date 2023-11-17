package day5;

import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import utils.MachineLauncher;

import java.util.List;

public class D5P1Test implements MachineLauncher {
    @Test
    public void d5p1test() throws Exception {
        List<Long> longList = listeDepart("src/main/resources/Day5-Input");
        Machine machine = new Machine(longList);
        machine.setNextInput(1L);
        machine.execute();
        Assert.assertEquals((long) machine.getListeOutput().get(machine.getListeOutput().size() - 1), 7692125L);
    }
}
