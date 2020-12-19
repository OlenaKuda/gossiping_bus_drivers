package katas.gossiping_busdrivers.logic;

import katas.gossiping_busdrivers.data.BusDriver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class SharedGossipsExecutorTest {

    private final int MINUTES_PER_DAY = 30;
    private final SharedGossipsExecutor gossipsExecutor = new SharedGossipsExecutor(MINUTES_PER_DAY);

    @ParameterizedTest
    @MethodSource("parameters")
    void execute(String expected, String inputFile) {
        final DriversBuilder driversBuilder = new DriversBuilder(inputFile);
        List<BusDriver> drivers = driversBuilder.build();
        String result = gossipsExecutor.execute(drivers);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("5", "src/main/resources/gossiping_drivers/test.txt"),
                of("none", "src/main/resources/gossiping_drivers/testEmpty.txt")
        );
    }
}
