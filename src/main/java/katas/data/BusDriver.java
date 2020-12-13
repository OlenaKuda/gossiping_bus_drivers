package katas.data;

import katas.gossiping_drivers.Gossip;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusDriver {
    private List<Integer> stops;
    private Set<Gossip> gossips = new HashSet<>();

    public BusDriver(List<Integer> stops) {
        this.stops = stops;
        gossips.add(new Gossip());
    }

    public List<Integer> getStops() {
        return stops;
    }

    public void setStops(List<Integer> stops) {
        this.stops = stops;
    }

    public Set<Gossip> getGossips() {
        return gossips;
    }

    public void setGossips(Set<Gossip> gossips) {
        this.gossips = gossips;
    }
}
