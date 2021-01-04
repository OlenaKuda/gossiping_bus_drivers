package katas.mars_rover.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.command.Command;

import java.util.List;
import java.util.Set;

public class Navigator {
    private final CommandsService commandsService;

    public Navigator(CommandsService commandsService) {
        this.commandsService = commandsService;
    }

    public Rover navigate(Rover rover, List<String> stringCommands, Set<Coordinate> obstacles) throws Exception {

        for (String stringCommand : stringCommands) {
            Command command = commandsService.getCommand(stringCommand);
            Coordinate coordinateBeforeMove = command.getCoordinateBeforeMove(rover);
            System.out.println(coordinateBeforeMove.getX()+" "+coordinateBeforeMove.getY());
            if (isObstacle(coordinateBeforeMove, obstacles)){
                throw new Exception("Aborting! Obstacles were found! ");
            }
            command.apply(rover);
        }
        return rover;
    }

    private boolean isObstacle(Coordinate coordinateBeforeMove, Set<Coordinate> obstacles) {
        return obstacles.stream()
                .anyMatch(obstacle -> coordinateBeforeMove.getX() == (obstacle.getX()) || coordinateBeforeMove.getY() == (obstacle.getY()));
    }
}
