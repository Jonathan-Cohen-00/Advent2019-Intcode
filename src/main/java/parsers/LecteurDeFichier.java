package parsers;

import matrice.CaseMatrice;
import matrice.Coordonnees;
import matrice.Matrice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LecteurDeFichier {
    public static List<String> lireFichierEnLignes(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
public static String lireUneSeuleLigneDuFichier (String path ) throws  IOException{
        return Files.readString(Path.of(path));
}
    public static Matrice<Integer> lireFichierEnMatriceDeNombresEntiers(String path) throws IOException {
        List<String> listeLignes = lireFichierEnLignes(path);
        Matrice<Integer> matrice = new Matrice<>();
        for (int i = 0; i < listeLignes.size(); i++) {
            for (int j = 0; j < listeLignes.get(i).length(); j++) {
                Coordonnees coordonnees = new Coordonnees(i, j);
                matrice.getCasesMatrice().put(coordonnees, new CaseMatrice<Integer>(coordonnees,
                        Integer.parseInt(listeLignes.get(i).charAt(j) + ""), matrice));
            }
        }
        return matrice;
    }
    public static Matrice <Character> lireFichierEnMatriceDeLettres (String path) throws IOException {
        List<String> listeLignes = lireFichierEnLignes(path);
        Matrice<Character> matrice = new Matrice<>();
        for (int i = 0; i < listeLignes.size(); i++) {
            for (int j = 0; j < listeLignes.get(i).length(); j++) {
                Coordonnees coordonnees = new Coordonnees(i, j);
                matrice.getCasesMatrice().put(coordonnees, new CaseMatrice<Character>(coordonnees,
                        listeLignes.get(i).charAt(j), matrice));
            }
        }
        return matrice;
    }
}