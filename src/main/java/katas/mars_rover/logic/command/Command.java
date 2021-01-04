package katas.mars_rover.logic.command;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Rover;

public interface Command {

    void apply(Rover rover);
    Coordinate getCoordinateBeforeMove(Rover rover);

}
