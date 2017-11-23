package jns.core;

public abstract class Event {
    Event(Handler h) {
        _handler = h;
        _cancel = false;
    }

    public void execute(Simulator s) {
        if(!_cancel) {
            _handler.handle(s, this);
        }
    }

    public void setCancel() {
        _cancel = true;
    }

    public void clearCancel() {
        _cancel = false;
    }

    private Handler _handler;
    private boolean _cancel;
}
