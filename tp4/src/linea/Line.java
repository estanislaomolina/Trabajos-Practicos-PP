package linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Line {
    public static final String notItsTurnErrorMessage = "No es su turno";
    public static final String fullColumnErrorMessage = "Columna llena";
    public static final String outOfBoundsErrorMessage = "Columna fuera de rango";
    public static final String gameFinishedErrorMessage = "Juego terminado";
    static ArrayList<ArrayList> board;
    int columns;
    int rows;
    int maxHeight;
    GameMode gameMode;
    Turns turn = new TurnRed();
    int lastPlayedColumn;
    int lastPlayedRow = -1;
    ArrayList<GameMode> gameModeList = new ArrayList<>();

    public Line(int prompt, int prompt1, char mode) {
        board = new ArrayList<>();
        maxHeight = prompt1;
        rows = prompt1;
        columns = prompt;
        chooseMode(mode);
        for (int i = 0; i < prompt; i++) {
            ArrayList<Integer> column = new ArrayList<>();
            board.add(column);
        }
    }
    public char mode() {
        return gameMode.getModeChar();
    }

    public void chooseMode ( char modeChar){
        gameModeList.add(new ModeA());
        gameModeList.add(new ModeB());
        gameModeList.add(new ModeC());

        gameModeList.stream()
                .filter(mode -> mode.getModeChar() == modeChar)
                .forEach(mode -> this.gameMode = mode);
    }

    public boolean finished() {
        return gameMode.isGameOver(this) || isFull();
    }

    public void playRedAt(int column) {
            turn.playRedAt(this, column -1);
        }

    public void playBlueAt(int column) {
            turn.playBlueAt(this, column-1);
        }

    public void placeChip(int column, String playerSymbol) {
        if (column < 0 || column >= board.size()) {
            throw new RuntimeException(outOfBoundsErrorMessage);
        }
        if (board.get(column).size() == maxHeight) {
            throw new RuntimeException(fullColumnErrorMessage);
        }
        board.get(column).add(playerSymbol);
        lastPlayedColumn = column;
        lastPlayedRow = board.get(column).size() - 1;

    }

    public Boolean verticalFinish() {
        if (board.stream()
                .filter(column -> column.size() >= 4 && column.size() == lastPlayedRow+1)
                .anyMatch(column -> IntStream.range(0, 4)
                        .allMatch(i -> column.get(lastPlayedRow - i)
                                .equals(column.get(lastPlayedRow))))){
            turn = new JuegoTerminado();
            return true;
        }
        return false;
    }

    public Boolean horizontalFinish() {
        int count = 0;
        if (lastPlayedRow != -1) {
            for (int i = 0; i < getRowContent(lastPlayedRow).size(); i++) {
                if (getRowContent(lastPlayedRow).get(i).equals(getRowContent(lastPlayedRow).get(lastPlayedColumn))) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }


    public Boolean diagonalFinish() {
        if (lastPlayedRow == -1 || lastPlayedColumn < 0 || lastPlayedColumn >= board.size()) {
            return false;
        }

        char playerSymbol = board.get(lastPlayedColumn).get(lastPlayedRow).toString().charAt(0);

        long count1 = IntStream.rangeClosed(-3, 3)
                .filter(i -> {
                    int col = lastPlayedColumn + i;
                    int row = lastPlayedRow + i;
                    return isValidPosition(col, row) && board.get(col).size() > row && board.get(col).get(row).toString().charAt(0) == playerSymbol;
                })
                .count();

        long count2 = IntStream.rangeClosed(-3, 3)
                .filter(i -> {
                    int col = lastPlayedColumn + i;
                    int row = lastPlayedRow - i;
                    return isValidPosition(col, row) && row >= 0 && board.get(col).size() > row && board.get(col).get(row).toString().charAt(0) == playerSymbol;
                })
                .count();

        if (count1 >= 4 || count2 >= 4) {
            turn = new JuegoTerminado();
            return true;
        }

        return false;
    }
    private boolean isValidPosition(int column, int row) {
        return column >= 0 && column < columns && row >= 0 && row < maxHeight;
    }

<<<<<<< HEAD:tp4/src/linea/Linea.java
        public void chooseMode ( char modeChar){
            gameModeList.add(new ModeA());
            gameModeList.add(new ModeB());
            gameModeList.add(new ModeC());

            gameModeList.stream()
                    .filter(mode -> mode.getModeChar() == modeChar)
                    .forEach(mode -> this.gameMode = mode);
        }

        public ArrayList<String> getRowContent(int row){
            ArrayList<String> boardContent = new ArrayList<>();
=======
        public ArrayList<Character> getRowContent(int row){
            ArrayList<Character> boardContent = new ArrayList<>();
>>>>>>> f634eec8b70e4d7fda14dd687094d7b1fe49a1e8:tp4/src/linea/Line.java
            for (int i = 0; i < board.size(); i++) {
                if (board.get(i).size()-1 >= row && !board.get(i).isEmpty()) {
                    boardContent.add((String) board.get(i).get(row));
                } else {
                    boardContent.add(String.valueOf(' '));
                }
            }
            return boardContent;
        }

    public Boolean isFull() {
        return board.stream()
                .allMatch(column -> column.size() == maxHeight);
    }

    public boolean show() {

        for (int i = maxHeight - 1; i >= 0; i--) {
            System.out.print("║");
            for (int j = 0; j < board.size(); j++) {
                if (board.get(j).size() > i) {
                    System.out.print(" " + board.get(j).get(i));
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println(" ║");
        }
        System.out.print("║");
        for (int i = 0; i < board.size(); i++) {
            System.out.print("--");
        }
        System.out.println("-║");

        System.out.print("║");
        for (int i = 0; i < board.size(); i++) {
            System.out.print(" " + ((i+1)%10));
        }
        System.out.println(" ║");

        System.out.print("╚");
        for (int i = 0; i < board.size(); i++) {
            System.out.print("══");
        }
        System.out.println("═╝");

        return true;
    }
}
