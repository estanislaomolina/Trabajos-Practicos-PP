package Position;

import Submarine.Nemo;

public class West extends Direction{
    @Override
    public Direction rotateLeft() {
        return new South();
    }

    @Override
    public Direction rotateRight() {
        return new North();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordinates.coordinateX--;
    }
}