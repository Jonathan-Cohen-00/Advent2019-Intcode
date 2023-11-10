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