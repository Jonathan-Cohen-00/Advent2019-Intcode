package day2;

import org.junit.Assert;
import org.junit.Test;

public class Day2Part2Test {

    @Test
    public void testD2P2() throws Exception {
        Day2Part2 day2Part2 = new Day2Part2();
        Assert.assertEquals(day2Part2.part("src/main/resources/Day2Part2-Input"),"6577");
    }
}
