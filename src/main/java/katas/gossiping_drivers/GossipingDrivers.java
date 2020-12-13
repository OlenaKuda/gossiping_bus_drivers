package katas.gossiping_drivers;

import katas.data.BusDriver;

import java.util.List;
import java.util.stream.IntStream;

public class GossipingDrivers {
    private final int MINUTES_PER_DAY = 480;
    private final GossipsSharer gossipsSharer = new GossipsSharer();

    public String countStops(List<BusDriver> drivers) {

        if (drivers.isEmpty()) {
            return "none";
        }
        return run(drivers);
    }

    private String run(List<BusDriver> drivers) {
        return IntStream.range(0, MINUTES_PER_DAY)
                .filter(min -> gossipsSharer.areAllGossipsShared(min, drivers))
                .map(i -> i + 1)
                .mapToObj(String::valueOf)
                .findFirst()
                .orElse("none");
    }
}
