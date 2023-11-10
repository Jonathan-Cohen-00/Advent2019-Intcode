package day5;

import parsers.Parsers;
import machine.Machine;
import utils.MachineLauncher;

import java.util.List;

public class MachineLauncherDay5Part2Test implements MachineLauncher {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = Parsers.recupererListeEntiers("src/main/resources/Day5Part2-Input");
        Machine machine = new Machine(integerList);
        machine.execute();
    }
}