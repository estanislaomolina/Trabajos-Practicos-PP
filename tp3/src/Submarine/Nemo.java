package Submarine;

import Position.Direction;

import java.util.ArrayList;

public class Nemo {
    public int coordinateX;
    public int coordinateY;
    public int depth;
    public String cardinalPoint;
    private Direction direction;


    public Nemo(int coordinateX, int coordinateY, int depth, String cardinalPoint) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.depth = depth;
        this.cardinalPoint = cardinalPoint;
    }

    public void commands (String command){
        this.command = command;
    }
    public void move (String directions){
        directions.
                toLowerCase().
                chars().
                forEach(direction -> { 
                    char directionChar = (char) direction; 
                    Commands
                            .commands
                            .stream()
                            .filter(command -> command.commandEquals(directionChar))
                            .forEach(command -> command.runCommands(this));
    }
    public void up() {
        this.depth++;
    }

    public void down() {
        this.depth--;
    }

    public void rotateRight() {
        direction = direction.rotateRight();
    }

    public void rotateLeft() {
        direction = direction.rotateLeft();
    }

    public void moveForward() {
        direction.moveForward(this);
    }

    public void releaseCapsule() {
        direction.releaseCapsule(this);
    }

    public void addDepth(Depths depth) {
        depths.add(depth);
    }
}