import Position.Direction;
import Position.North;
import Submarine.Nemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class NemoTests {
    private Nemo nemo;
    @BeforeEach
    public void setUp() {
        int initialCoordinateX = 0;
        int initialCoordinateY = 0;
        Direction initialCardinalPoint = new North();
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialCardinalPoint);
    }

    @Test
    public void test00InitialPosition() {
        positionCheck(nemo);
    }

    private void positionCheck(Nemo nemo) {
        assertEquals(0, nemo.coordinateX);
        assertEquals(0, nemo.coordinateY);
        assertEquals("North", nemo.currentCardinalPoint);
    }
}
