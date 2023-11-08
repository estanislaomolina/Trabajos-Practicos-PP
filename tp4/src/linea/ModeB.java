package linea;

public class ModeB extends GameMode{

    @Override
    public Boolean isGameOver(Linea linea) {
        return linea.diagonalFinish();
    }

    @Override
    public char getModeChar() {
        return 'B';
    }
}
