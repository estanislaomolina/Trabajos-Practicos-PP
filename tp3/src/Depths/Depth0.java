package Depths;

import Submarine.Nemo;

public class Depth0 extends DepthState {
    @Override
    public void up(Nemo nemo) {
    }

    @Override
    public void down(Nemo nemo) {
        nemo.setDepth(new Depth1());
    }

    @Override
    public Object releaseCapsule(Nemo nemo) {
        return "Submarine released capsule";
    }
}
