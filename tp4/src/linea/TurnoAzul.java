package linea;


import static linea.Linea.fullColumnErrorMessage;
import static linea.Linea.outOfBoundsErrorMessage;

public class TurnoAzul extends Turnos{
    @Override
    public void playRedAt(Linea linea, int column) {
        throw new RuntimeException(Linea.notItsTurnErrorMessage);
    }
    @Override
    public void playBlueAt(Linea linea, int column) {
        if (column < 0 || column >= Linea.board.size()) {
            throw new RuntimeException(outOfBoundsErrorMessage);
        }
        if (Linea.board.get(column).size() == linea.maxHeight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }

        linea.board.get(column).add(Linea.bluePlayerSymbol);
        linea.turno = new TurnoRojo();
    }
}

