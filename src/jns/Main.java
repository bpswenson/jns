package jns;

import jns.core.*;

public class Main {

    public static void main(String[] args) {

        SimulatorSequential seq = new SimulatorSequential();
        seq.schedule(5.0f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.schedule(8.0f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.schedule(1.5f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.schedule(9.0f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.schedule(8.5f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.schedule(3.0f, new SimulatorEvent(SimulatorEventType.DUMB_EVENT, seq));
        seq.run();
    }
}
