import katas.data.BusDriver;
import katas.gossiping_drivers.DriversBuilder;
import katas.gossiping_drivers.SharedGossipsCalculatorCommand;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileName = "src/main/resources/gossiping_drivers/input.txt";
        final int MINUTES_PER_DAY = 480;

        final DriversBuilder driversBuilder = new DriversBuilder();
        List<BusDriver> drivers = driversBuilder.build(fileName);

        final SharedGossipsCalculatorCommand command = new SharedGossipsCalculatorCommand(MINUTES_PER_DAY);

        String result = command.execute(drivers);
        System.out.println(result);
    }
}

