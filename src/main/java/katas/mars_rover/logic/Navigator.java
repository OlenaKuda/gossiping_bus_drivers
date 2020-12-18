package katas.mars_rover.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.PlanetSurface;
import katas.mars_rover.data.Rover;

import java.util.List;
import java.util.Optional;

public class Navigator {

    private final Explorer explorer;
    private final DirectionService directionService;

    public Navigator(Explorer explorer, DirectionService directionService) {
        this.explorer = explorer;
        this.directionService = directionService;
    }

    public Rover navigate(List<String> commands, Rover rover, PlanetSurface planet) throws Exception {
        String command = commands.get(1);
        Coordinate coordinate = rover.getCoordinate();

        if (command.equals("L") || command.equals("R")) {
            changeDirection(rover, command);
        }
        if (command.equals("F") || command.equals("B")) {
            coordinate = move(rover, command, planet);
        }
        rover.setCoordinate(coordinate);
        return rover;
    }

    private void changeDirection(Rover rover, String command) throws Exception {
        String directionToSetToRover = directionService.getDirectionByCommand(command, rover);
        Optional<Direction> oDirectionToSet = directionService.getDirectionByName(directionToSetToRover);
        oDirectionToSet.ifPresent(rover::setDirection);
    }

    private Coordinate move(Rover rover, String command, PlanetSurface planet) {
        boolean isForward = command.equalsIgnoreCase("F");
        boolean isBackward = command.equalsIgnoreCase("B");
        Coordinate coordinate = rover.getCoordinate();
        boolean isEast = rover.getDirection().getName().equalsIgnoreCase("East");
        if (isEast) {
            if (isForward) {
                coordinate = explorer.getCoordinateEF(coordinate, planet);
            }
            if (isBackward) {
                coordinate = explorer.getCoordinateEB(coordinate, planet);
            }
        }
        boolean isWest = rover.getDirection().getName().equalsIgnoreCase("West");
        if (isWest) {
            if (isBackward) {
                coordinate = explorer.getCoordinatesWB(coordinate, planet);
            }
            if (isForward) {
                coordinate = explorer.getCoordinatesWF(coordinate, planet);
            }
        }
        return coordinate;
    }
}
