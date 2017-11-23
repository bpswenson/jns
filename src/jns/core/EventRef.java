package jns.core;

public class EventRef implements Comparable<EventRef> {
    public EventRef(float t, Event e) {
        _event = e;
        _time = t;
        _id = _nextId++;
    }

    public void setCancel() {
        _event.setCancel();
    }

    public void clearCancel() {
        _event.clearCancel();
    }

    public void execute(Simulator s) {
        _event.execute(s);
    }

    public float getTime() {
        return _time;
    }

    public int compareTo(EventRef rhs) {
        if(_time < rhs._time) {
            return -1;
        }
        else if(_time > rhs._time) {
            return 1;
        }
        if(_id < rhs._id) {
            return -1;
        }
        return 1;

    }

    private Event _event;
    private float _time;
    private int _id;
    private static int _nextId = 0;
}
