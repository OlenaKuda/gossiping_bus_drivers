package katas.mars_rover.data.logic;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Direction.West;
import katas.mars_rover.data.Obstacle;
import katas.mars_rover.data.planet.PlanetMars;
import katas.mars_rover.data.planet.PlanetSurface;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CoordinateService;
import katas.mars_rover.logic.DirectionService;
import katas.mars_rover.logic.Navigator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class NavigatorTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void navigatorTest(Coordinate expected, List<String> inputCommands, Rover inputRover) throws Exception {
        Set<Obstacle> obstacles = new HashSet<>();
        obstacles.add(new Obstacle());
        PlanetSurface marsSurface = new PlanetMars(4, 8, obstacles);
        CoordinateService coordinateService = new CoordinateService(marsSurface);
        DirectionService directionService = new DirectionService();
        Navigator navigator = new Navigator(coordinateService, directionService);

        Rover resultRover = navigator.navigate(inputCommands, inputRover);
        Coordinate resultCoordinate = resultRover.getCoordinate();

        assertThat(expected).isEqualTo(resultCoordinate);
        assertThat(expected.getX()).isEqualTo(resultCoordinate.getX());
        assertThat(expected.getY()).isEqualTo(resultCoordinate.getY());
    }

    private static Stream<Arguments> parameters(){
        West west = new West();
        Rover rover = new Rover(new Coordinate(1, 1), west);
        Rover rover2 = new Rover(new Coordinate(1, 8), west);
        Rover rover3 = new Rover(new Coordinate(4, 8), west);
        Rover rover4 = new Rover(new Coordinate(4, 1), west);
        Rover roverN = new Rover(new Coordinate(2, 7), west);
        List<String> commandsForward = Arrays.asList("L", "F");
        List<String> commandsBackward = Arrays.asList("L", "B");
        return Stream.of(
                of(new Coordinate(4, 8), commandsForward, rover),
                of(new Coordinate(4, 1), commandsForward, rover2),
                of(new Coordinate(3, 8), commandsForward, rover3),
                of(new Coordinate(3, 1), commandsForward, rover4),
                of(new Coordinate(1, 7), commandsForward, roverN),

                of(new Coordinate(2, 1), commandsBackward, new Rover(new Coordinate(1, 1), west)),
                of(new Coordinate(2, 8), commandsBackward, new Rover(new Coordinate(1, 8), west)),
                of(new Coordinate(1, 1), commandsBackward, new Rover(new Coordinate(4, 8), west)),
                of(new Coordinate(1, 8), commandsBackward, new Rover(new Coordinate(4, 1), west)),
                of(new Coordinate(3, 7), commandsBackward, new Rover(new Coordinate(2, 7), west))
        );
    }
}
