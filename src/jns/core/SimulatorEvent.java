package jns.core;



public class SimulatorEvent extends Event {

    public SimulatorEvent(SimulatorEventType t, Simulator s) {
        super(s);
        _eventType = t;
    }

    public SimulatorEventType getType() {
        return _eventType;
    }

    private SimulatorEventType _eventType;
}
