package day2;


import org.junit.Assert;
import org.junit.Test;

public class Day2Part1Test {
        @Test
        public void testD2P1Exemple() throws Exception {
            Day2Part1 day2Part1 = new Day2Part1();
            Assert.assertEquals(day2Part1.part("src/test/resources/Day2-Example-Input"),"3500");
        }
        @Test
        public void testD2P1() throws Exception {
            Day2Part1 day2Part1 = new Day2Part1();
            Assert.assertEquals(day2Part1.part("src/main/resources/Day2Part1-Input"),"3790645");
        }
}
