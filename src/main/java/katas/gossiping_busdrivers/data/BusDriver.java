package katas.gossiping_busdrivers.data;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BusDriver {
    private final Queue<Integer> stops;
    private Set<Gossip> gossips = new HashSet<>();

    public BusDriver(Queue<Integer> stops) {
        this.stops = stops;
        gossips.add(new Gossip(this));
    }

    public int getStop() {
        int stop = stops.remove();
        stops.add(stop);
        return stop;
    }

    public Set<Gossip> getGossips() {
        return gossips;
    }

    public void setGossips(Set<Gossip> gossips) {
        this.gossips = gossips;
    }
}
