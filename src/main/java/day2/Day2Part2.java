package day2;

import day.DayPart;
import machine.CodeInconnuException;
import machine.Machine;
import machine.PointeurException;

import java.io.IOException;
import java.util.List;

import static day2.Day2Part1.recupererListeEntiers;

public class Day2Part2 implements DayPart {


    public String part(String path) throws IOException, PointeurException, CodeInconnuException {
        List<Integer> integerList = recupererListeEntiers(path);
        int indexNom = 1;
        int indexVerbe = 2;
        for (int nom = 0; nom <= 99; nom++) {
            for (int verbe = 0; verbe <= 99; verbe++) {
                integerList.set(indexNom, nom);
                integerList.set(indexVerbe, verbe);
                Machine machine = new Machine (integerList);
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