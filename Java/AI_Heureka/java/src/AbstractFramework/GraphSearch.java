package AbstractFramework;
import java.util.LinkedList;
import java.util.List;

public abstract class GraphSearch {

    protected Problem problem;
    protected List<State> frontier;
    protected List<State> explored;
    private boolean verbose;
    public GraphSearch(Problem _problem)
    {
        this.problem = _problem;
        frontier = new LinkedList<>();
        explored = new LinkedList<>();
        verbose = false;
    }

    public void verbose(boolean value)
    {
        this.verbose = value;
    }

    public Result solve()
    {
        problem.initializeFrontier(frontier);

        while(true)
        {
            if(frontier.isEmpty())
                return new Result(null, false);

            State leaf = nextState();

            if(verbose)
                System.out.println("Leaf: " + leaf);

            frontier.remove(leaf);

            if(containsGoalState(leaf))
            {
                if(verbose)
                    System.out.println("Finished!");
                return new Result(leaf, true);
            }

            explored.add(leaf);

            List<State> newStates =  problem.expandState(leaf);

            for(State state: newStates)
            {
                if(verbose)
                    System.out.println("child of leaf: " + state);

                boolean exists = false;

                for(State known: frontier)
                    if(state.equals(known))
                        exists = true;

                for(State known: explored)
                    if(state.equals(known))
                        exists = true;

                if(!exists)
                    frontier.add(state);

                exists = false;
                for(State known: frontier)
                    if(state.equals(known))
                        exists = true;

                if(exists)
                    link(leaf, state);
            }
            if(verbose)
                System.out.println();
        }
    }

    public abstract State nextState();
    public abstract boolean containsGoalState(State state);
    public void link(State parent, State child){}
}