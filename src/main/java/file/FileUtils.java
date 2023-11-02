package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    public static List<String> lireFichierEnLignes(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }

    public static String lireUneSeuleLigneDuFichier(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
