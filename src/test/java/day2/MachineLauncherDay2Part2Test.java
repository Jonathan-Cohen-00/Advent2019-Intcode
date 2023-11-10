package day2;

import machine.CodeInconnuException;
import machine.Machine;
import machine.ModeInconnuException;
import machine.PointeurException;
import org.junit.Assert;
import org.junit.Test;
import utils.MachineLauncher;

import java.io.IOException;
import java.util.List;

import static file.FileUtils.recupererListeEntiers;

public class MachineLauncherDay2Part2Test implements MachineLauncher {

    @Test
    public void testd2p2() throws Exception {
        Assert.assertEquals(day2Part2Scenario("src/main/resources/Day2Part2-Input"), "6577");
    }

    public String day2Part2Scenario(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
        List<Integer> integerList = recupererListeEntiers(path);
        int indexNom = 1;
        int indexVerbe = 2;
        for (int nom = 0; nom <= 99; nom++) {
            for (int verbe = 0; verbe <= 99; verbe++) {
                integerList.set(indexNom, nom);
                integerList.set(indexVerbe, verbe);
                Machine machine = new Machine(integerList);
                machine.execute();
                if (integerList.get(0) == 19690720) {
                    System.out.println("nom = " + nom + "    verbe = " + verbe);
                    return String.valueOf(100 * nom + verbe);
                } else integerList = recupererListeEntiers(path);
            }
        }
        return "echec pas de solution";
    }
}
