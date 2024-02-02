package day13;

import com.sun.source.tree.NewArrayTree;
import machine.Machine;
import machine.Tile;
import matrice.Matrice;
import parsers.Parsers;
import utils.MachineLauncher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static day13.D13P1Test.nombreBlocksOnScreen;
import static day13.D13P1Test.readOutput;
import static parsers.Parsers.getIntegerListFromLongList;
import static parsers.Parsers.getLongListFromIntegerList;

public class D13P2Test implements MachineLauncher {
//    @Test
//    public void testd13p2() throws Exception {
//        List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day13-Input");
//        longList.set(0 , 2L);
//        Machine machine = new Machine(longList, true );
//        machine.execute();
//        List<Integer> listOutputAsInt = getIntegerListFromLongList(machine.getListeOutput());
//        Matrice<Tile> matrice = new Matrice<Tile>();
//        matrice = readOutput(listOutputAsInt);
//        Assert.assertEquals(0 , 462);
//    }

        public static void main(String[] args) throws Exception {
        boolean win = false;
            while (!win) {
            List<Long> longList = Parsers.recupererListeEntiers("src/main/resources/Day13-Input");
            longList.set(0, 2L);
            Machine machine = new Machine(longList, true);
            machine.execute();
            List<Integer> listOutputAsInt = getIntegerListFromLongList(machine.getListeOutput());
            Matrice<Tile> matrice;
            matrice = readOutput(listOutputAsInt);
            System.out.println(nombreBlocksOnScreen(matrice));
            if (nombreBlocksOnScreen(matrice) == 0) {
                win = true;

            }
        }
    }

    public static List<Integer> listeAleatoire(int tailleListe) {
        List<Integer> list = new ArrayList<>();
        while (list.size() < tailleListe) {
            Random random = new Random();
            int randomNumber = random.nextInt(3) - 1;
            list.add(randomNumber);
        }
        return list;
    }
}