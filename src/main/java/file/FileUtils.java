package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static List<String> lireFichierEnLignes(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }

    public static String lireUneSeuleLigneDuFichier(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static List<Integer> separerEntierEnChiffres(int nb) {
        String nbEnString = String.valueOf(nb);
        List<Integer> listeDesChiffres = new ArrayList<>();
        Pattern chiffreUniquePattern = Pattern.compile("([0-9])");
        Matcher chiffreUniqueMatcher = chiffreUniquePattern.matcher(nbEnString);
        while (chiffreUniqueMatcher.find()) {
            listeDesChiffres.add(Integer.valueOf(chiffreUniqueMatcher.group(1)));
        }
        return listeDesChiffres;
    }
}
