package linea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
    public static final String notItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final String outOfBoundsErrorMessage = "Columna fuera de rango";
    public static final String invalidCharacterErrorMessage = "Caracter invalido";
    public static final char redPlayerSymbol = 'O';
    public static final char bluePlayerSymbol = 'X';
    public static final String gameFinishedErrorMessage = "Juego terminado";
    static ArrayList<ArrayList> board;
    int columnas;
    int filas;
    int maxHeight;
    GameMode gameMode;
    Turnos turno = new TurnoRojo();
    int lastPlayedColumn;
    int lastPlayedRow = -1;
    ArrayList<GameMode> gameModeList = new ArrayList<>();

    public Linea(int prompt, int prompt1, char mode) {
        board = new ArrayList<>();
        maxHeight = prompt1;
        filas = prompt1;
        columnas = prompt;
        chooseMode(mode);
        for (int i = 0; i < prompt; i++) {
            ArrayList<Integer> column = new ArrayList<>();
            board.add(column);
        }
    }


    public boolean show() {

        for (int i = maxHeight - 1; i >= 0; i--) {
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

    public char mode() {
        return gameMode.getModeChar();
    }

    public void playRedAt(int column) {

            turno.playRedAt(this, column);
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size() - 1;
        }

    public void playBlueAt(int column) {
            turno.playBlueAt(this, column);
            lastPlayedColumn = column;
            lastPlayedRow = board.get(column).size() - 1;
        }



    public Boolean verticalFinish() {
        if (board.stream()
                .filter(column -> column.size() >= 4)
                .anyMatch(column -> IntStream.range(0, 4)
                        .allMatch(i -> column.get(lastPlayedRow - i).equals(column.get(lastPlayedRow))))){
            turno = new JuegoTerminado();
            return true;
        }
        return false;
    }


    public Boolean horizontalFinish() {
        if (lastPlayedRow != -1) {
            List<Boolean> matchingList = getRowContent(lastPlayedRow).stream()
                    .map(cell -> cell.equals(getRowContent(lastPlayedRow).get(lastPlayedColumn)))
                    .collect(Collectors.toList());

            if (Collections.frequency(matchingList, true) >= 4) {
                turno = new JuegoTerminado();
                return true;
            }
        }
        return false;
    }


    public Boolean diagonalFinish() {
        if (lastPlayedRow == -1 || lastPlayedColumn < 0 || lastPlayedColumn >= board.size()) {
            return false;
        }

        char playerSymbol = board.get(lastPlayedColumn).get(lastPlayedRow).toString().charAt(0);

        int count1 = 0;
        for (int i = -3; i <= 3; i++) {
            int col = lastPlayedColumn + i;
            int row = lastPlayedRow + i;
            if (isValidPosition(col, row) && board.get(col).size() > row && board.get(col).get(row).toString().charAt(0) == playerSymbol) {
                count1++;
                if (count1 >= 4) {
                    turno = new JuegoTerminado();
                    return true;
                }
            } else {
                count1 = 0;
            }
        }

        // Check diagonals that go from bottom-right to top-left
        int count2 = 0;
        for (int i = -3; i <= 3; i++) {
            int col = lastPlayedColumn + i;
            int row = lastPlayedRow - i;
            if (isValidPosition(col, row) && row >= 0 && board.get(col).size() > row && board.get(col).get(row).toString().charAt(0) == playerSymbol) {
                count2++;
                if (count2 >= 4) {
                    turno = new JuegoTerminado();
                    return true;
                }
            } else {
                count2 = 0;
            }
        }

        return false;
    }



    private boolean isValidPosition(int column, int row) {
        return column >= 0 && column < columnas && row >= 0 && row < maxHeight;
    }


        public void chooseMode ( char modeChar){
            gameModeList.add(new ModeA());
            gameModeList.add(new ModeB());
            gameModeList.add(new ModeC());

            gameModeList.stream()
                    .filter(mode -> mode.getModeChar() == modeChar)
                    .forEach(mode -> this.gameMode = mode);
        }

        public ArrayList<Character> getRowContent(int row){
            ArrayList<Character> boardContent = new ArrayList<>();
            for (int i = 0; i < board.size(); i++) {
                if (board.get(i).size()-1 >= row && !board.get(i).isEmpty()) {
                    boardContent.add((char) board.get(i).get(row));
                } else {
                    boardContent.add(' ');
                }
            }
            return boardContent;
        }

}
