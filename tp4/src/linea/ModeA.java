package linea;

public class ModeA extends GameMode{

    @Override
    public Boolean isGameOver(Linea linea) {
        return linea.verticalFinish() || linea.horizontalFinish();
    }

    @Override
    public char getModeChar() {
        return 'A';
    }
}