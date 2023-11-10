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

    public static List<Integer> recupererListeEntiers(String path) throws IOException {
        String input = lireUneSeuleLigneDuFichier(path);
        Pattern parserPattern = Pattern.compile("(-?[0-9]+),?");
        List<Integer> integerList = new ArrayList<>();
        Matcher parserMatcher = parserPattern.matcher(input);
        while (parserMatcher.find()) {
            integerList.add(Integer.parseInt(parserMatcher.group(1)));
        }
        return integerList;
    }

}
//       faire liste d entiers a partir de liste de string
//        public void test(List<String> liste){
//        liste.stream().map(Integer::parseInt).toList();
//    }
//
// List<String> liste = Arrays.asList(input.split("s"))

