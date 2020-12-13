package katas.gossiping_drivers;

import katas.data.BusDriver;
import katas.reader.FileReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DriversBuilder {

    public List<BusDriver> build(String fileName) {
        final FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readLines(fileName);
        return lines.stream()
                .map(this::getRouts)
                .map(BusDriver::new)
                .collect(Collectors.toList());
    }

    private LinkedList<Integer> getRouts(String e) {
        return Arrays.stream(e.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
