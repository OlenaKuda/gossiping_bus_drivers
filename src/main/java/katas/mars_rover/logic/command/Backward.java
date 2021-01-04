package katas.mars_rover.logic.command;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.Direction;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;

public class Backward implements Command {

    private final CoordinateService coordinateService;

    public Backward(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @Override
    public void apply(Rover rover) {
        rover.setCoordinate(getCoordinateBeforeMove(rover));
    }

    public Coordinate getCoordinateBeforeMove(Rover rover) {
        Direction direction = rover.getDirection();
        return direction.getBackwardCoordinate(coordinateService, rover);
    }
}
