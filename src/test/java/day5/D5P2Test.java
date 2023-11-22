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
        List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day5-Input");
        Machine machine = new Machine(longList);
        machine.setNextInputList(List.of(5L));
        machine.execute();
        Assert.assertEquals((long) machine.getListeOutput().get(machine.getListeOutput().size() - 1), 14340395);
    }
}