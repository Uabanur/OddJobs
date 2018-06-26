package RouteFinding;

import AbstractFramework.Action;

public class Street extends Action {
    String label;
    public Street(Crossing _start, String _label, Crossing _end)
    {
        super(_start, _end);
        this.label = _label;
    }

    @Override
    public boolean equals(Action other) {
        Street asStreet = (Street)other;
        return asStreet != null &&
                this.getStart().equals(asStreet.getStart()) &&
                this.getEnd().equals(asStreet.getEnd())&&
                this.label.equals(asStreet.label);
    }

    //GETTERS AND SETTERS
    public Crossing getStart()
    {
        return (Crossing)this.start;
    }

    public void setStart(Crossing _start)
    {
        this.start = _start;
    }

    public Crossing getEnd()
    {
        return (Crossing)this.end;
    }

    public void setEnd(Crossing _end)
    {
        this.end = _end;
    }

}
