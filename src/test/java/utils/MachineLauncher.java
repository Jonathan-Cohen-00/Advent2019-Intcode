package utils;

import parsers.Parsers;
import machine.CodeInconnuException;
import machine.Machine;
import machine.ModeInconnuException;
import machine.PointeurException;

import java.io.IOException;
import java.util.List;

public interface MachineLauncher {
    default List<Integer> runMachineAndGetEndList(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
        List<Integer> integerList = Parsers.recupererListeEntiers(path);
        Machine machine = new Machine(integerList);
        machine.execute();
        return integerList;
    }
}
