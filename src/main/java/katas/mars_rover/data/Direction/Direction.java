package katas.mars_rover.data.Direction;

import katas.gossiping_busdrivers.data.BusDriver;
import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;

import java.util.Objects;


public abstract class Direction {

    public String getName() {
        Object a = getClass();
        return a.toString();
    }

    public abstract Direction getLeft();

    public abstract Direction getRight();

    public abstract Coordinate getForwardCoordinate(CoordinateService coordinateService, Rover rover);

    public abstract Coordinate getBackwardCoordinate(CoordinateService coordinateService, Rover rover);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return getName().equals(direction.getName());
    }
}
