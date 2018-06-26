package InferenceProof;

public class Literal {
    public char symbol;
    public boolean negated;

    public Literal(char symbol, boolean negated)
    {
        this.symbol = symbol;
        this.negated = negated;
    }

    public boolean equals(Literal other)
    {
        return symbol == other.symbol && negated == other.negated;
    }

    public String toString()
    {
        return "" + (negated ? "!":"") + symbol;
    }
}