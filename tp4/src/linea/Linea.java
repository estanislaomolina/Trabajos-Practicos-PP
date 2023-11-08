package linea;

import java.util.ArrayList;
import java.util.Arrays;

public class Linea {
    public static final String NotItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final char RedPlayerSymbol = 'O';
    public static final char BluePlayerSymbol = 'X';
    public static final String gameFinishedErrorMessage = "Juego terminado";
    ArrayList<ArrayList> board;
    int maxHight;
    GameMode gameMode;

    boolean turnoRojo = true;
    boolean turnoAzul = false;
    int lastPlayedColumn;
    int lastPlayedRow;
    ArrayList <GameMode> gameModeList = new ArrayList<>();

    public Linea(int prompt, int prompt1, char mode) {
        board = new ArrayList<>();
        maxHight = prompt1;
        chooseMode(mode);
        for (int i = 0; i < prompt; i++) {
            ArrayList<Integer> column = new ArrayList<>();
            board.add(column);
        }
    }


    public boolean show() {

        for (int i = maxHight - 1; i >= 0; i--) {
            for (int j = 0; j < board.size(); j++) {
                if (board.get(j).size() > i) {
                    System.out.print("|" + board.get(j).get(i));
                } else {
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
        return gameMode.isGameOver(this);
    }
    //return true in gamemode A if there are 4 in a row vertically or horizontally
//        if (gameMode == 'A') {
//            if (board.get(lastPlayedColumn).size() >= 4) {
//                if (board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow - 1)) &&
//                        board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow - 2)) &&
//                        board.get(lastPlayedColumn).get(lastPlayedRow).equals(board.get(lastPlayedColumn).get(lastPlayedRow - 3))) {
//                    return true;
//                }
//            }
//            //chequar usando un for las casillas de la misma fila
//            //si suman 4 en linea, return true
//            int count = 0;
//            if (board.get(lastPlayedColumn).size() >= 4) {
//                for (int i = 0; i < board.get(lastPlayedColumn).size(); i++) {
//                    if (board.get(lastPlayedColumn).get(i).equals(board.get(lastPlayedColumn).get(lastPlayedRow))) {
//                        count++;
//                    }
//                    else {
//                        count = 0;
//                    }
//                    if (count >= 4) {
//                        return true;
//                    }
//                }
//            }
//        }
//
//
//        return false;
//    }
    public void playRedAt(int column) {
        if (finished()) {
            throw new RuntimeException(gameFinishedErrorMessage);
        }
        if (!turnoRojo) {
            throw new RuntimeException(NotItsTurnErrorMessage);
        }
        if (board.get(column).size() == maxHight) {
            throw new RuntimeException(fullColumnErrorMessage);
        } else {
            board.get(column).add(RedPlayerSymbol);
            turnoRojo = false;
            turnoAzul = true;
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size() - 1;
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
        } else {
            board.get(column).add(BluePlayerSymbol);
            turnoRojo = true;
            turnoAzul = false;
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size() - 1;
        }
    }


    public Boolean verticalFinish() {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).size() >= 4) {
                if (board.get(i).get(lastPlayedRow).equals(board.get(i).get(lastPlayedRow - 1)) &&
                        board.get(i).get(lastPlayedRow).equals(board.get(i).get(lastPlayedRow - 2)) &&
                        board.get(i).get(lastPlayedRow).equals(board.get(i).get(lastPlayedRow - 3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean horizontalFinish() {
        return false;
    }


    public void chooseMode(char modeChar) {
        gameModeList.add(new ModeA());
        gameModeList.add(new ModeB());
        gameModeList.add(new ModeC());
        
        gameModeList.stream()
                .filter(mode -> mode.getModeChar() == modeChar)
                .forEach(mode -> this.gameMode = mode);
    }


    public char mode() {
        return gameMode.getModeChar();
    }
}