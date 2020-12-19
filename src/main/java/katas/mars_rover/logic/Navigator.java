package katas.mars_rover.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Rover;

import java.util.List;
import java.util.Optional;

public class Navigator {

    private final CoordinateService coordinateService;
    private final DirectionService directionService;

    public Navigator(CoordinateService coordinateService, DirectionService directionService) {
        this.coordinateService = coordinateService;
        this.directionService = directionService;
    }

    public Rover navigate(List<String> commands, Rover rover) throws Exception {
        String command = commands.get(1);
        Coordinate coordinate = rover.getCoordinate();

        if (command.equals("L") || command.equals("R")) {
            changeDirection(rover, command);
        }
        if (command.equals("F") || command.equals("B")) {
            coordinate = move(rover, command);
        }
        rover.setCoordinate(coordinate);
        return rover;
    }

    private void changeDirection(Rover rover, String command) throws Exception {
        String directionToSetToRover = directionService.getDirectionByCommand(command, rover);
        Optional<Direction> oDirectionToSet = directionService.getDirectionByName(directionToSetToRover);
        oDirectionToSet.ifPresent(rover::setDirection);
    }

    private Coordinate move(Rover rover, String command) {
        boolean isForward = command.equalsIgnoreCase("F");
        boolean isBackward = command.equalsIgnoreCase("B");
        Coordinate coordinate = rover.getCoordinate();
        boolean isEast = rover.getDirection().getName().equalsIgnoreCase("East");
        if (isEast) {
            if (isForward) {
                coordinate = coordinateService.getCoordinateEF(coordinate);
            }
            if (isBackward) {
                coordinate = coordinateService.getCoordinateEB(coordinate);
            }
        }
        boolean isWest = rover.getDirection().getName().equalsIgnoreCase("West");
        if (isWest) {
            if (isBackward) {
                coordinate = coordinateService.getCoordinatesWB(coordinate);
            }
            if (isForward) {
                coordinate = coordinateService.getCoordinatesWF(coordinate);
            }
        }
        return coordinate;
    }
}
