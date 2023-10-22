package Position;

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
    public void moveForward(Coordinates nemo) {
        nemo.getCoordinates().addCoordinates(new Coordinates(0, -1));
    }

    @Override
    public String getDirection() {
        return "South";
    }
}