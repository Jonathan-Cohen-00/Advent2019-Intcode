package day13;

import machine.Machine;
import machine.Tile;
import matrice.CaseMatrice;
import matrice.Coordonnees;
import matrice.Matrice;
import org.junit.Assert;
import org.junit.Test;
import parsers.Parsers;
import utils.MachineLauncher;

import java.util.List;

import static parsers.Parsers.getIntegerListFromLongList;

public class D13P1Test implements MachineLauncher {


    public static Matrice<Tile> readOutput(List<Integer> integerList) {
        Matrice<Tile> matrice = new Matrice<>();
        for (int i = 0; i < integerList.size(); i += 3) {
            if (integerList.get(i) == -1 && integerList.get(i + 1) == 0) {
                System.out.println("current score : " + integerList.get(i + 2));
                int score = integerList.get(i + 2);
            } else {
                Coordonnees coordonnees = new Coordonnees(integerList.get(i), integerList.get(i + 1));
                matrice.getCasesMatrice().put(coordonnees,
                        new CaseMatrice<Tile>(coordonnees, Tile.tileFromInt(integerList.get(i + 2)), matrice));
            }
        }
        return matrice;
    }

    public static int nombreBlocksOnScreen(Matrice<Tile> matrice) {
        int a = 0;
        for (CaseMatrice<Tile> caseMatrice : matrice.getCasesMatrice().values()) {
            if (caseMatrice.getValeur() == Tile.BLOCK) {
                a += 1;
            }
        }
        return a;
    }

    @Test
    public void testd13p1() throws Exception {
        List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day13-Input");
        Machine machine = new Machine(longList);
        machine.execute();
        List<Integer> listOutputAsInt = getIntegerListFromLongList(machine.getListeOutput());
        Matrice<Tile> matrice = new Matrice<Tile>();
        matrice = readOutput(listOutputAsInt);
        Assert.assertEquals(nombreBlocksOnScreen(matrice), 462);
    }
}
