import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class NemoTest {

    public static final int initialCoordinateX = 0;
    public static final int initialCoordinateY = 0;
    public static final int initialDepth = 0;
    public static final String initialCardinalPoint = "North";

    @ Test public void test00InitialPosition(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);
        assertEquals(initialCoordinateX, nemo.coordinateX);
        assertEquals(initialCoordinateY, nemo.coordinateY);
        assertEquals(initialDepth, nemo.depth);
        assertEquals(initialCardinalPoint, nemo.cardinalPoint);
    }
    @ Test public void test01DoNotMoveGivenAnEmptyListOfCommands(){
        Nemo nemo = new Nemo(initialCoordinateX, initialCoordinateY, initialDepth, initialCardinalPoint);

    }
    @ Test public void test02MoveOneUnitDown(){

    }
    @ Test public void test03MoveOneUnitUp(){

    }
    @ Test public void test04TurnLeft(){

    }
    @ Test public void test05TurnRight(){

    }
    @Test public void test06MoveOneUnitForward(){

    }
    @Test public void test07ReleaseCapsule(){

    }
    @Test public void tets08InvalidCommand(){

    }
}
