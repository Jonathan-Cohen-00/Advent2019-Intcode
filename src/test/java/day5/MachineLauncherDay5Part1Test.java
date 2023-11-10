package day5;

import parsers.Parsers;
import machine.Machine;
import utils.MachineLauncher;

import java.util.List;

public class MachineLauncherDay5Part1Test implements MachineLauncher {

//    @Test
//    public void testd5p1() throws Exception {
//        Assert.assertNull(runMachineAndGetEndList("src/main/resources/Day5Part1-Input"));
//    }

    public static void main(String[] args) throws Exception {
        List<Integer> integerList = Parsers.recupererListeEntiers("src/main/resources/Day5Part1-Input");
        Machine machine = new Machine(integerList);
        machine.setNextInput(1);
        machine.execute();
    }
//    public static void main(String[] args) throws Exception {
//        String input = Files.readString(Path.of("src/main/resources/Day5Part1-Input"));
//        String[] inputSansVirugle = input.split(",");
//        List<String> liste = Arrays.asList(inputSansVirugle);
//        System.out.println(liste);
//        List<Integer> liste2 = new ArrayList<>();
//        for (String string : liste) {
//            System.out.println(liste.indexOf(string));
//            liste2.add(Integer.parseInt(string));
//        }
//        System.out.println(liste2);
////        List<Integer> Liste2 = liste.stream().map(Integer::parseInt).toList();
//    }
}
