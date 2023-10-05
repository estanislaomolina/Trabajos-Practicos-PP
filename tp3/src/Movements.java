import java.util.ArrayList;

public class Movements {
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
    public static void move(char command, Nemo nemo, Movements movements){
        switch (command) {
            case 'd' -> down(nemo, movements);
            case 'u' -> up(nemo, movements);
            case 'l' -> rotateLeft(nemo, movements);
            case 'r' -> rotateRight(nemo, movements);
            case 'f' -> moveForward(nemo, movements);
            case 'm' -> releaseCapsule(nemo, movements);
            default -> raiseInvalidCommandException();
        }
    }

    public static void down(Nemo nemo, Movements movements){
        movements.addCommand('d');
        nemo.depth--;
    }
    public static void up(Nemo nemo, Movements movements){
        movements.addCommand('u');
        nemo.depth++;
    }
    public static void rotateLeft(Nemo nemo, Movements movements){
        movements.addCommand('l');
        switch (nemo.cardinalPoint) {
            case "North" -> nemo.cardinalPoint = "West";
            case "West" -> nemo.cardinalPoint = "South";
            case "South" -> nemo.cardinalPoint = "East";
            case "East" -> nemo.cardinalPoint = "North";
        }
    }
    public static void rotateRight(Nemo nemo, Movements movements){
        movements.addCommand('r');
        switch (nemo.cardinalPoint) {
            case "North" -> nemo.cardinalPoint = "East";
            case "East" -> nemo.cardinalPoint = "South";
            case "South" -> nemo.cardinalPoint = "West";
            case "West" -> nemo.cardinalPoint = "North";
        }
    }
    public static void moveForward(Nemo nemo, Movements movements){
        movements.addCommand('f');
        switch (nemo.cardinalPoint) {
            case "North" -> nemo.coordinateY++;
            case "East" -> nemo.coordinateX++;
            case "South" -> nemo.coordinateY--;
            case "West" -> nemo.coordinateX--;
        }
    }
    public static void releaseCapsule(Nemo nemo, Movements movements){
        movements.addCommand('m');

    }

}
