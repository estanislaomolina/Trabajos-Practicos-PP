package linea;

import static linea.Line.gameFinishedErrorMessage;

public class JuegoTerminado extends Turns {
    @Override
    public void playRedAt(Line line, int column) {
        throw new RuntimeException(gameFinishedErrorMessage);
    }
    @Override
    public void playBlueAt(Line line, int column) {
        throw new RuntimeException(gameFinishedErrorMessage);
    }
}
