package Submarine;

import Depths.Depth0;
import Depths.DepthState;
import Position.Coordinates;
import Position.Direction;
import Commands.Commands;

import java.util.ArrayList;

public class Nemo {
    private  Coordinates currentCoordinates;
    public Direction currentCardinalPoint;
    private ArrayList<DepthState> depthState = new ArrayList<>();
    public int coordinateX;
    public int coordinateY;

    public int capsulesReleased = 0;



    public Nemo(int coordinateX, int coordinateY, Direction currentCardinalPoint) {
        this.currentCoordinates = new Coordinates(coordinateX, coordinateY);
        this.currentCardinalPoint = currentCardinalPoint;
        depthState.add (new Depth0());
    }

    public void command(String commands) {
        commands.chars().forEach(command -> move(String.valueOf((char) command)));
    }

    public void move(String command) {
            for (int i = 0; i < command.length(); i++) {
                Commands.getCommand(String.valueOf(command.charAt(i))).runCommands(this);
            }
        }

        public Coordinates getCoordinates() {
        return this.currentCoordinates;
    }
    public Direction getDirection() {
        return this.currentCardinalPoint;
    }
    public int getDepth() {
        return depthState.get(depthState.size() - 1).getDepthState();
    }

    public void moveForward() {
        currentCardinalPoint.moveForward(this.getCoordinates());
    }

    public void down() {
        depthState.get(depthState.size() - 1).down(this);
    }

    public void up() {
        depthState.get(depthState.size() - 1).up(this);
    }

    public void rotateLeft() {
        currentCardinalPoint = currentCardinalPoint.rotateLeft();
    }

    public void rotateRight() {
        currentCardinalPoint = currentCardinalPoint.rotateRight();
    }

    public void releaseCapsule() {
        depthState.get(depthState.size() - 1).releaseCapsule(this);
    }

    public void setDepth(DepthState currentDepth) {
        depthState.add(currentDepth);
    }

    public void removeDepth() {
        depthState.remove(depthState.size() - 1);
    }
}