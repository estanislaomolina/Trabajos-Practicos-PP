
package linea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest {
    private Line line5X5ModeA;
    private Line line5X5ModeB;
    private Line line5X5ModeC;

    @BeforeEach
    public void setUp() {
        line5X5ModeA = new Line(5, 5, 'A');
        line5X5ModeB = new Line(5, 5, 'B');
        line5X5ModeC = new Line(5, 5, 'C');
    }

    @Test
    public void test00BoardIsCreatedWithCorrectAmountOfColumns() {
        assertEquals(5, line5X5ModeC.board.size());
    }

    @Test
    public void test01BoardIsCreatedWithCorrectModeA() {
        assertEquals('A', line5X5ModeA.mode());
    }

    @Test
    public void test02BoardIsCreatedWithCorrectModeB() {
        assertEquals('B', line5X5ModeB.mode());
    }

    @Test
    public void test03BoardIsCreatedWithCorrectModeC() {
        assertEquals('C', line5X5ModeC.mode());
    }

    @Test
    public void test04ChipIsPlacedCorrectlyInBoardForRedModeA() {
        line5X5ModeA.playRedAt(1);
        assertEquals('O', line5X5ModeC.board.get(0).get(0));
    }
    @Test
    public void test05ChipIsPlacedCorrectlyInBoardForRedModeB() {
        line5X5ModeB.playRedAt(1);
        assertEquals('O', line5X5ModeC.board.get(0).get(0));
    }
    @Test
    public void test06ChipIsPlacedCorrectlyInBoardForRedModeC() {
        line5X5ModeC.playRedAt(1);
        assertEquals('O', line5X5ModeC.board.get(0).get(0));
    }

    @Test
    public void test07BlueCantPlayFirstModeA() {
        assertThrowsLike(() -> line5X5ModeA.playBlueAt(1), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test08BlueCantPlayFirstModeB() {
        assertThrowsLike(() -> line5X5ModeB.playBlueAt(1), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test09BlueCantPlayFirstModeC() {
        assertThrowsLike(() -> line5X5ModeC.playBlueAt(1), Line.notItsTurnErrorMessage);
    }

    @Test
    public void test10RedCantPlayIfNotItsTurnModeA() {
        line5X5ModeA.playRedAt(1);
        assertThrowsLike(() -> line5X5ModeA.playRedAt(2), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test11RedCantPlayIfNotItsTurnModeB() {
        line5X5ModeB.playRedAt(1);
        assertThrowsLike(() -> line5X5ModeB.playRedAt(2), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test12RedCantPlayIfNotItsTurnModeC() {
        line5X5ModeC.playRedAt(1);
        assertThrowsLike(() -> line5X5ModeC.playRedAt(2), Line.notItsTurnErrorMessage);
    }

    @Test
    public void test13BlueCantPlayIfNotItsTurnModeA() {
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(1);

        assertThrowsLike(() -> line5X5ModeA.playBlueAt(2), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test14BlueCantPlayIfNotItsTurnModeB() {
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(1);

        assertThrowsLike(() -> line5X5ModeB.playBlueAt(2), Line.notItsTurnErrorMessage);
    }
    @Test
    public void test15BlueCantPlayIfNotItsTurnModeC() {
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(1);

        assertThrowsLike(() -> line5X5ModeC.playBlueAt(2), Line.notItsTurnErrorMessage);
    }

    @Test
    public void test16CantPlayFullColumnModeA() {
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(1);
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(1);
        line5X5ModeA.playRedAt(1);

        assertThrowsLike(() -> line5X5ModeA.playBlueAt(1), Line.fullColumnErrorMessage);
    }
    @Test
    public void test17CantPlayFullColumnModeB() {
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(1);
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(1);
        line5X5ModeB.playRedAt(1);

        assertThrowsLike(() -> line5X5ModeB.playBlueAt(1), Line.fullColumnErrorMessage);
    }
    @Test
    public void test18CantPlayFullColumnModeC() {
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(1);
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(1);
        line5X5ModeC.playRedAt(1);

        assertThrowsLike(() -> line5X5ModeC.playBlueAt(1), Line.fullColumnErrorMessage);
    }
    @Test
    public void test19ModeAFinishesVertically() {
        verticalWinnerBoard(line5X5ModeA);
        assertTrue(line5X5ModeA.finished());
    }
    @Test
    public void test20ModeAFinishesHorizontally() {
        horizontalWinnerBoard(line5X5ModeA);
        assertTrue(line5X5ModeA.finished());
    }
    @Test
    public void test21ModeAWontFinishVerticallyBefore4InLine() {
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(2);
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(2);
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(2);

        assertFalse(line5X5ModeA.finished());
    }

    @Test
    public void test22ModeAWontFinishHorizontallyBefore4InLine(){
        line5X5ModeA.playRedAt(1);
        line5X5ModeA.playBlueAt(1);
        line5X5ModeA.playRedAt(2);
        line5X5ModeA.playBlueAt(2);
        line5X5ModeA.playRedAt(3);
        line5X5ModeA.playBlueAt(3);

        assertFalse(line5X5ModeA.finished());
    }
    @Test
    public void test23ModeACantFinishDiagoanlly() {
        diagonalWinnerBoard(line5X5ModeA);
        assertFalse(line5X5ModeA.finished());
    }
    @Test
    public void test24CantKeepPlayingAfterGameFinishedModeA() {
        verticalWinnerBoard(line5X5ModeA);
        line5X5ModeA.finished();

        assertThrowsLike(() -> line5X5ModeA.playBlueAt(2), Line.gameFinishedErrorMessage);
    }
    @Test
    public void test25ModeBFinishesDiagonally() {
        diagonalWinnerBoard(line5X5ModeB);
        assertTrue(line5X5ModeB.finished());
    }
    @Test
    public void test26ModeBWontFinishBefore4InLine() {
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(2);
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(2);
        line5X5ModeB.playRedAt(1);
        line5X5ModeB.playBlueAt(2);

        assertFalse(line5X5ModeB.finished());
    }
    @Test
    public void test27ModeBCantFinishVertically() {
        verticalWinnerBoard(line5X5ModeB);
        assertFalse(line5X5ModeB.finished());
    }
    @Test
    public void test28ModeBCantFinishHorizontally() {
        horizontalWinnerBoard(line5X5ModeB);
        assertFalse(line5X5ModeB.finished());
    }
    @Test
    public void test29CantKeepPlayingAfterGameFinishedModeB() {
        diagonalWinnerBoard(line5X5ModeB);
        line5X5ModeB.finished();

        assertThrowsLike(() -> line5X5ModeB.playBlueAt(2), Line.gameFinishedErrorMessage);
    }
    @Test
    public void test30ModeCFinishesHorizontally() {
        horizontalWinnerBoard(line5X5ModeC);
        assertTrue(line5X5ModeC.finished());
    }
    @Test
    public void test31ModeCFinishesVertically() {
        verticalWinnerBoard(line5X5ModeC);
        assertTrue(line5X5ModeC.finished());
    }
    @Test
    public void test32ModeCFinishesDiaonally() {
        diagonalWinnerBoard(line5X5ModeC);
        assertTrue(line5X5ModeC.finished());
    }
    @Test
    public void test33ModeCWontFinishBefore4InLine() {
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(2);
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(2);
        line5X5ModeC.playRedAt(1);
        line5X5ModeC.playBlueAt(2);

        assertFalse(line5X5ModeC.finished());
    }
    @Test
    public void test34CantKeepPlayingAfterGameFinishedModeC() {
        verticalWinnerBoard(line5X5ModeC);
        line5X5ModeC.finished();

        assertThrowsLike(() -> line5X5ModeC.playBlueAt(2), Line.gameFinishedErrorMessage);
    }

    @Test
    public void test35ModeAFinishesTied() {
        tiedBoard(line5X5ModeA);
        assertTrue(line5X5ModeA.finished());
    }

    @Test
    public void test36ModeBFinishesTied() {
        tiedBoard(line5X5ModeB);
        assertTrue(line5X5ModeB.finished());
    }

    @Test
    public void test37ModeCFinishesTied() {
        tiedBoard(line5X5ModeC);
        assertTrue(line5X5ModeC.finished());
    }

    private void assertThrowsLike(Executable executable, String message) {
        Assertions.assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private void verticalWinnerBoard(Line line) {
        line.playRedAt(1);
        line.playBlueAt(2);
        line.playRedAt(1);
        line.playBlueAt(2);
        line.playRedAt(1);
        line.playBlueAt(2);
        line.playRedAt(1);
    }
    private void horizontalWinnerBoard(Line line) {
        line.playRedAt(1);
        line.playBlueAt(1);
        line.playRedAt(2);
        line.playBlueAt(2);
        line.playRedAt(3);
        line.playBlueAt(3);
        line.playRedAt(4);
    }

    private void diagonalWinnerBoard(Line line) {
        line.playRedAt(1);
        line.playBlueAt(2);
        line.playRedAt(2);
        line.playBlueAt(3);
        line.playRedAt(3);
        line.playBlueAt(4);
        line.playRedAt(3);
        line.playBlueAt(4);
        line.playRedAt(4);
        line.playBlueAt(1);
        line.playRedAt(4);
    }
    private void tiedBoard(Line line){
        line.playRedAt(1);
        line.playBlueAt(2);
        line.playRedAt(3);
        line.playBlueAt(4);
        line.playRedAt(5);
        line.playBlueAt(2);
        line.playRedAt(1);
        line.playBlueAt(4);
        line.playRedAt(3);
        line.playBlueAt(2);
        line.playRedAt(5);
        line.playBlueAt(4);
        line.playRedAt(1);
        line.playBlueAt(1);
        line.playRedAt(3);
        line.playBlueAt(1);
        line.playRedAt(2);
        line.playBlueAt(3);
        line.playRedAt(4);
        line.playBlueAt(5);
        line.playRedAt(5);
        line.playBlueAt(2);
        line.playRedAt(3);
        line.playBlueAt(4);
        line.playRedAt(5);
    }
}