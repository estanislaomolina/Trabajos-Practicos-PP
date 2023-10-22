package Position;

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
    public void moveForward(Coordinates nemo) {
        nemo.getCoordinates().addCoordinates(new Coordinates(0, 1));
    }
    @Override
    public String getDirection() {
        return "North";
    }
}
