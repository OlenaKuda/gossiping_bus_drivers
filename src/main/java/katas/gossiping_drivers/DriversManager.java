package katas.gossiping_drivers;

import katas.data.BusDriver;
import katas.reader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DriversManager {
    private final FileReader fileReader = new FileReader();

    public List<BusDriver> getDrivers(String fileName) {
        List<List<Integer>> routs = getRouts(fileName);
        return routs.stream()
                .map(BusDriver::new)
                .collect(Collectors.toList());
    }

    public int getStopAt(BusDriver driver, int minute) {
        List<Integer> stops = driver.getStops();
        int size = stops.size();
        int indexOfStop = minute < size ? minute : minute % size;
        return stops.get(indexOfStop);
    }

    private List<List<Integer>> getRouts(String fileName) {
        List<String> lines = fileReader.readLines(fileName);
        return lines.stream()
                .map(e -> Arrays.stream(e.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
