package jns.core;

public abstract class Simulator implements Handler {
    public abstract float now();

    public abstract EventRef schedule(float t, Event e);

    public abstract void run();

    public abstract void stop();

    public abstract void stopAt(float t);

    public abstract int getSimulatorId();

    public abstract void addSimulatorNode(Node n);

    public abstract void shutdown();
}
