package Position;

public class Coordinates {
    public static int coordinateX;
    public static int coordinateY;
    public int depth;
    public String cardinalPoint;

    public Coordinates(int coordinateX, int coordinateY, int depth, String cardinalPoint) {
        Coordinates.coordinateX = coordinateX;
        Coordinates.coordinateY = coordinateY;
        this.depth = depth;
        this.cardinalPoint = cardinalPoint;
    }

    public void up () {
        this.depth++;
    }
    public void down () {
        this.depth--;
    }

}
