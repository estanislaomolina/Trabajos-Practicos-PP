package linea;

import java.util.ArrayList;

public class Linea {
    public static final String NotItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final char RedPlayerSymbol = 'O';
    public static final char BluePlayerSymbol = 'X';
    public static final String gameFinishedErrorMessage = "Juego terminado";
    ArrayList<ArrayList> board;
    int maxHight;
    char gameMode;

    boolean turnoRojo = true;
    boolean turnoAzul = false;
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

        for (int i = maxHight-1; i >= 0; i--) {
            for (int j = 0; j < board.size(); j++) {
                if (board.get(j).size() > i) {
                    System.out.print("|" + board.get(j).get(i));
                }
                else {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < board.size(); i++) {
            System.out.print("|" + i);
        }
        System.out.println("|");
        return true;
    }

    public boolean finished() {
        //return true in gamemode A if there are 4 in a row vertically or horizontally
        if (gameMode == 'A') {
            if (board.get(lastPlayedColumn).size() >= 4) {
                if (board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow-1)) &&
                        board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow-2)) &&
                        board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow-3))) {
                    return true;
                }
            }

        }
        return false;
    }
    public void playRedAt(int column) {
        if (finished()) {
            throw new RuntimeException(gameFinishedErrorMessage);
        }
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
        if (finished()) {
            throw new RuntimeException(gameFinishedErrorMessage);
        }
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
