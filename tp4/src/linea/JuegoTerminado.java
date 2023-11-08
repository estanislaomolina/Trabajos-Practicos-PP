package linea;

import static linea.Linea.gameFinishedErrorMessage;

public class JuegoTerminado extends Turnos{
    @Override
    public void playRedAt(Linea linea, int column) {
        throw new RuntimeException(gameFinishedErrorMessage);
    }
    @Override
    public void playBlueAt(Linea linea, int column) {
        throw new RuntimeException(gameFinishedErrorMessage);
    }
}
