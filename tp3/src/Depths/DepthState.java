package Depths;

import Submarine.Nemo;

public abstract class DepthState {
    public abstract void up (Nemo nemo);
    public abstract void down (Nemo nemo);
    public abstract Object releaseCapsule (Nemo nemo);
}
