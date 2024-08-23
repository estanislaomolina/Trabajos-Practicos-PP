package linea;


import static linea.Linea.fullColumnErrorMessage;
import static linea.Linea.outOfBoundsErrorMessage;

public class TurnoAzul extends Turnos{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final char bluePlayerSymbol = 'X';
    @Override
    public void playRedAt(Linea linea, int column) {
        throw new RuntimeException(Linea.notItsTurnErrorMessage);
    }
    @Override
    public void playBlueAt(Linea linea, int column) {
        linea.placeChip(column, ANSI_BLUE + bluePlayerSymbol + ANSI_RESET);
        linea.turno = new TurnoRojo();
    }
}

