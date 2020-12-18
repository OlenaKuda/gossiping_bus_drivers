package katas.mars_rover.logic;

import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Direction.Directions;
import katas.mars_rover.data.Rover;

import java.util.Optional;

public class DirectionService {

    public String getDirectionByCommand(String command, Rover rover) throws Exception {
        Direction direction = rover.getDirection();
        if (command.equalsIgnoreCase("L")) {
            return direction.getLeftNeighbor();
        }
        if (command.equalsIgnoreCase("R")) {
            return direction.getRightNeighbor();
        }
        throw new Exception("Wrong command! ");
    }

    public Optional<Direction> getDirectionByName(String name) {
        return Directions.getDirections().stream()
                .filter(direction -> direction.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
