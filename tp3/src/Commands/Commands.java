package Commands;

import Submarine.Nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Commands {
    private String name;
    private Consumer<Nemo> command;

    public Commands(String name, Consumer<Nemo> command) {
        this.name = name;
        this.command = command;
    }
    public static ArrayList<Commands> commands = new ArrayList<Commands>
            (Arrays.asList(
            new Commands("f", Nemo::moveForward),
            new Commands("d", Nemo::down),
            new Commands("u", Nemo::up),
            new Commands("l", Nemo::rotateLeft),
            new Commands("r", Nemo::rotateRight),
            new Commands("m", Nemo::releaseCapsule)
    ));

    public static Commands getCommand(String commandName) {
        return commands.stream()
                .filter(command -> command.commandEquals(commandName))
                .findFirst()
                .get();
    }

    public void runCommands(Nemo nemo) {
        command.accept(nemo);
    }
    public boolean commandEquals(String command){
        return this.name.equals(command);
    }
}
