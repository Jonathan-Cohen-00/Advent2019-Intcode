package parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsers {

    public static List<Integer> recupererListeEntiers(String path) throws IOException {
        String input = Files.readString(Path.of(path));
        Pattern parserPattern = Pattern.compile("(-?[0-9]+),?");
        List<Integer> integerList = new ArrayList<>();
        Matcher parserMatcher = parserPattern.matcher(input);
        while (parserMatcher.find()) {
            integerList.add(Integer.parseInt(parserMatcher.group(1)));
        }
        return integerList;
    }
}

//    public static List<Integer> separerEntierEnChiffres(int nb) {
//        String nbEnString = String.valueOf(nb);
//        List<Integer> listeDesChiffres = new ArrayList<>();
//        Pattern chiffreUniquePattern = Pattern.compile("([0-9])");
//        Matcher chiffreUniqueMatcher = chiffreUniquePattern.matcher(nbEnString);
//        while (chiffreUniqueMatcher.find()) {
//            listeDesChiffres.add(Integer.valueOf(chiffreUniqueMatcher.group(1)));
//        }
//        return listeDesChiffres;
//    }
//
//    public static List<Integer> recupererListeEntiers2(String path) throws IOException {
//        String input = Files.readString(Path.of(path));
//        String[] inputSansVirugle = input.split(",");
//        List<String> liste = Arrays.asList(inputSansVirugle);
//        return liste.stream().map(Integer::valueOf).toList();
//    }