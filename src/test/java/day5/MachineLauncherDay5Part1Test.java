package day5;

import file.FileUtils;
import machine.Machine;
import org.junit.Assert;
import org.junit.Test;
import utils.MachineLauncher;

import java.util.List;

public class MachineLauncherDay5Part1Test implements MachineLauncher {
// les tests ne sont pas faits pour gerer les input.... plus tard il faudra
// gerer les input dans le code lui meme puis run le test

//    @Test
//    public void testd5p1() throws Exception {
//        Assert.assertNull(runMachineAndGetEndList("src/main/resources/Day5Part1-Input"));
//    }

    public static void main(String[] args) throws Exception{
        List<Integer> integerList = FileUtils.recupererListeEntiers("src/main/resources/Day5Part1-Input");
        Machine machine = new Machine(integerList);
        machine.execute();
    }
}
