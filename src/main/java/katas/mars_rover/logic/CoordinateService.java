package katas.mars_rover.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Planet;

public class CoordinateService {
    private final Planet planet;

    public CoordinateService(Planet planet) {
        this.planet = planet;
    }

    /*public Coordinate getCoordinateWF(Coordinate coordinate) {
        return increaseX(coordinate);
    }

    public Coordinate getCoordinateToEastBackward(Coordinate coordinate) {
        return increaseX(coordinate);
    }

    public Coordinate getCoordinateEF(Coordinate coordinate) {
        return decreaseX(coordinate);
    }

    public Coordinate getCoordinateToWestBackward(Coordinate coordinate) {
        return decreaseX(coordinate);
    }

    public Coordinate getCoordinateNF(Coordinate coordinate) {
        return increaseY(coordinate);
    }

    public Coordinate getCoordinateToSouthBackward(Coordinate coordinate) {
        return increaseY(coordinate);
    }

    public Coordinate getCoordinateSF(Coordinate coordinate) {
        return decreaseY(coordinate);
    }

    public Coordinate getCoordinateToNorthBackward(Coordinate coordinate) {
        return decreaseY(coordinate);

    }
*/
    public Coordinate increaseY(Coordinate currentCoordinate) {
        int x = currentCoordinate.getX();
        int y = currentCoordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionX = x;
        int nextPositionY = y + 1;
        if (maxY < nextPositionY) {
            nextPositionY = 1;
            nextPositionX = (maxX - x) + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate decreaseY(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxY = planet.getDimensionY();
        int maxX = planet.getDimensionX();
        int nextPositionX = x;
        int nextPositionY = y - 1;
        if (nextPositionY <= 0) {
            nextPositionY = maxY;
            nextPositionX = (maxX - x) + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate decreaseX(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionX = x - 1;
        int nextPositionY = y;
        if (nextPositionX <= 0) {
            nextPositionX = maxX;
            nextPositionY = (maxY - y) + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }

    public Coordinate increaseX(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int maxX = planet.getDimensionX();
        int maxY = planet.getDimensionY();
        int nextPositionX = x + 1;
        int nextPositionY = y;
        if (maxX < nextPositionX) {
            nextPositionX = 1;
            nextPositionY = (maxY - y) + 1;
        }
        return new Coordinate(nextPositionX, nextPositionY);
    }
}
