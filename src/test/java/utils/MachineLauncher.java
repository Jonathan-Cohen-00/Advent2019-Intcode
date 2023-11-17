package utils;

import parsers.Parsers;
import machine.CodeInconnuException;
import machine.Machine;
import machine.ModeInconnuException;
import machine.PointeurException;

import java.io.IOException;
import java.util.List;

public interface MachineLauncher {
//    default List<Long> runMachineAndGetEndList(String path) throws IOException, PointeurException, CodeInconnuException, ModeInconnuException {
//        List<Long> integerList = listeDepart(path);
//        return traitement(integerList);
//    }

    default List<Long> listeDepart(String path) throws IOException {
        return Parsers.recupererListeEntiers(path);
    }

//    default List<Long> traitement(List<Long> longList) throws IOException, ModeInconnuException, CodeInconnuException, PointeurException {
//        Machine machine = new Machine(longList);
//        machine.execute();
//        return longList;
//    }
    //override machin
}

