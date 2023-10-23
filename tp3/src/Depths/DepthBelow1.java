package Depths;

import Submarine.Nemo;

public class DepthBelow1 extends DepthState {
    private int depthLevel;
    public DepthBelow1 (int depthLevel) {
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
    public String releaseCapsule(Nemo nemo) {
        throw new RuntimeException("Submarine destroyed due to excess chocolate.");
    }

    @Override
    public int getDepthState() {
        return depthLevel;
    }
}
