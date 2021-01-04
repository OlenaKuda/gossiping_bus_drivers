package katas.mars_rover.data.Direction;

import java.util.Arrays;
import java.util.List;

public final class Directions {

    private static final List<Direction> directions = Arrays.asList(
            new North(),
            new East(),
            new South(),
            new West()
    );

    public static List<Direction> getDirections() {
        return directions;
    }
}
