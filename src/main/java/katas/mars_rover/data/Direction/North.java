package katas.mars_rover.data.Direction;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;

public final class North extends Direction {

    @Override
    public Direction getLeft() {
        return new West();
    }

    @Override
    public Direction getRight() {
        return new East();
    }


    public Coordinate getForwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.increaseY(rover.getCoordinate());
    }

    public Coordinate getBackwardCoordinate(CoordinateService coordinateService, Rover rover) {
        return coordinateService.decreaseY(rover.getCoordinate());
    }
}
