package katas.gossiping_busdrivers.util;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.Collections.emptyList;

public class FileReader {

    private FileReader() {
    }

    public static List<String> readLines(String fileName) {
        try {
            return readAllLines(get(fileName), UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return emptyList();
        }
    }
}
