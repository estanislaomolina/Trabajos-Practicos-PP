package Depths;

import Submarine.Nemo;

public class DepthBelow1 extends DepthState {

    @Override
    public void up(Nemo nemo) {
        nemo.removeDepth();
    }

    @Override
    public void down(Nemo nemo) {
        nemo.setDepth(new DepthBelow1());
    }

    @Override
    public Object releaseCapsule(Nemo nemo) {
        throw new RuntimeException("Submarine destroyed due to excess chocolate.");
    }
}
