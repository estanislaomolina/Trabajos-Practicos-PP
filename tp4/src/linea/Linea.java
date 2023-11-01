package linea;

import java.util.ArrayList;

public class Linea {
    public static final String NotItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final char RedPlayerSymbol = 'R';
    public static final int BluePlayerSymbol = 'B';
    ArrayList<ArrayList> board;
    int maxHight;
    char gameMode;

    boolean turnoRojo = true;
    boolean turnoAzul = false;
    //quiero crear una variable donde pueda guardar como int la ultima jugada como columna y fila
    int lastPlayedColumn;
    int lastPlayedRow;
    public Linea(int prompt, int prompt1, char mode) {
        board = new ArrayList<>();
        gameMode = mode;
        maxHight = prompt1;
        for (int i = 0; i < prompt; i++) {
            ArrayList<Integer> column = new ArrayList<>();
            board.add(column);
        }
    }

    public char mode() {
        return gameMode;
    }

    public boolean show() {
    return false;

    }
    public boolean finished() {
        if (gameMode == 'A') {
            Object player = board.get(lastPlayedColumn).get(lastPlayedRow);
            if (board.get(lastPlayedColumn).size() > 3) {
                if (player == board.get(lastPlayedColumn).get(lastPlayedRow - 1)
                        && player == board.get(lastPlayedColumn).get(lastPlayedRow - 2)
                        && player == board.get(lastPlayedColumn).get(lastPlayedRow - 3)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void playRedAt(int column) {
        if (!turnoRojo) {
            throw new RuntimeException(NotItsTurnErrorMessage);
        }
        if (board.get(column).size() == maxHight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }
        else {
            board.get(column).add(RedPlayerSymbol);
            turnoRojo = false;
            turnoAzul = true;
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size()-1;
        }
    }


    public void playBlueAt(int column) {
        if (!turnoAzul) {
            throw new RuntimeException(NotItsTurnErrorMessage);
        }
        if (board.get(column).size() == maxHight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }
        else {
            board.get(column).add(BluePlayerSymbol);
            turnoRojo = true;
            turnoAzul = false;
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size()-1;
        }
    }



}
