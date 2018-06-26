package AbstractFramework;

public abstract class State {

    public State link;
    public abstract boolean equals(State other);
}
