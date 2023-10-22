package Position;

public class Coordinates {
    int coordinateX;
    int coordinateY;

    public Coordinates(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
    public int getCoordinateX() {
        return this.coordinateX;
    }
    public int getCoordinateY() {
        return this.coordinateY;
    }
    public boolean equals(Coordinates coordinates) {
        return (this.coordinateX == coordinates.coordinateX && this.coordinateY == coordinates.coordinateY);
    }
    public Coordinates getCoordinates() {
        return this;
    }
    public Coordinates addCoordinates(Coordinates coordinates) {
        return new Coordinates(this.getCoordinates().coordinateX += coordinates.getCoordinateX(), this.getCoordinates().coordinateY += coordinates.getCoordinateY());
    }
}
