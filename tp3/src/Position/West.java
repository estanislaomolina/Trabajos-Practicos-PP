package Position;

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
    public void moveForward(Coordinates nemo) {
        nemo.getCoordinates().addCoordinates(new Coordinates(-1, 0));
    }

    @Override
    public String getDirection() {
        return "West";
    }
}