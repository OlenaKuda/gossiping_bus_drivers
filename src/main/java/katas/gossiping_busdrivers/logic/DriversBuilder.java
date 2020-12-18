package katas.gossiping_busdrivers.logic;

import katas.gossiping_busdrivers.data.BusDriver;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static katas.gossiping_busdrivers.util.FileReader.readLines;

public class DriversBuilder {
    private final String fileName;

    public DriversBuilder(String fileName) {
        this.fileName = fileName;
    }

    public List<BusDriver> build() {
        List<String> lines = readLines(fileName);
        return lines.stream()
                .map(this::getRouts)
                .map(BusDriver::new)
                .collect(toList());
    }

    private LinkedList<Integer> getRouts(String e) {
        return stream(e.split(" "))
                .map(Integer::parseInt)
                .collect(toCollection(LinkedList::new));
    }
}
