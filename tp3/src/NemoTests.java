import Depths.Depth0;
import Depths.DepthState;
import Position.Coordinates;
import Position.Direction;
import Position.North;
import Position.South;
import Position.East;
import Position.West;
import Submarine.Nemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class NemoTests {
    private Nemo nemo;
    private Direction north() { return new North(); }
    private Direction south() { return new South(); }
    private Direction east() { return new East(); }
    private Direction west() { return new West(); }
    private DepthState initialDepth() { return new Depth0(); }
    private Coordinates initialCoordinates() { return new Coordinates(0,0); }

    @BeforeEach
    public void setUp() {
        nemo = new Nemo(initialCoordinates().getCoordinateX(), initialCoordinates().getCoordinateY(), north());
    }

    @Test public void test00InitialPosition() {
        //nemo = new Nemo(0, 0, north());
        positionCheck(initialCoordinates(), north(), initialDepth());
    }

    private void positionCheck(Coordinates initialCoordinates, Direction north, DepthState initialDepth) {

        assertEquals(0, initialCoordinates.getCoordinateX());
        assertEquals(0, initialCoordinates.getCoordinateY());
        assertEquals("North", nemo.currentCardinalPoint.getDirection());
        assertEquals(0, initialDepth.getDepthState());
    }

}
