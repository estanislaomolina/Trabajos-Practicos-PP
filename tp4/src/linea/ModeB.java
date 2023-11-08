package linea;

public class ModeB extends GameMode{

    @Override
    public Boolean isGameOver(Linea linea) {
        return linea.verticalFinish() && linea.horizontalFinish();
    }

    @Override
    public char getModeChar() {
        return 'B';
    }
}
