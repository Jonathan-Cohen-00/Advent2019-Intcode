package day9;

import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import utils.MachineLauncher;

import java.lang.reflect.Array;
import java.util.*;

public class D9P2Test implements MachineLauncher {
    @Test
    public void testd9p2() throws Exception {
        List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day9-Input");
        Machine machine = new Machine(longList);
        machine.setNextInput(2L);
        machine.execute();
        Assert.assertEquals(machine.getListeOutput(), List.of(42202L));
    }
}
