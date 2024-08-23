package linea;

import java.util.ArrayList;

import static linea.Linea.*;

public class TurnoRojo extends Turnos {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final char redPlayerSymbol = 'O';

    @Override
    public void playRedAt(Linea linea, int column) {
        // Print the redPlayerSymbol in red color

        linea.placeChip(column, ANSI_RED + redPlayerSymbol + ANSI_RESET);
        linea.turno = new TurnoAzul();
    }

    @Override
    public void playBlueAt(Linea linea, int column) {
        throw new RuntimeException(notItsTurnErrorMessage);
    }
}
