package InferenceProof;

import AbstractFramework.GraphSearch;
import AbstractFramework.State;

public class RefutationProver extends GraphSearch{

    public RefutationProver(KnowledgeBase KB)
    {
        super(KB);
    }

    @Override
    public State nextState() {
        return frontier.get(0);
    }

    @Override
    public boolean containsGoalState(State state)
    {
        Clause c = (Clause)state;
        return c != null && c.isEmpty();
    }
}
