package parsers;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsers {

    public static List<Long> recupererListeEntiers(String path) throws IOException {
        String input = Files.readString(Path.of(path));
        Pattern parserPattern = Pattern.compile("(-?[0-9]+),?");
        List<Long> integerList = new ArrayList<>();
        Matcher parserMatcher = parserPattern.matcher(input);
        while (parserMatcher.find()) {
            integerList.add(Long.parseLong(parserMatcher.group(1)));
        }
        for (int i = 0; i < 500; i++) {
            integerList.add(0L);
        }
        return integerList;
    }

    public static List<Integer> recupererListeEntiersINCORRECTE(String path) throws IOException {
        String input = Files.readString(Path.of(path));
        String[] inputSansVirugle = input.split(",");
        List<String> liste = Arrays.asList(inputSansVirugle);
        return liste.stream().map(k -> Integer.parseInt(k.trim())).toList();
    }
}