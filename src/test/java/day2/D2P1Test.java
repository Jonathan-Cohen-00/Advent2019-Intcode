package day2;


import org.junit.Assert;
import org.junit.Test;
import utils.MachineLauncher;

public class D2P1Test implements MachineLauncher {

    @Test
        public void testD2P1Exemple() throws Exception {
            Assert.assertEquals((long) runMachineAndGetEndList("src/test/resources/Day2-Example-Input").get(0),3500);
        }
        @Test
        public void testD2P1() throws Exception {
            Assert.assertEquals((long) runMachineAndGetEndList("src/main/resources/Day2Part1-Input").get(0),3790645);
        }
}
