package AbstractFramework;

public abstract class Action {
    protected State start;
    protected State end;
    public Action(State _start, State _end)
    {
        this.start = _start;
        this.end = _end;
    }
    public abstract boolean equals(Action other);
}
