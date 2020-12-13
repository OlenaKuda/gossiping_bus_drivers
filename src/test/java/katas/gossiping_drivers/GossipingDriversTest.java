package katas.gossiping_drivers;

import katas.data.BusDriver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class GossipingDriversTest {

    GossipingDrivers gossipingDrivers = new GossipingDrivers();

    final DriversManager driversManager = new DriversManager();

    @ParameterizedTest
    @MethodSource("parameters")
    void countStops(String expected, String inputFileName) {
        List<BusDriver> drivers = driversManager.getDrivers(inputFileName);
        String result = gossipingDrivers.countStops(drivers);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5", "src/main/resources/gossiping_drivers/test.txt"),
                Arguments.of("none", "src/main/resources/gossiping_drivers/testEmpty.txt")
        );
    }
}
