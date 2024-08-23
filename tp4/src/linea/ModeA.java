package linea;

public class ModeA extends GameMode{

    @Override
    public Boolean isGameOver(Line line) {
        return line.verticalFinish() || line.horizontalFinish();
    }

    @Override
    public char getModeChar() {
        return 'A';
    }
}