package katas.mars_rover.logic;

import katas.mars_rover.logic.command.Backward;
import katas.mars_rover.logic.command.Command;
import katas.mars_rover.logic.command.Forward;
import katas.mars_rover.logic.command.Left;
import katas.mars_rover.logic.command.Right;

import java.util.Arrays;
import java.util.List;

public class CommandsService {

    private final CoordinateService coordinateService;
    private final DirectionService directionService;



    public CommandsService(CoordinateService coordinateService, DirectionService directionService) {
        this.coordinateService = coordinateService;
        this.directionService = directionService;


    }

    public Command getCommand(String command) {
        switch (command.toUpperCase()) {
            case "F": {
                int indexForward = 0;
                return getCommands().get(indexForward);
            }
            case "B": {
                int indexBackwards = 1;
                return getCommands().get(indexBackwards);
            }
            case "L": {
                int indexLeft = 2;
                return getCommands().get(indexLeft);
            }
            case "R": {
                int indexRight = 3;
                return getCommands().get(indexRight);
            }
        }
        throw new IllegalArgumentException("Command is not aloud! ");
    }

    private List<Command> getCommands() {
        return Arrays.asList(
                new Forward(coordinateService),
                new Backward(coordinateService),
                new Left(directionService),
                new Right(directionService)
        );
    }
}
