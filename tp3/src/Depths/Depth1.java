package Depths;

import Submarine.Nemo;

public class Depth1 extends DepthState {
    private int depthLevel;

    public Depth1(int depthLevel) {
        this.depthLevel = depthLevel;
    }
    @Override
    public void up(Nemo nemo) {
        nemo.removeDepth();
    }

    @Override
    public void down(Nemo nemo) {
        nemo.setDepth(new DepthBelow1(depthLevel - 1));
    }

    @Override
    public Object releaseCapsule(Nemo nemo) {
        return "Submarine released capsule";
    }

    @Override
    public int getDepthState() {
        return -1;
    }
}
