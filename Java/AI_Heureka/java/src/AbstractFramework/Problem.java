package AbstractFramework;

import java.util.LinkedList;
import java.util.List;

public abstract class Problem {

    protected List<State> stateList = new LinkedList<>();
    protected List<Action> actionList = new LinkedList<>();
    private State initialState;
    private State goalState;

    public abstract List<State> expandState(State leaf);
    public double heuristic(State s1){return 0;}

    public State getInitialState() {
        return initialState;
    }
    public void setInitialState(State _initialState)
    {
        this.initialState = _initialState;
    }

    public State getGoalState() {
        return goalState;
    }

    public void setGoalState(State goalState) {
        this.goalState = goalState;
    }

    public abstract void initializeFrontier(List<State> frontier);
}