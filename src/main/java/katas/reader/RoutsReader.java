package katas.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoutsReader {
    private final String fileName = "src/main/resources/gossiping_drivers/input.txt";


    public List<List<Integer>> getRouts() {
        List<String> lines = readLines();
        return lines.stream()
                .map(e -> Arrays.stream(e.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(lines::add);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
