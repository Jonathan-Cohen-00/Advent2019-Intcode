package day9;

import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import utils.MachineLauncher;

import java.util.ArrayList;
import java.util.List;

public class D9P1Test implements MachineLauncher {
    @Test
    public void testd9p1() throws Exception {
        List<Long> integerList = Parsers.recupererListeEntiers("src/main/resources/Day9-Input");
        Machine machine = new Machine(integerList);
        machine.setNextInput(1L);
        machine.execute();
        Assert.assertEquals(machine.getListeOutput(), List.of(3460311188L));
    }
}
