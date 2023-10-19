import Submarine.Nemo;

public class DepthSurface extends Depths {

    @Override
    public void up(Nemo nemo) {
        throw new RuntimeException("Invalid depth, cannot go up");
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
