package katas.mars_rover.data;

import java.util.Set;

public class Planet {

    private final int dimensionX;
    private final int dimensionY;
    private final Set<Coordinate> obstacles;

    public Planet(int dimensionX, int dimensionY, Set<Coordinate> obstacles) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.obstacles = obstacles;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public Set<Coordinate> getObstacles() {
        return obstacles;
    }
}
