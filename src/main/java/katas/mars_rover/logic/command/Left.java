package katas.mars_rover.logic.command;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.DirectionService;

public class Left implements Command {
    private final DirectionService directionService;

    public Left(DirectionService directionService) {
        this.directionService = directionService;
    }

    @Override
    public void apply(Rover rover){
        Direction directionLeft = directionService.getDirectionLeft(rover);
        rover.setDirection(directionLeft);
    }

    public Coordinate getCoordinateBeforeMove(Rover rover) {
        return rover.getCoordinate();
    }
}
