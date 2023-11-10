package linea;

public class ModeB extends GameMode{

    @Override
    public Boolean isGameOver(Linea linea) {
        return linea.diagonalFinish();
    }

    @Override
    public Boolean isTie(Linea linea) {
        return linea.isFull();
    }

    @Override
    public char getModeChar() {
        return 'B';
    }
}
