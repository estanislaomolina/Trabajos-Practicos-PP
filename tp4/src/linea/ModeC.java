package linea;

public class ModeC extends GameMode{
    @Override
    public Boolean isGameOver(Linea linea) {
        return linea.verticalFinish() || linea.horizontalFinish() || linea.diagonalFinish();
    }

    @Override
    public Boolean isTie(Linea linea) {
        return linea.isFull();
    }

    @Override
    public char getModeChar() {
        return 'C';
    }
}
