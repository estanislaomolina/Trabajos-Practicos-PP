package linea;

import java.util.ArrayList;

import static linea.Linea.*;


public class TurnoRojo extends Turnos {
    public static final char redPlayerSymbol = 'O';
    @Override
    public void playRedAt(Linea linea, int column) {
        linea.placeChip(column, redPlayerSymbol);
        linea.turno = new TurnoAzul();
    }


    @Override
    public void playBlueAt(Linea linea, int column) {
        throw new RuntimeException(notItsTurnErrorMessage);
    }
}
