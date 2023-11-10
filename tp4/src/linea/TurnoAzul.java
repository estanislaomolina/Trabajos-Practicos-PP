package linea;


import static linea.Linea.fullColumnErrorMessage;
import static linea.Linea.outOfBoundsErrorMessage;

public class TurnoAzul extends Turnos{
    public static final char bluePlayerSymbol = 'X';
    @Override
    public void playRedAt(Linea linea, int column) {
        throw new RuntimeException(Linea.notItsTurnErrorMessage);
    }
    @Override
    public void playBlueAt(Linea linea, int column) {
        linea.placeChip(column, bluePlayerSymbol);
        linea.turno = new TurnoRojo();
    }
}

