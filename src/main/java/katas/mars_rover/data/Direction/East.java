package katas.mars_rover.data.Direction;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;

public final class East extends Direction {


    @Override
    public Direction getLeft() {
        return new North();
    }

    @Override
    public Direction getRight() {
        return new South();
    }


    public Coordinate getForwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.increaseX(rover.getCoordinate());
    }

    public Coordinate getBackwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.decreaseX(rover.getCoordinate());
    }
}
