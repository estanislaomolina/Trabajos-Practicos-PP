package Submarine;

import java.util.ArrayList;

public class Nemo {
    public int coordinateX;
    public int coordinateY;
    public int depth;
    public String cardinalPoint;

    public Nemo(int coordinateX, int coordinateY, int depth, String cardinalPoint) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.depth = depth;
        this.cardinalPoint = cardinalPoint;
    }

    public void move(ArrayList<Character> commands, Movements movements) {
        for (char command : commands) {
            Movements.move(command, this, movements);
            if (depth > 0) {
                depth = 0;
                throw new RuntimeException("Invalid depth");
            }
        }
    }
}