package day5;

import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import utils.MachineLauncher;

import java.util.List;

public class D5P2Test implements MachineLauncher {
    @Test
    public void d5p2Test() throws Exception {
        List<Long> integerList = Parsers.recupererListeEntiers("src/main/resources/Day5Part2-Input");
        Machine machine = new Machine(integerList);
        machine.setNextInput(5L);
        machine.execute();
        long a = machine.getListeOutput().get(machine.getListeOutput().size() - 1);
        Assert.assertEquals(a, 14340395);
    }
}