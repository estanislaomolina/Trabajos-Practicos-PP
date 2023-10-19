import Submarine.Nemo;

public class Depth1BelowSurface extends Depths{
    @Override
    public void up(Nemo nemo) {
        nemo.depth++;
    }

    @Override
    public void down(Nemo nemo) {
        nemo.depth--;
    }

    @Override
    public Object releaseCapsule(Nemo nemo) {
        return "Submarine released capsule";
    }
}
