package katas.gossiping_drivers;

import katas.data.BusDriver;
import katas.reader.RoutsReader;

import java.util.List;
import java.util.stream.Collectors;

public class DriversManager {

    private static final RoutsReader routsReader = new RoutsReader();

    private DriversManager() {
        //no instantiation
    }

    public static List<BusDriver> getDrivers() {
        List<List<Integer>> routs = routsReader.getRouts();
        return routs.stream()
                .map(rout -> {
                    BusDriver bd = new BusDriver();
                    bd.setStops(rout);
                    return bd;
                })
                .collect(Collectors.toList());
    }

    public static int getStopAt(BusDriver driver, int minute) {
        List<Integer> stops = driver.getStops();
        int size = stops.size();
        int indexOfStop = minute < size ? minute : minute % size;
        return stops.get(indexOfStop);
    }
}
