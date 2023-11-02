package day;

import machine.CodeInconnuException;
import machine.PointeurException;

import java.io.IOException;

public interface DayPart {
    String part(String path) throws IOException, PointeurException, CodeInconnuException;

}
