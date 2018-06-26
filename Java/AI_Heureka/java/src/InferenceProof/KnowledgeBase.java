package InferenceProof;

import AbstractFramework.*;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase extends Problem{

    public void setHypothesis(Clause phi)
    {
        for(Literal l: phi.literals)
            add(new Clause(new Literal(l.symbol, !l.negated)));
    }

    public void add(Clause c)
    {
        stateList.add(c);
    }

    @Override
    public List<State> expandState(State leaf) {
        Clause c1 = (Clause)leaf;

        //Perform resolution on all known clauses based on the given clause
        ArrayList<State> clauses = new ArrayList<>();

        for(State s: stateList)
        {
            Clause c2 = (Clause)s;
            for(Literal l1: c1.literals) for(Literal l2: c2.literals)
            {
                if (l1.symbol == l2.symbol && l1.negated != l2.negated)
                {
                    ArrayList<Literal> literals = new ArrayList<>();
                    literals.addAll(c1.literals);
                    literals.addAll(c2.literals);
                    literals.remove(l1);
                    literals.remove(l2);
                    clauses.add(new Clause(literals));
                }
            }
        }
        return clauses;
    }

    @Override
    public void initializeFrontier(List<State> frontier) {
        frontier.addAll(stateList);
    }

    public String toString()
    {
        StringBuilder clauseList = new StringBuilder();
        for(int i = 0; i < stateList.size(); i++)
        {
            clauseList.append(stateList.get(i).toString());

            if(i < stateList.size()-1)
                clauseList.append(" and ");
        }
        return clauseList.toString();
    }
}