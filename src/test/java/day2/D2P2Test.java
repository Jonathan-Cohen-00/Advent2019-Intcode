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

import static parsers.Parsers.recupererListeEntiers;

public class D2P2Test implements MachineLauncher {
    @Test
    public void testd2p2() throws Exception {
        Assert.assertEquals(day2Part2Scenario("src/main/resources/Day2-Input"), "6577");
    }
    public String day2Part2Scenario(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
        List<Long> longList = recupererListeEntiers(path);
        int indexNom = 1;
        int indexVerbe = 2;
        for (int nom = 0; nom <= 99; nom++) {
            for (int verbe = 0; verbe <= 99; verbe++) {
                longList.set(indexNom, (long) nom);
                longList.set(indexVerbe, (long) verbe);
                Machine machine = new Machine(longList);
                machine.execute();
                if (longList.get(0) == 19690720) {
                    System.out.println("nom = " + nom + "    verbe = " + verbe);
                    return String.valueOf(100 * nom + verbe);
                } else longList = recupererListeEntiers(path);
            }
        }
        return "echec pas de solution";
    }
}
