package linea;

import static linea.Line.*;


public class TurnRed extends Turns {
    public static final char redPlayerSymbol = 'O';
    @Override
    public void playRedAt(Line line, int column) {
        line.placeChip(column, redPlayerSymbol);
        line.turn = new TurnBlue();
    }
    @Override
    public void playBlueAt(Line line, int column) {
        throw new RuntimeException(notItsTurnErrorMessage);
    }
}
