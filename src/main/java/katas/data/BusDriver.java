package katas.data;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BusDriver {
    private List<Integer> stops;
    private List<String> gossips;

    public BusDriver() {
        this.gossips = Collections.singletonList(UUID.randomUUID().toString());
    }

    public List<Integer> getStops() {
        return stops;
    }

    public void setStops(List<Integer> stops) {
        this.stops = stops;
    }

    public List<String> getGossips() {
        return gossips;
    }

    public void setGossips(List<String> gossips) {
        this.gossips = gossips;
    }

}
