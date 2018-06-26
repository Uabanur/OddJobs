package AbstractFramework;

public class Result {
    public boolean success;
    public State state;
    public Result(State _state, boolean _success)
    {
        this.success = _success;
        this.state = _state;
    }
}
