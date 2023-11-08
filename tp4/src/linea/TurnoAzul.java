package linea;


import static linea.Linea.fullColumnErrorMessage;

public class TurnoAzul extends Turnos{
    @Override
    public void playRedAt(Linea linea, int column) {
        throw new RuntimeException(Linea.NotItsTurnErrorMessage);
    }
    @Override
    public void playBlueAt(Linea linea, int column) {
        if (Linea.board.get(column).size() == linea.maxHight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }
        linea.board.get(column).add(Linea.BluePlayerSymbol);
        linea.turno = new TurnoRojo();
    }
}

