package day2;

import file.FileUtils;
import machine.CodeInconnuException;
import machine.Machine;
import machine.ModeInconnuException;
import machine.PointeurException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part1 {
    public static List<Integer> recupererListeEntiers(String path) throws IOException {
        String input = FileUtils.lireUneSeuleLigneDuFichier(path);
        Pattern parserPattern = Pattern.compile("([0-9]+),?");
        List<Integer> integerList = new ArrayList<>();
        Matcher parserMatcher = parserPattern.matcher(input);
        while (parserMatcher.find()) {
            integerList.add(Integer.parseInt(parserMatcher.group(1)));
        }
        return integerList;
    }

//    public void test(List<String> liste){
//        liste.stream().map(Integer::parseInt).toList();
//    }

// List<String> liste = Arrays.asList(input.split("s"))

    public String part(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
        List<Integer> integerList = recupererListeEntiers(path);
        Machine machine = new Machine(integerList);
        machine.execute();
        return String.valueOf(integerList.get(0));
    }
}