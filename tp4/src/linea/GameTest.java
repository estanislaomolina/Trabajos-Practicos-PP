
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
    public void test04ChipIsPlacedCorrectlyInBoardForRedModeA() {
        linea5x5modeA.playRedAt(1);
        assertEquals('O', linea5x5modeC.board.get(0).get(0));
    }
    @Test
    public void test05ChipIsPlacedCorrectlyInBoardForRedModeB() {
        linea5x5modeB.playRedAt(1);
        assertEquals('O', linea5x5modeC.board.get(0).get(0));
    }
    @Test
    public void test06ChipIsPlacedCorrectlyInBoardForRedModeC() {
        linea5x5modeC.playRedAt(1);
        assertEquals('O', linea5x5modeC.board.get(0).get(0));
    }

    @Test
    public void test07BlueCantPlayFirstModeA() {
        assertThrowsLike(() -> linea5x5modeA.playBlueAt(1), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test08BlueCantPlayFirstModeB() {
        assertThrowsLike(() -> linea5x5modeB.playBlueAt(1), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test09BlueCantPlayFirstModeC() {
        assertThrowsLike(() -> linea5x5modeC.playBlueAt(1), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test10RedCantPlayIfNotItsTurnModeA() {
        linea5x5modeA.playRedAt(1);
        assertThrowsLike(() -> linea5x5modeA.playRedAt(2), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test11RedCantPlayIfNotItsTurnModeB() {
        linea5x5modeB.playRedAt(1);
        assertThrowsLike(() -> linea5x5modeB.playRedAt(2), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test12RedCantPlayIfNotItsTurnModeC() {
        linea5x5modeC.playRedAt(1);
        assertThrowsLike(() -> linea5x5modeC.playRedAt(2), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test13BlueCantPlayIfNotItsTurnModeA() {
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(1);

        assertThrowsLike(() -> linea5x5modeA.playBlueAt(2), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test14BlueCantPlayIfNotItsTurnModeB() {
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(1);

        assertThrowsLike(() -> linea5x5modeB.playBlueAt(2), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test15BlueCantPlayIfNotItsTurnModeC() {
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);

        assertThrowsLike(() -> linea5x5modeC.playBlueAt(2), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test16CantPlayFullColumnModeA() {
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(1);
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(1);
        linea5x5modeA.playRedAt(1);

        assertThrowsLike(() -> linea5x5modeA.playBlueAt(1), Linea.fullColumnErrorMessage);
    }
    @Test
    public void test17CantPlayFullColumnModeB() {
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(1);
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(1);
        linea5x5modeB.playRedAt(1);

        assertThrowsLike(() -> linea5x5modeB.playBlueAt(1), Linea.fullColumnErrorMessage);
    }
    @Test
    public void test18CantPlayFullColumnModeC() {
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(1);
        linea5x5modeC.playRedAt(1);

        assertThrowsLike(() -> linea5x5modeC.playBlueAt(1), Linea.fullColumnErrorMessage);
    }
    @Test
    public void test19ModeAFinishesVertically() {
        verticalWinnerBoard(linea5x5modeA);
        assertTrue(linea5x5modeA.finished());
    }
    @Test
    public void test20ModeAFinishesHorizontally() {
        horizontalWinnerBoard(linea5x5modeA);
        assertTrue(linea5x5modeA.finished());
    }
    @Test
    public void test21ModeAWontFinishVerticallyBefore4InLine() {
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(2);

        assertFalse(linea5x5modeA.finished());
    }

    @Test
    public void test22ModeAWontFinishHorizontallyBefore4InLine(){
        linea5x5modeA.playRedAt(1);
        linea5x5modeA.playBlueAt(1);
        linea5x5modeA.playRedAt(2);
        linea5x5modeA.playBlueAt(2);
        linea5x5modeA.playRedAt(3);
        linea5x5modeA.playBlueAt(3);

        assertFalse(linea5x5modeA.finished());
    }
    @Test
    public void test23ModeACantFinishDiagoanlly() {
        diagonalWinnerBoard(linea5x5modeA);
        assertFalse(linea5x5modeA.finished());
    }
    @Test
    public void test24CantKeepPlayingAfterGameFinishedModeA() {
        verticalWinnerBoard(linea5x5modeA);
        linea5x5modeA.finished();

        assertThrowsLike(() -> linea5x5modeA.playBlueAt(2), Linea.gameFinishedErrorMessage);
    }
    @Test
    public void test25ModeBFinishesDiagonally() {
        diagonalWinnerBoard(linea5x5modeB);
        assertTrue(linea5x5modeB.finished());
    }
    @Test
    public void test26ModeBWontFinishBefore4InLine() {
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);
        linea5x5modeB.playRedAt(1);
        linea5x5modeB.playBlueAt(2);

        assertFalse(linea5x5modeB.finished());
    }
    @Test
    public void test27ModeBCantFinishVertically() {
        verticalWinnerBoard(linea5x5modeB);
        assertFalse(linea5x5modeB.finished());
    }
    @Test
    public void test28ModeBCantFinishHorizontally() {
        horizontalWinnerBoard(linea5x5modeB);
        assertFalse(linea5x5modeB.finished());
    }
    @Test
    public void test29CantKeepPlayingAfterGameFinishedModeB() {
        diagonalWinnerBoard(linea5x5modeB);
        linea5x5modeB.finished();

        assertThrowsLike(() -> linea5x5modeB.playBlueAt(2), Linea.gameFinishedErrorMessage);
    }
    @Test
    public void test30ModeCFinishesHorizontally() {
        horizontalWinnerBoard(linea5x5modeC);
        assertTrue(linea5x5modeC.finished());
    }
    @Test
    public void test31ModeCFinishesVertically() {
        verticalWinnerBoard(linea5x5modeC);
        assertTrue(linea5x5modeC.finished());
    }
    @Test
    public void test32ModeCFinishesDiaonally() {
        diagonalWinnerBoard(linea5x5modeC);
        assertTrue(linea5x5modeC.finished());
    }
    @Test
    public void test33ModeCWontFinishBefore4InLine() {
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(2);
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(2);
        linea5x5modeC.playRedAt(1);
        linea5x5modeC.playBlueAt(2);

        assertFalse(linea5x5modeC.finished());
    }
    @Test
    public void test34CantKeepPlayingAfterGameFinishedModeC() {
        verticalWinnerBoard(linea5x5modeC);
        linea5x5modeC.finished();

        assertThrowsLike(() -> linea5x5modeC.playBlueAt(2), Linea.gameFinishedErrorMessage);
    }

    @Test
    public void test35ModeAFinishesTied() {
        tiedBoard(linea5x5modeA);
        assertTrue(linea5x5modeA.finished());
    }
    @Test
    public void test36ModeBFinishesTied() {
        tiedBoard(linea5x5modeB);
        assertTrue(linea5x5modeB.finished());
    }
    @Test
    public void test37ModeCFinishesTied() {
        tiedBoard(linea5x5modeC);
        assertTrue(linea5x5modeC.finished());
    }

    private void assertThrowsLike(Executable executable, String message) {
        Assertions.assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private void verticalWinnerBoard(Linea linea) {
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
    }
    private void horizontalWinnerBoard(Linea linea) {
        linea.playRedAt(1);
        linea.playBlueAt(1);
        linea.playRedAt(2);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(3);
        linea.playRedAt(4);
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
    private void tiedBoard(Linea linea){
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(5);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(4);
        linea.playRedAt(3);
        linea.playBlueAt(2);
        linea.playRedAt(5);
        linea.playBlueAt(4);
        linea.playRedAt(1);
        linea.playBlueAt(1);
        linea.playRedAt(3);
        linea.playBlueAt(1);
        linea.playRedAt(2);
        linea.playBlueAt(3);
        linea.playRedAt(4);
        linea.playBlueAt(5);
        linea.playRedAt(5);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(4);
        linea.playRedAt(5);
    }
}