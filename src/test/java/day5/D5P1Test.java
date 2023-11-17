package day5;

import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import machine.Machine;
import utils.MachineLauncher;

import java.util.List;

public class D5P1Test implements MachineLauncher {

    @Test
    public void testd5p1() throws Exception {
        List<Long> integerList = Parsers.recupererListeEntiers("src/main/resources/Day5Part1-Input");
        Machine machine = new Machine(integerList);
        machine.setNextInput(1L);
        machine.execute();
        long a = machine.getListeOutput().get(machine.getListeOutput().size() - 1);
        Assert.assertEquals (a, 7692125);
    }
}
