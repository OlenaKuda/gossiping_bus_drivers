package katas.gossiping_busdrivers.logic;

import katas.gossiping_busdrivers.data.BusDriver;
import katas.gossiping_busdrivers.data.Gossip;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class SharedGossipsExecutor implements AbstractExecutor<List<BusDriver>, String> {

    private final int MINUTES_PER_DAY;

    public SharedGossipsExecutor(int minutesPerDay) {
        MINUTES_PER_DAY = minutesPerDay;
    }

    @Override
    public String execute(List<BusDriver> drivers) {
        if (drivers.isEmpty()) {
            return "none";
        }
        return IntStream.range(1, MINUTES_PER_DAY)
                .filter(currentMinute -> areAllGossipsSharedAt(drivers))
                .mapToObj(String::valueOf)
                .findFirst()
                .orElse("none");
    }

    private boolean areAllGossipsSharedAt(List<BusDriver> drivers) {
        shareGossips(drivers);
        return drivers.stream()
                .allMatch(driver -> driver.getGossips().size() == drivers.size());
    }

    private void shareGossips(List<BusDriver> drivers) {
        drivers.stream()
                .collect(groupingBy(BusDriver::getStop))
                .values()
                .forEach(this::setGossips);
    }

    private void setGossips(List<BusDriver> drivers) {
        Set<Gossip> sharedGossips = drivers.stream()
                .flatMap(driver -> driver.getGossips().stream())
                .collect(toSet());
        drivers.forEach(busDriver -> busDriver.setGossips(sharedGossips));
    }
}
