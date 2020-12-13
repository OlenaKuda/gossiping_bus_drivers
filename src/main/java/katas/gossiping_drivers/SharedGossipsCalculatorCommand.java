package katas.gossiping_drivers;

import katas.data.BusDriver;
import katas.data.Gossip;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SharedGossipsCalculatorCommand implements AbstractCommand<List<BusDriver>, String> {
    private final int MINUTES_PER_DAY;

    public SharedGossipsCalculatorCommand(int minutesPerDay) {
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
        shareGossipsAt(drivers);
        return isAllGossipsShared(drivers);
    }

    private void shareGossipsAt(List<BusDriver> drivers) {
        drivers.stream()
                .collect(Collectors.groupingBy(BusDriver::getStop))
                .values()
                .forEach(this::shareGossips);
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
