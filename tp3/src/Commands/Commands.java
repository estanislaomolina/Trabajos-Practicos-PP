package Commands;

import Submarine.Movements;
import Submarine.Nemo;

import java.util.ArrayList;

public abstract class Commands {
    private final ArrayList<Character> commands = new ArrayList<>();
    public boolean isEmpty() {
        return commands.isEmpty();
    }
    public ArrayList<Character> getCommands() {
        return commands;
    }
    private void addCommand(char command){
        commands.add(command);
    }
    private static void raiseInvalidCommandException() {
        throw new RuntimeException("Invalid command");
    }
/*    public static void move(char command, Nemo nemo, Movements movements){
        switch (command) {
            case 'd' -> down(nemo, movements);
            case 'u' -> up(nemo, movements);
            case 'l' -> rotateLeft(nemo, movements);
            case 'r' -> rotateRight(nemo, movements);
            case 'f' -> moveForward(nemo, movements);
            case 'm' -> releaseCapsule(nemo, movements);
            default -> raiseInvalidCommandException();
        }*/
    }
}
