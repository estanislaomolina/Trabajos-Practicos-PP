package linea;

public class ModeB extends GameMode{

    @Override
    public Boolean isGameOver(Line line) {
        return line.diagonalFinish();
    }

    @Override
    public char getModeChar() {
        return 'B';
    }
}
