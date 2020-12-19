package katas.mars_rover;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.West;
import katas.mars_rover.data.Rover;
import katas.mars_rover.data.planet.PlanetMars;
import katas.mars_rover.logic.CoordinateService;
import katas.mars_rover.logic.DirectionService;
import katas.mars_rover.logic.Navigator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ExploreMarsApp {
    public static void main(String[] args) throws Exception {
        String inputCommands = "LRFFFBBBLLRBF";
        List<String> commands = Arrays.asList(inputCommands.split(""));

        Rover rover = new Rover(
                new Coordinate(2, 2),
                new West());
        PlanetMars planetMars = new PlanetMars(4, 8, new HashSet<>());
        CoordinateService coordinateService = new CoordinateService(planetMars);
        DirectionService directionService = new DirectionService();
        Navigator navigator = new Navigator(coordinateService, directionService);
        navigator.navigate(commands, rover);
    }
}
