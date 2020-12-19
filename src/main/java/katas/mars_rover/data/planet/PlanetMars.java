package katas.mars_rover.data.planet;

import katas.mars_rover.data.Obstacle;

import java.util.Set;

public class PlanetMars extends PlanetSurface{
    public PlanetMars(int dimensionX, int dimensionY, Set<Obstacle> obstacles) {
        super(dimensionX, dimensionY, obstacles);
    }
}
