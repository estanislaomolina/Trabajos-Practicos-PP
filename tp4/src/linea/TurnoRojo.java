package linea;

import static linea.Linea.*;

public class TurnoRojo extends Turnos {
    @Override
    public void playRedAt(Linea linea, int column) {
        if (column < 0 || column >= Linea.board.size()) {
            throw new RuntimeException(outOfBoundsErrorMessage);
        }

        if (Linea.board.get(column).size() == linea.maxHeight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }

        linea.board.get(column).add(redPlayerSymbol);
        linea.turno = new TurnoAzul();
    }

    @Override
    public void playBlueAt(Linea linea, int column) {
        throw new RuntimeException(notItsTurnErrorMessage);
    }
}
