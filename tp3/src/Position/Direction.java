package Position;

import Submarine.Nemo;

public abstract class Direction {
    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract void moveForward(Nemo nemo);
}
