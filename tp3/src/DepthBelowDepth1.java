import Submarine.Nemo;

public class DepthBelowDepth1 extends Depths{

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
        throw new RuntimeException("Submarine destroyed due to excess chocolate.");
    }
}
