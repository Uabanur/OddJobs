package RouteFinding;

import AbstractFramework.State;

import java.util.ArrayList;

public class Crossing extends State {
    double f;
    double g;
    double h;
    double x;
    double y;
    boolean visited;

    Crossing(double _x, double _y)
    {
        this.visited = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.x = _x;
        this.y = _y;
    }

    @Override
    public boolean equals(State other) {
        Crossing asCrossing = (Crossing)other;

        return asCrossing != null &&
                this.x == asCrossing.x &&
                this.y == asCrossing.y;
    }

    //Helper functions specific for AStar search

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public ArrayList<String> getPath(Map map)
    {
        return this.backTrack(map, new ArrayList<>());
    }

    private ArrayList<String> backTrack(Map map, ArrayList<String> list)
    {
        Crossing parent = (Crossing)link;
        if(parent != null)
        {
            parent.backTrack(map, list);
            String label = map.labelBetween(parent, this);
            list.add(label);
        }
        return list;
    }
}
