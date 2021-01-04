package katas.mars_rover.logic.command;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.DirectionService;

public class Right implements Command {
    private final DirectionService directionService;

    public Right(DirectionService directionService) {
        this.directionService = directionService;
    }

    @Override
    public void apply(Rover rover){
        Direction directionRight = directionService.getDirectionRight(rover);
        rover.setDirection(directionRight);
    }

    public Coordinate getCoordinateBeforeMove(Rover rover) {
        return rover.getCoordinate();
    }
}
