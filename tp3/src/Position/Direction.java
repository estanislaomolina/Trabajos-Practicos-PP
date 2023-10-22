package Position;

public abstract class Direction {
    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract void moveForward(Coordinates nemo);
    public abstract String getDirection();

}
