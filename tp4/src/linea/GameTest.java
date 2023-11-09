package linea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest {
    @Test
    public void test00BoardIsCreatedWithCorrectAmountOfColumns() {
        Linea game = new Linea( 3, 3, 'C' );
        assertEquals( 3, game.board.size() );
    }

    @Test
    public void test01BoardIsCreatedWithCorrectRules() {
        Linea game = new Linea( 3, 3, 'C' );
        assertEquals( 'C', game.mode() );
    }

    @Test
    public void test02ChipIsPlacedCorrectlyInBoard() {
        Linea game = new Linea( 3, 3, 'C' );
        game.playRedAt(1);
        assertEquals( Linea.redPlayerSymbol, game.board.get( 1 ).get( 0) );
    }

    @Test
    public void test03BlueCantPlayFirst() {
        Linea game = new Linea( 3, 3, 'C' );
        assertThrowsLike( () -> game.playBlueAt( 1 ), Linea.notItsTurnErrorMessage);
    }
    @Test
    public void test04CantPlayIfNotItsTurn() {
        Linea game = new Linea(3, 3, 'C');
        game.playRedAt(1);
        assertThrowsLike(() -> game.playRedAt(2), Linea.notItsTurnErrorMessage);
    }

    @Test
    public void test05CantPlayFullColumn(){
        Linea game = new Linea( 3, 3, 'C' );
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        assertThrowsLike( () -> game.playBlueAt( 1 ), Linea.fullColumnErrorMessage );
    }

    @Test
    public void test06ModeAFinishesVertically(){
        Linea game = new Linea( 5, 5, 'A' );
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);

        assertTrue(game.finished());
    }

    @Test
    public void test07ModeAWontFinishVerticallyBefore4InLine(){
        Linea game = new Linea( 5, 5, 'A' );
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);

        assertFalse(game.finished());
    }
    @Test
    public void test08CantKeepPlayingAfterGameFinished(){
        Linea game = new Linea( 5, 5, 'A' );
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.finished();

        assertThrowsLike( () -> game.playBlueAt( 2 ), Linea.gameFinishedErrorMessage );
    }
    @Test
    public void test09ModeAFinishesHorizontally(){
        Linea game = new Linea( 5, 5, 'A' );
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertTrue(game.finished());
    }

    @Test
    public void test10ModeBFinishesDiagonally(){
        Linea game = new Linea( 6, 6, 'B' );
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(4);

        assertTrue(game.finished());
    }
    @Test
    public void test11CantPlayOutOfBounds(){
        Linea game = new Linea( 3, 3, 'C' );
        assertThrowsLike( () -> game.playRedAt( 3 ), Linea.outOfBoundsErrorMessage );
    }
    private void assertThrowsLike(Executable executable, String message ) {
        Assertions.assertEquals( message, assertThrows( Exception.class, executable ).getMessage() );
    }
}
