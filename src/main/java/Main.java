import katas.data.BusDriver;
import katas.gossiping_drivers.DriversManager;
import katas.gossiping_drivers.GossipingDrivers;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileName = "src/main/resources/gossiping_drivers/input.txt";
        final DriversManager driversManager = new DriversManager();
        List<BusDriver> drivers = driversManager.getDrivers(fileName);
        GossipingDrivers gossipingDrivers = new GossipingDrivers();
        String result = gossipingDrivers.countStops(drivers);
        System.out.println(result);
    }
}

