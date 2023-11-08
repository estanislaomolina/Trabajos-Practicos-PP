package linea;

import static linea.Linea.*;

public class TurnoRojo extends Turnos {
    @Override
    public void playRedAt(Linea linea, int column) {
        if (Linea.board.get(column).size() == linea.maxHight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }
        linea.board.get(column).add(RedPlayerSymbol);
        linea.turno = new TurnoAzul();
    }

    @Override
    public void playBlueAt(Linea linea, int column) {
        throw new RuntimeException(NotItsTurnErrorMessage);
    }
}