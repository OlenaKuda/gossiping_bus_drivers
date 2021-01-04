package katas.mars_rover;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.West;
import katas.mars_rover.data.Planet;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CommandsService;
import katas.mars_rover.logic.CoordinateService;
import katas.mars_rover.logic.DirectionService;
import katas.mars_rover.logic.Navigator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ExploreMarsApp {
    public static void main(String[] args) throws Exception {

        Rover rover = new Rover(new Coordinate(2, 7), new West());

        HashSet<Coordinate> obstacles = new HashSet<>(Arrays.asList(new Coordinate(3, 5)));
        Planet planet = new Planet(4, 8, obstacles);

        CoordinateService coordinateService = new CoordinateService(planet);
        DirectionService directionService = new DirectionService();
        CommandsService commandsService = new CommandsService(coordinateService, directionService);
        Navigator navigator = new Navigator(commandsService);

        List<String> commands = Arrays.asList("L","R","L","L","F","F","L","B","F","F","F","R");
        navigator.navigate(rover, commands, obstacles);
        System.out.println("Result: " + rover.getDirection().getName() + " x" + rover.getCoordinate().getX() + ", y" + rover.getCoordinate().getY());
        System.out.println("Expected: East x1, y1");
    }
}
