package katas.gossiping_drivers;

import katas.data.BusDriver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CTest {

    Counter counter = new Counter();
    private final int MINUTES_PER_DAY = 30;
    private final DriversBuilder driversBuilder = new DriversBuilder();
    private final GossipShareManger manger = new GossipShareManger();

    @ParameterizedTest
    @MethodSource("parameters")
    void countStops(String expected, String inputFileName) {
        List<BusDriver> drivers = driversBuilder.getDrivers(inputFileName);
        String result = counter.count(drivers, MINUTES_PER_DAY, manger);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5", "src/main/resources/gossiping_drivers/test.txt"),
                Arguments.of("none", "src/main/resources/gossiping_drivers/testEmpty.txt")
        );
    }
}
