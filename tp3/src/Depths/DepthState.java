package Depths;

import Submarine.Nemo;

public abstract class DepthState {
    public abstract void up (Nemo nemo);
    public abstract void down (Nemo nemo);
    public abstract String releaseCapsule (Nemo nemo);
    public abstract int getDepthState();

}
