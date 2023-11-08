package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
    public static final String NotItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final char RedPlayerSymbol = 'O';
    public static final char BluePlayerSymbol = 'X';
    public static final String gameFinishedErrorMessage = "Juego terminado";
    static ArrayList<ArrayList> board;
    int columnas;
    int filas;
    int maxHight;
    GameMode gameMode;
    Turnos turno = new TurnoRojo();
    int lastPlayedColumn;
    int lastPlayedRow = -1;
    ArrayList<GameMode> gameModeList = new ArrayList<>();

    public Linea(int prompt, int prompt1, char mode) {
        board = new ArrayList<>();
        maxHight = prompt1;
        filas = prompt1;
        columnas = prompt;
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
            List<Boolean> matchingList = getBoardContent(lastPlayedRow).stream()
                    .map(cell -> cell.equals(getBoardContent(lastPlayedRow).get(lastPlayedColumn)))
                    .collect(Collectors.toList());

            if (Collections.frequency(matchingList, true) >= 4) {
                turno = new JuegoTerminado();
                return true;
            }
        }
        return false;
    }



    public Boolean diagonalFinish() {
        char player = (char) board.get(lastPlayedRow).get(lastPlayedColumn);
            for (int col = 0; col < columnas; col++) {
                for (int row = 0; row <  filas; row++) {
                    if (board.get(col).size() > row &&
                            board.get(col + 1).size() > row + 1 &&
                            board.get(col + 2).size() > row + 2 &&
                            board.get(col + 3).size() > row + 3) {
                        char c1 = (char) board.get(col).get(row);
                        char c2 = (char) board.get(col + 1).get(row + 1);
                        char c3 = (char) board.get(col + 2).get(row + 2);
                        char c4 = (char) board.get(col + 3).get(row + 3);
                        if (c1 == player && c2 == player && c3 == player && c4 == player) {
                            return true;
                        }
                    }
                }
            }

            // Verificar diagonales ascendentes
            for (int col = 0; col < columnas; col++) {
                for (int row = 3; row < filas; row++) {
                    if (board.get(col).size() > row &&
                            board.get(col + 1).size() > row - 1 &&
                            board.get(col + 2).size() > row - 2 &&
                            board.get(col + 3).size() > row - 3) {
                        char c1 = (char) board.get(col).get(row);
                        char c2 = (char) board.get(col + 1).get(row - 1);
                        char c3 = (char) board.get(col + 2).get(row - 2);
                        char c4 = (char) board.get(col + 3).get(row - 3);
                        if (c1 == player && c2 == player && c3 == player && c4 == player) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        public void chooseMode ( char modeChar){
            gameModeList.add(new ModeA());
            gameModeList.add(new ModeB());
            gameModeList.add(new ModeC());

            gameModeList.stream()
                    .filter(mode -> mode.getModeChar() == modeChar)
                    .forEach(mode -> this.gameMode = mode);
        }

        public ArrayList<Character> getBoardContent(int row){
            //necesito que la funcion me devuelva un array col los valores que estan en cada columna de la fila que le paso
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
