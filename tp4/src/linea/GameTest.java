
package linea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest {
    private Linea linea5x5modeA;
    private Linea linea5x5modeB;
    private Linea linea5x5modeC;

    @BeforeEach
    public void setUp() {
        linea5x5modeA = new Linea(5, 5, 'A');
        linea5x5modeB = new Linea(5, 5, 'B');
        linea5x5modeC = new Linea(5, 5, 'C');
    }


    @Test
    public void test00BoardIsCreatedWithCorrectAmountOfColumns() {
        assertEquals(5, linea5x5modeC.board.size());
    }

    @Test
    public void test01BoardIsCreatedWithCorrectModeA() {
        assertEquals('A', linea5x5modeA.mode());
    }

    @Test
    public void test02BoardIsCreatedWithCorrectModeB() {
        assertEquals('B', linea5x5modeB.mode());
    }

    @Test
    public void test03BoardIsCreatedWithCorrectModeC() {
        assertEquals('C', linea5x5modeC.mode());
    }

    @Test
    public void test02ChipIsPlacedCorrectlyInBoard() {
        linea5x5modeC.playRedAt(1);
        assertEquals('O', linea5x5modeC.board.get(0).get(0));
    }

    @Test
    public void test03BlueCantPlayFirst() {
        assertThrowsLike(() -> linea5x5modeC.playBlueAt(1), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test04RedCantPlayIfNotItsTurn() {
        linea5x5modeC.playRedAt(1);
        assertThrowsLike(() -> linea5x5modeC.playRedAt(2), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test04BlueCantPlayIfNotItsTurn() {
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);

        assertThrowsLike(() -> linea5x5modeC.playBlueAt(2), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test05CantPlayFullColumn() {
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);
        linea5x5modeC.playRedAt(1);

        assertThrowsLike(() -> linea5x5modeC.playBlueAt(1), Linea.fullColumnErrorMessage);
    }

    @Test
    public void test06ModeAFinishesVertically() {
        verticalWinnerBoard();
        assertTrue(linea5x5modeA.finished());
    }

    @Test
    public void test07ModeAWontFinishVerticallyBefore4InLine() {
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);

        assertFalse(linea5x5modeB.finished());
    }

    @Test
    public void test08CantKeepPlayingAfterGameFinished() {
        verticalWinnerBoard();
        linea5x5modeA.finished();

        assertThrowsLike(() -> linea5x5modeA.playBlueAt(2), Linea.gameFinishedErrorMessage);
    }

    @Test
    public void test09ModeAFinishesHorizontally() {
        horizontalWinnerBoard();
        assertTrue(linea5x5modeA.finished());
    }

    @Test
    public void test10ModeBFinishesDiagonally() {
        diagonalWinnerBoard(linea5x5modeB);
        assertTrue(linea5x5modeB.finished());
    }

    @Test
    public void test11ModeCFinishesDiagonally() {
        diagonalWinnerBoard(linea5x5modeC);
        assertTrue(linea5x5modeC.finished());
    }

    private void assertThrowsLike(Executable executable, String message) {
        Assertions.assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private void verticalWinnerBoard() {
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(1);
    }
    private void horizontalWinnerBoard() {
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(1);
        linea5x5modeA.playRedAt(2);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(3);
        linea5x5modeA.playBlueAt(3);
        linea5x5modeA.playRedAt(4);
    }


    private void diagonalWinnerBoard(Linea linea) {
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(2);
        linea.playBlueAt(3);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(4);
        linea.playBlueAt(1);
        linea.playRedAt(4);
    }
}