import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NemoTest {

    public static final int initialCoordinateX = 0;
    public static final int initialCoordinateY = 0;
    public static final int initialDepth = 0;
    public static final String initialCardinalPoint = "North";
    private static Movements newMovements() {
        return new Movements();
    }
    ArrayList<Character> commands = new ArrayList<>();

    @ Test public void test00InitialPosition(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        assertEquals(initialCoordinateX, nemo.coordinateX);
        assertEquals(initialCoordinateY, nemo.coordinateY);
        assertEquals(initialDepth, nemo.depth);
        assertEquals(initialCardinalPoint, nemo.cardinalPoint);
    }
    @ Test public void test01DoNotMoveGivenAnEmptyListOfCommands(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        assertTrue(newMovements().isEmpty());
        assertEquals(initialCoordinateX, nemo.coordinateX);
        assertEquals(initialCoordinateY, nemo.coordinateY);
        assertEquals(initialDepth, nemo.depth);
        assertEquals(initialCardinalPoint, nemo.cardinalPoint);
    }
    @ Test public void test02MoveOneUnitDown(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('d');
        nemo.move(commands, newMovements());
        assertEquals(initialDepth -1, nemo.depth);

    }
    @ Test public void test03MoveOneUnitUp(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('u');
        nemo.move(commands, newMovements());
        assertEquals(initialDepth +1, nemo.depth);
    }
    @ Test public void test04TurnLeft(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('l');
        nemo.move(commands, newMovements());
        assertEquals("West", nemo.cardinalPoint);
    }
    @ Test public void test05TurnRight(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('r');
        nemo.move(commands, newMovements());
        assertEquals("East", nemo.cardinalPoint);
    }
    @Test public void test06MoveOneUnitForward(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('f');
        nemo.move(commands, newMovements());
        assertEquals(initialCoordinateY +1, nemo.coordinateY);
    }
    @Test public void test07ReleaseCapsule(){

    }
    @Test public void test08InvalidCommandShouldNotAffectItsPosition(){
        Nemo nemo = new Nemo (initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        commands.add('x');
        nemo.move(commands, newMovements());
        assertEquals(initialCoordinateX, nemo.coordinateX);
        assertEquals(initialCoordinateY, nemo.coordinateY);
        assertEquals(initialDepth, nemo.depth);
        assertEquals(initialCardinalPoint, nemo.cardinalPoint);
        try {
            nemo.move(commands, newMovements());
            fail("Expected an RuntimeException to be thrown");
        } catch (RuntimeException runtimeException) {
            assertEquals("Invalid command", runtimeException.getMessage());
        }
    }
}
