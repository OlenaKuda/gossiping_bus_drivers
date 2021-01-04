package katas.mars_rover.data.Direction;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;

public final class South extends Direction {


    @Override
    public Direction getLeft() {
        return new East();
    }

    @Override
    public Direction getRight() {
        return new West();
    }


    public Coordinate getForwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.decreaseY(rover.getCoordinate());
    }

    public Coordinate getBackwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.increaseY(rover.getCoordinate());
    }
}
