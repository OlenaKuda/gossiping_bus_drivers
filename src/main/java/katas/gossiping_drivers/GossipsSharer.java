package katas.gossiping_drivers;

import katas.data.BusDriver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GossipsSharer {
    private final DriversManager driversManager = new DriversManager();

    public boolean areAllGossipsShared(Integer minute, List<BusDriver> drivers) {
        shareGossipsAt(minute, drivers);
        return isAllGossipsShared(drivers);
    }

    private Set<Gossip> shareGossipsAt(Integer minute, List<BusDriver> drivers) {
        drivers.stream()
                .collect(Collectors.groupingBy(driver -> driversManager.getStopAt(driver, minute)))
                .values()
                .forEach(this::shareGossips);
        return drivers.stream().flatMap(busDriver -> busDriver.getGossips().stream()).collect(Collectors.toSet());
    }

    private boolean isAllGossipsShared(List<BusDriver> drivers) {
        return drivers.stream()
                .allMatch(driver -> driver.getGossips().size() == drivers.size());
    }

    private void shareGossips(List<BusDriver> drivers) {
        Set<Gossip> sharedGossips = drivers.stream()
                .flatMap(driver -> driver.getGossips().stream())
                .collect(Collectors.toSet());
        drivers.forEach(busDriver -> busDriver.setGossips(sharedGossips));
    }
}
