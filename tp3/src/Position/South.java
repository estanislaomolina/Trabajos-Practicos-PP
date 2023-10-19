package Position;

import Submarine.Nemo;

public class South extends Direction{
    @Override
    public Direction rotateLeft() {
        return new East();
    }

    @Override
    public Direction rotateRight() {
        return new West();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordinates.coordinateY--;
    }
}