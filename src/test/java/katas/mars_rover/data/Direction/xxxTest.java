package katas.mars_rover.data.Direction;

import katas.mars_rover.data.Coordinate;
import katas.mars_rover.data.Planet;
import katas.mars_rover.data.Rover;
import katas.mars_rover.logic.CommandsService;
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

class xxxTest {
    Set<Coordinate> obstacles = new HashSet<>(Arrays.asList(new Coordinate(0, 0)));
    Planet planet = new Planet(4, 8, obstacles);
    CoordinateService coordinateService = new CoordinateService(planet);
    DirectionService directionService = new DirectionService();
    CommandsService commandsService = new CommandsService(coordinateService, directionService);
    Navigator navigator = new Navigator(commandsService);

    @ParameterizedTest
    @MethodSource("parametersMove")
    void explore(Coordinate expected, List<String> inputCommands, Rover inputRover) throws Exception {
        Rover resultRover = navigator.navigate(inputRover, inputCommands, obstacles);
        Coordinate resultCoordinate = resultRover.getCoordinate();
        assertThat(expected).isEqualTo(resultCoordinate);
        assertThat(expected.getX()).isEqualTo(resultCoordinate.getX());
        assertThat(expected.getY()).isEqualTo(resultCoordinate.getY());

    }

    @ParameterizedTest
    @MethodSource("parametersTurn")
    void exploreTurn(Direction expected, List<String> inputCommands, Rover inputRover) throws Exception {
        Rover resultRover = navigator.navigate(inputRover, inputCommands, obstacles);
        Direction result = resultRover.getDirection();
        assertThat(expected).isEqualTo(result);
    }

    private static Stream<Arguments> parametersMove() {

        Set<Coordinate> obstacles = new HashSet<>(Arrays.asList(new Coordinate(2, 2)));
        List<String> commandsForward = Arrays.asList("F");
        List<String> commandsBackwards = Arrays.asList("B");
        return Stream.of(
                //West Forward
                of(new Coordinate(4, 8), commandsForward, new Rover(new Coordinate(1, 1), new West())),
                of(new Coordinate(4, 1), commandsForward, new Rover(new Coordinate(1, 8), new West())),
                of(new Coordinate(3, 8), commandsForward, new Rover(new Coordinate(4, 8), new West())),
                of(new Coordinate(3, 1), commandsForward, new Rover(new Coordinate(4, 1), new West())),
                of(new Coordinate(1, 7), commandsForward, new Rover(new Coordinate(2, 7), new West())),

                //West Backward
                of(new Coordinate(2, 1), commandsBackwards, new Rover(new Coordinate(1, 1), new West())),
                of(new Coordinate(2, 8), commandsBackwards, new Rover(new Coordinate(1, 8), new West())),
                of(new Coordinate(1, 1), commandsBackwards, new Rover(new Coordinate(4, 8), new West())),
                of(new Coordinate(1, 8), commandsBackwards, new Rover(new Coordinate(4, 1), new West())),
                of(new Coordinate(3, 7), commandsBackwards, new Rover(new Coordinate(2, 7), new West())),

                //East Forward
                of(new Coordinate(1, 1), commandsForward, new Rover(new Coordinate(4, 8), new East())),
                of(new Coordinate(1, 8), commandsForward, new Rover(new Coordinate(4, 1), new East())),
                of(new Coordinate(1, 2), commandsForward, new Rover(new Coordinate(4, 7), new East())),
                of(new Coordinate(3, 7), commandsForward, new Rover(new Coordinate(2, 7), new East())),
                of(new Coordinate(1, 7), commandsForward, new Rover(new Coordinate(4, 2), new East())),

                //East Backward
                of(new Coordinate(4, 1), commandsBackwards, new Rover(new Coordinate(1, 8), new East())),
                of(new Coordinate(4, 8), commandsBackwards, new Rover(new Coordinate(1, 1), new East())),
                of(new Coordinate(1, 7), commandsBackwards, new Rover(new Coordinate(2, 7), new East())),
                of(new Coordinate(4, 7), commandsBackwards, new Rover(new Coordinate(1, 2), new East())),
                of(new Coordinate(3, 4), commandsBackwards, new Rover(new Coordinate(4, 4), new East())),

                //North Forward
                of(new Coordinate(4, 1), commandsForward, new Rover(new Coordinate(1, 8), new North())),
                of(new Coordinate(1, 2), commandsForward, new Rover(new Coordinate(1, 1), new North())),
                of(new Coordinate(2, 8), commandsForward, new Rover(new Coordinate(2, 7), new North())),
                of(new Coordinate(1, 1), commandsForward, new Rover(new Coordinate(4, 8), new North())),
                of(new Coordinate(3, 1), commandsForward, new Rover(new Coordinate(2, 8), new North())),

                //North Backward
                of(new Coordinate(4, 8), commandsBackwards, new Rover(new Coordinate(1, 1), new North())),
                of(new Coordinate(1, 8), commandsBackwards, new Rover(new Coordinate(4, 1), new North())),
                of(new Coordinate(2, 8), commandsBackwards, new Rover(new Coordinate(3, 1), new North())),
                of(new Coordinate(3, 3), commandsBackwards, new Rover(new Coordinate(3, 4), new North())),
                of(new Coordinate(3, 7), commandsBackwards, new Rover(new Coordinate(3, 8), new North())),

                //South Forward
                of(new Coordinate(1, 7), commandsForward, new Rover(new Coordinate(1, 8), new South())),
                of(new Coordinate(4, 8), commandsForward, new Rover(new Coordinate(1, 1), new South())),
                of(new Coordinate(1, 8), commandsForward, new Rover(new Coordinate(4, 1), new South())),
                of(new Coordinate(2, 6), commandsForward, new Rover(new Coordinate(2, 7), new South())),
                of(new Coordinate(3, 8), commandsForward, new Rover(new Coordinate(2, 1), new South())),

                //South Backward
                of(new Coordinate(1, 2), commandsBackwards, new Rover(new Coordinate(1, 1), new South())),
                of(new Coordinate(4, 2), commandsBackwards, new Rover(new Coordinate(4, 1), new South())),
                of(new Coordinate(3, 2), commandsBackwards, new Rover(new Coordinate(3, 1), new South())),
                of(new Coordinate(1, 1), commandsBackwards, new Rover(new Coordinate(4, 8), new South())),
                of(new Coordinate(4, 1), commandsBackwards, new Rover(new Coordinate(1, 8), new South()))
        );
    }

    private static Stream<Arguments> parametersTurn() {

        Set<Coordinate> obstacles = new HashSet<>(Arrays.asList(new Coordinate(2, 2)));
        List<String> commandsLeft = Arrays.asList("L");
        List<String> commandsRight = Arrays.asList("R");
        return Stream.of(
                //To Left
                of(new South(), commandsLeft, new Rover(new Coordinate(1, 1), new West())),
                of(new East(), commandsLeft, new Rover(new Coordinate(1, 8), new South())),
                of(new North(), commandsLeft, new Rover(new Coordinate(4, 8), new East())),
                of(new West(), commandsLeft, new Rover(new Coordinate(4, 1), new North())),

                //To Right
                of(new North(), commandsRight, new Rover(new Coordinate(1, 1), new West())),
                of(new East(), commandsRight, new Rover(new Coordinate(1, 8), new North())),
                of(new South(), commandsRight, new Rover(new Coordinate(4, 8), new East())),
                of(new West(), commandsRight, new Rover(new Coordinate(4, 1), new South()))
        );
    }
}
