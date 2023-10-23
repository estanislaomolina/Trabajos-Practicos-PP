import Commands.Commands;
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
import static org.junit.Assert.assertThrows;


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
        positionCheck(initialCoordinates(), north(), initialDepth());
    }

    @Test public void test01DoNotMoveGivenAnEmptyListOfCommands() {
        nemo.move("");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(0, nemo.getCoordinates().getCoordinateY());
        assertEquals(north().getDirection(), nemo.currentCardinalPoint.getDirection());
        assertEquals(0, nemo.getDepth());
    }

    @Test public void test02MoveForward() {
        nemo.move("f");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(1, nemo.getCoordinates().getCoordinateY());
        assertEquals(north().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test03MoveDown() {
        nemo.move("d");
        assertEquals(-1, nemo.getDepth());
    }

    @Test public void test04RotateLeft() {
        nemo.move("l");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(0, nemo.getCoordinates().getCoordinateY());
        assertEquals(west().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test05RotateRight() {
        nemo.move("r");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(0, nemo.getCoordinates().getCoordinateY());
        assertEquals(east().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test06MoveUpWhenAlreadyAtDepth0() {
        nemo.move("u");
        assertEquals(0, nemo.getDepth());
    }
    @Test public void test07MoveUp () {
        nemo.move("d");
        nemo.move("d");
        nemo.move("u");
        assertEquals(-1, nemo.getDepth());
    }

    @Test public void test08ReleaseCapsule() {
        nemo.move("m");
        assertEquals( 1,nemo.capsulesReleased );
    }

    @Test public void test09ReleaseCapsuleInDepth1() {
        nemo.move("d");
        nemo.move("m");
        assertEquals( 1,nemo.capsulesReleased );
    }

    @Test public void test10DoNotReleaseCapsuleInDepthBelow1() {
        nemoExplodedCheck("ddm");
    }
    @Test public void test11MoveForwardMoreThanOneTimeInSameCommand() {
        nemo.move("ff");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(2, nemo.getCoordinates().getCoordinateY());
        assertEquals(north().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test12MoveForwardMoreThanOneTimeInDifferentCommands() {
        nemo.move("f");
        nemo.move("f");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(2, nemo.getCoordinates().getCoordinateY());
        assertEquals(north().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test13MoveAndTurnInSameCommand() {
        nemo.move("fr");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(1, nemo.getCoordinates().getCoordinateY());
        assertEquals(east().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test14MoveAndTurnInDifferentCommands() {
        nemo.move("f");
        nemo.move("r");
        assertEquals(0, nemo.getCoordinates().getCoordinateX());
        assertEquals(1, nemo.getCoordinates().getCoordinateY());
        assertEquals(east().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test15MoveAndTurnAndMoveInSameCommand() {
        nemo.move("frf");
        assertEquals(1, nemo.getCoordinates().getCoordinateX());
        assertEquals(1, nemo.getCoordinates().getCoordinateY());
        assertEquals(east().getDirection(), nemo.currentCardinalPoint.getDirection());
    }

    @Test public void test16MoveDownAndDropCapsuleInSameCommand() {
        nemo.move("dm");
        assertEquals(-1, nemo.getDepth());
        assertEquals(1, nemo.capsulesReleased);
    }

    private void positionCheck(Coordinates initialCoordinates, Direction direction, DepthState initialDepth) {
        assertEquals(0, initialCoordinates.getCoordinateX());
        assertEquals(0, initialCoordinates.getCoordinateY());
        assertEquals(direction.getDirection(), nemo.currentCardinalPoint.getDirection());
        assertEquals(0, initialDepth.getDepthState());
    }
    private void nemoExplodedCheck(String commands) {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> nemo.move(commands));
        assertEquals(exception.getMessage(), "Submarine destroyed due to excess chocolate.");
    }
}
