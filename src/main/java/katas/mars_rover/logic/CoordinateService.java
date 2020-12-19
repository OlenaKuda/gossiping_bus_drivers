package katas.mars_rover.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.planet.PlanetSurface;

public class Explorer {
    private final PlanetSurface planet;

    public Explorer(PlanetSurface planet) {
        this.planet = planet;
    }

    public Coordinate getCoordinateEB(Coordinate coordinate) {
        int x = coordinate.getX();
        int nextPositionY = coordinate.getY();
        int maxX = planet.getDimensionX();
        int nextPositionX = x - 1;
        if (nextPositionX <= 0) {
            nextPositionX = maxX - x;
            nextPositionY = 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate getCoordinateEF(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionX = x + 1;
        int nextPositionY = y;
        if (maxX < nextPositionX) {
            nextPositionX = 1;
            nextPositionY = maxY - y + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate getCoordinatesWF(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionY = y;
        int nextPositionX = x - 1;
        if (nextPositionX <= 0) {
            nextPositionX = maxX;
            nextPositionY = maxY - y + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate getCoordinatesWB(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionY = y;
        int nextPositionX = x + 1;
        if (maxX < nextPositionX) {
            nextPositionX = 1;
            nextPositionY = maxY - y + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }
}
