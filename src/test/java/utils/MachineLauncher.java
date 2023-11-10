package utils;

import file.FileUtils;
import machine.CodeInconnuException;
import machine.Machine;
import machine.ModeInconnuException;
import machine.PointeurException;

import java.io.IOException;
import java.util.List;

public interface MachineLauncher {
    default List<Integer> runMachineAndGetEndList(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
        List<Integer> integerList = FileUtils.recupererListeEntiers(path);
        Machine machine = new Machine(integerList);
        machine.execute();
        return integerList;
    }
}
