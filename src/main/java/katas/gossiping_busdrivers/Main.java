package katas.gossiping_busdrivers;

import katas.gossiping_busdrivers.data.BusDriver;
import katas.gossiping_busdrivers.logic.DriversBuilder;
import katas.gossiping_busdrivers.logic.SharedGossipsExecutor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileName = "src/main/resources/gossiping_drivers/input.txt";
        final int MINUTES_PER_DAY = 480;

        final DriversBuilder driversBuilder = new DriversBuilder(fileName);
        List<BusDriver> drivers = driversBuilder.build();

        final SharedGossipsExecutor executor = new SharedGossipsExecutor(MINUTES_PER_DAY);

        String result = executor.execute(drivers);
        System.out.println(result);
    }
}
