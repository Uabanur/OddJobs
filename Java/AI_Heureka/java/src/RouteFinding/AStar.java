package RouteFinding;

import AbstractFramework.*;

public class AStar extends GraphSearch {

    public AStar(Map map) {
        super(map);
    }

    @Override
    public State nextState() {
        Crossing best = (Crossing)frontier.get(0);
        for(State s: frontier)
        {
            Crossing n = (Crossing)s;
            if(n.f < best.f)
                best = n;
        }
        return best;
    }

    @Override
    public boolean containsGoalState(State state) {
        return state instanceof Crossing && problem.getGoalState().equals(state);
    }

    @Override
    public void link(State parent, State child) {
        Crossing nParent = (Crossing)parent;
        Crossing nChild = (Crossing)child;
        Map map = (Map)problem;
        if(nParent == null || nChild == null || map == null) return;

        if(nChild.link == null || nChild.g > nParent.g + map.dist(nChild, nParent))
            nChild.link = nParent;
    }
}
