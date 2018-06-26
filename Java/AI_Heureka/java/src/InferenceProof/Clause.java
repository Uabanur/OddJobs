package InferenceProof;

import AbstractFramework.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clause extends State {
    public ArrayList<Literal> literals;

    public Clause(List<Literal> ls)
    {
        literals = new ArrayList<>();
        literals.addAll(ls);
        removeDuplicates();
    }

    public Clause(Literal... ls)
    {
        this(Arrays.asList(ls));
    }

    @Override
    public boolean equals(State other) {
        Clause cOther = (Clause)other;
        if(cOther == null) return false;

        for(Literal l: literals)
            if(!cOther.contains(l)) return false;

        return literals.size() == cOther.literals.size();
    }

    //Helper functions

    private void removeDuplicates()
    {
        for(int i = 0; i < literals.size(); i++) for(int j = i+1; j < literals.size(); j++)
            if(literals.get(i).equals(literals.get(j)))
                literals.remove(literals.get(j));
    }

    private boolean contains(Literal n)
    {
        for(Literal l: literals)
            if(n.equals(l)) return true;

        return false;
    }

    public boolean isEmpty()
    {
        return literals.isEmpty();
    }

    public String toString()
    {
        return literals.toString();
    }
}