package katas.gossiping_drivers;

import katas.data.BusDriver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GossipsSharer {

    public boolean areAllGossipsShared(Integer min, List<BusDriver> drivers) {
        shareGossipsAt(min, drivers);
        return isAllGossipsShared(drivers);
    }

    private void shareGossipsAt(Integer min, List<BusDriver> drivers) {
        drivers.stream()
                .collect(Collectors.groupingBy(driver -> DriversManager.getStopAt(driver, min)))
                .values().stream()
                .filter(driversOnStop -> driversOnStop.size() > 1)
                .forEach(driversOnStop -> {
                            int amountOfDriversOnStop = driversOnStop.size();
                            IntStream.range(0, amountOfDriversOnStop - 1)
                                    .forEach(driverIndex -> shareGossips(driversOnStop.get(driverIndex),
                                            driversOnStop.get(driverIndex + 1)));
                        }
                );
    }

    private boolean isAllGossipsShared(List<BusDriver> drivers) {
        return drivers.stream()
                .allMatch(driver -> driver.getGossips().size() == drivers.size());
    }

    private void shareGossips(BusDriver driverOne, BusDriver driverTwo) {
        List<String> gossipsFirstDriver = driverOne.getGossips();
        List<String> gossipsSecondDriver = driverTwo.getGossips();
        List<String> gossips = Stream.of(gossipsFirstDriver, gossipsSecondDriver)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        driverOne.setGossips(gossips);
        driverTwo.setGossips(gossips);
    }
}
