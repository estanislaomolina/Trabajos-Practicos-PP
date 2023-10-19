package Position;

import Submarine.Nemo;

public class East extends Direction{
    @Override
    public Direction rotateLeft() {
        return new North();
    }

    @Override
    public Direction rotateRight() {
        return new South();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordinates.coordinateX++;

    }
}