package day13;

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

public class D13P2Test implements MachineLauncher {

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
    private static int getLigneMatrice(Matrice<Tile> matrice ) {
        matrice.getCasesMatrice();
        return 0;
    }
    }
//    public static void afficherEcran (Matrice<Tile> matrice ) {
//        for (int i = 0 ; i<matrice  ; i++){
//
//        }
//    }
