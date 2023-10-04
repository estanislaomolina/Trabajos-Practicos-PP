import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.awt.Point;

public class NemoTest {
    public static final Point initialCoordinates = new Point(0, 0);
    @ Test public void test00InitialPosition(){
        Nemo nemo = newNemo();
        assertTrue(nemo.coordiantes == initialCoordinates);
    }
}
