package katas.mars_rover.data;

import java.util.Set;

public class PlanetSurface {

    private final int dimensionX;
    private final int dimensionY;
    private final Set<Obstacle> obstacles;

    public PlanetSurface(int dimensionX, int dimensionY, Set<Obstacle> obstacles) {
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

    public Set<Obstacle> getObstacles() {
        return obstacles;
    }
}
