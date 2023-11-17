package day2;

import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import utils.MachineLauncher;

import java.util.List;

public class D2P1Test implements MachineLauncher {
    @Test
    public void testD2P1() throws Exception {
        List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day2-Input");
        longList.set(1, 12L);
        longList.set(2, 2L);
        Machine machine = new Machine(longList);
        machine.execute();
        Assert.assertEquals((long)longList.get(0), 3790645);
    }
}
