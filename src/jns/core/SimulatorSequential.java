package jns.core;

import java.util.TreeSet;
import java.util.ArrayList;

public class SimulatorSequential extends Simulator {
    public void handle(Simulator s, Event e) {
        SimulatorEvent ev = (SimulatorEvent)e;
        SimulatorEventType type = ev.getType();

        switch(type) {
            case DUMB_EVENT:
                System.out.println("Dumb Event at time " + _currentTime);
                break;
            case STOP_EVENT:
                _running = false;
                break;
        }
    }

    public float now() {
        return _currentTime;
    }

    public EventRef schedule(float t, Event e) {
        EventRef ref = new EventRef(t + _currentTime, e);
        _eventQueue.add(ref);
        return ref;
    }

    public void stopAt(float t) {
        schedule(_currentTime + t, new SimulatorEvent(SimulatorEventType.STOP_EVENT, this));
    }

    public int getSimulatorId() {
        return 1;
    }

    public void addSimulatorNode(Node n) {
        _nodes.add(n);
    }

    public void stop() {
        _running = false;
    }

    public void run() {
        _running = true;

        while(!_eventQueue.isEmpty() && _running) {
            EventRef nextEvent = _eventQueue.pollFirst();
            _currentTime = nextEvent.getTime();
            nextEvent.execute(this);
        }

        System.out.println("Simulation Ended");
    }

    public void shutdown() {}

    private float _currentTime;
    private boolean _running = false;
    private TreeSet<EventRef> _eventQueue = new TreeSet<>();
    private ArrayList<Node> _nodes = new ArrayList<>();
}
