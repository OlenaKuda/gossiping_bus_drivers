package katas.gossiping_drivers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class GossipingDriversTest {

    GossipingDrivers gossipingDrivers = new GossipingDrivers();

    @ParameterizedTest
    @MethodSource("parameters")
    void countStops(String expected, String inputFileName) {
        String result = gossipingDrivers.countStops();
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("none", Arrays.asList(
                        Arrays.asList(3, 1, 2, 3),
                        Arrays.asList(3, 2, 3, 1),
                        Arrays.asList(4, 2, 3, 4, 5),
                        Arrays.asList(0, 0, 0, 0, 0, 0, 0))),
                Arguments.of("3", Arrays.asList(
                        Arrays.asList(2, 1, 2),
                        Arrays.asList(5, 1, 8),
                        Arrays.asList(5, 2, 8))),
                Arguments.of("2", Arrays.asList(
                        Arrays.asList(2, 1, 2),
                        Arrays.asList(5, 1, 8))),
                Arguments.of("none", Collections.emptyList())
        );
    }
}
