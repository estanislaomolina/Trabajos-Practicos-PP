package Depths;

import Submarine.Nemo;

public class Depth0 extends DepthState {
    private int depthLevel;
    public Depth0 () {
        this.depthLevel = 0;
    }
    @Override
    public void up(Nemo nemo) {
    }

    @Override
    public void down(Nemo nemo) {
        nemo.setDepth(new Depth1(depthLevel - 1));
    }

    @Override
    public Object releaseCapsule(Nemo nemo) {
        return "Submarine released capsule";
    }

    @Override
    public int getDepthState() {
        return 0;
    }
}
