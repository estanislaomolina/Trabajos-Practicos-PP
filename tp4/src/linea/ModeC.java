package linea;

public class ModeC extends GameMode{
    @Override
    public Boolean isGameOver(Line line) {
        return line.verticalFinish() || line.horizontalFinish() || line.diagonalFinish();
    }
    @Override
    public char getModeChar() {
        return 'C';
    }
}
