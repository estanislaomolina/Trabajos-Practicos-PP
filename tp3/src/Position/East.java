package Position;

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
    public void moveForward(Coordinates nemo) {
        nemo.getCoordinates().addCoordinates(new Coordinates(1, 0));
    }
    @Override
    public String getDirection() {
        return "East";
    }
}