package katas.mars_rover.data.Direction;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Obstacle;
import katas.mars_rover.data.PlanetSurface;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.DirectionService;
import katas.mars_rover.logic.Explorer;
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

class ExplorerTest {
    Explorer explorer = new Explorer();
    DirectionService directionService = new DirectionService();
    Navigator navigator = new Navigator(explorer, directionService);

    @ParameterizedTest
    @MethodSource("parameters")
    void ExplorerTest(Coordinate expected, List<String> inputCommands, Rover inputRover, PlanetSurface inputPlanet) throws Exception {
        Rover resultRover = navigator.navigate(inputCommands, inputRover, inputPlanet);
        Coordinate resultCoordinate = resultRover.getCoordinate();
        assertThat(expected).isEqualTo(resultCoordinate);
        assertThat(expected.getX()).isEqualTo(resultCoordinate.getX());
        assertThat(expected.getY()).isEqualTo(resultCoordinate.getY());

    }

    private static Stream<Arguments> parameters() throws Exception {
        Set<Obstacle> obstacles = new HashSet<>();
        obstacles.add(new Obstacle());
        West west = new West();
        Rover rover = new Rover(new Coordinate(1, 1), west);
        Rover rover2 = new Rover(new Coordinate(1, 8), west);
        Rover rover3 = new Rover(new Coordinate(4, 8), west);
        Rover rover4 = new Rover(new Coordinate(4, 1), west);
        Rover roverN = new Rover(new Coordinate(2, 7), west);
        PlanetSurface planetSurface = new PlanetSurface(4, 8, obstacles);
        List<String> commandsForward = Arrays.asList("L", "F");
        List<String> commandsBackward = Arrays.asList("L", "B");
        return Stream.of(
                of(new Coordinate(4, 8), commandsForward, rover, planetSurface),
                of(new Coordinate(4, 1), commandsForward, rover2, planetSurface),
                of(new Coordinate(3, 8), commandsForward, rover3, planetSurface),
                of(new Coordinate(3, 1), commandsForward, rover4, planetSurface),
                of(new Coordinate(1, 7), commandsForward, roverN, planetSurface),

                of(new Coordinate(2, 1), commandsBackward, new Rover(new Coordinate(1, 1), west), planetSurface),
                of(new Coordinate(2, 8), commandsBackward, new Rover(new Coordinate(1, 8), west), planetSurface),
                of(new Coordinate(1, 1), commandsBackward, new Rover(new Coordinate(4, 8), west), planetSurface),
                of(new Coordinate(1, 8), commandsBackward, new Rover(new Coordinate(4, 1), west), planetSurface),
                of(new Coordinate(3, 7), commandsBackward, new Rover(new Coordinate(2, 7), west), planetSurface)
        );
    }
}
