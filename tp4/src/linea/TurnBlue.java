package linea;


public class TurnBlue extends Turns {
    public static final char bluePlayerSymbol = 'X';
    @Override
    public void playRedAt(Line line, int column) {
        throw new RuntimeException(Line.notItsTurnErrorMessage);
    }
    @Override
    public void playBlueAt(Line line, int column) {
        line.placeChip(column, bluePlayerSymbol);
        line.turn = new TurnRed();
    }
}

