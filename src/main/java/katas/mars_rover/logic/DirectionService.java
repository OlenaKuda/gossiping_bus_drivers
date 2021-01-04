package katas.mars_rover.logic;

import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Direction.Directions;
import katas.mars_rover.data.Rover;

import java.util.Optional;

public class DirectionService {

    public Direction getDirectionLeft(Rover rover) {
        Direction direction = rover.getDirection();
        Direction newDirectionForRover;
        newDirectionForRover = direction.getLeft();
        return getDirection(newDirectionForRover).orElse(rover.getDirection());
    }

    public Direction getDirectionRight(Rover rover){
        Direction direction = rover.getDirection();
        Direction newDirectionForRover;
        newDirectionForRover = direction.getRight();
        return getDirection(newDirectionForRover).orElse(rover.getDirection());

    }

    public Optional<Direction> getDirection(Direction direction) {
        return Directions.getDirections().stream()
                .filter(newDirection -> newDirection.equals(direction))
                .findFirst();
    }
}
