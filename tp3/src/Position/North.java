package Position;

import Submarine.Nemo;

public class North extends Direction{
    @Override
    public Direction rotateLeft() {
        return new West();
    }

    @Override
    public Direction rotateRight() {
        return new East();
    }

    @Override
    public void moveForward(Nemo nemo) {
        Coordinates.coordinateY++;
    }
}
