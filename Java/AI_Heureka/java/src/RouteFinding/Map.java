package RouteFinding;

import AbstractFramework.Action;
import AbstractFramework.Problem;
import AbstractFramework.State;

import java.util.ArrayList;
import java.util.List;

public class Map extends Problem
{
    @Override
    public List<State> expandState(State leaf) {
        Crossing n = (Crossing)leaf;
        if(n == null) throw new IllegalArgumentException("Map state was not of type Crossing");

        List<State> explored = new ArrayList<>();
        for(Action a: actionList)
        {
            Street e = (Street)a;
            if(n.equals(e.getStart()))
            {
                if(!e.getEnd().visited)
                {
                    e.getEnd().h = heuristic(e.getEnd());
                    e.getEnd().g = n.g + dist(n, e.getEnd());
                    e.getEnd().f = e.getEnd().h+e.getEnd().g;
                    e.getEnd().visited = true;
                }
                if(!explored.contains(e.getEnd()))
                    explored.add(e.getEnd());
            }
        }

        return explored;
    }

    @Override
    public double heuristic(State s1) {
        Crossing n = (Crossing)s1; Crossing g = (Crossing)getGoalState();
        if(n == null || g == null) throw new IllegalArgumentException("Map state was not of type Crossing or does not have a goal state");

        return dist(n, g);
    }

    @Override
    public void initializeFrontier(List<State> frontier) {
        frontier.add(getInitialState());
    }

    //Helper functions specific for maps

    public void add(Street street)
    {
        //Make sure all states are unique
        for(State s : stateList)
        {
            if(street.getStart().equals(s))
                street.setStart((Crossing)s);

            if(street.getEnd().equals(s))
                street.setEnd((Crossing)s);
        }

        this.actionList.add(street);
        this.stateList.add(street.getStart());

        if(!street.getStart().equals(street.getEnd()))
            this.stateList.add(street.getEnd());
    }

    public void setStart(String road1, String road2)
    {
        Crossing first = crossingAt(road1, road2);

        if(getGoalState() != null)
        {
            first.g = 0;
            first.h = heuristic(first);
            first.f = first.g + first.h;
            first.visited = true;
        }

        setInitialState(first);
    }

    public void setGoal(String road1, String road2)
    {
        setGoalState(crossingAt(road1, road2));

        Crossing first = (Crossing)getInitialState();
        if(first != null)
        {
            first.g = 0;
            first.h = heuristic(first);
            first.f = first.g + first.h;
            first.visited = true;
        }

    }

    private Crossing crossingAt(String road1, String road2)
    {
        if(road1.equals(road2))
            throw new IllegalArgumentException("Cannot find a unique crossing on only one road.");

        for(Action a1: actionList) for(Action a2: actionList)
        {
            Street e1 = (Street)a1; Street e2 = (Street)a2;
            if(e1==e2)
                continue;

            if(e1.label.equals(road1) && e2.label.equals(road2)) {
                if (e1.getStart().equals(e2.getStart()) || e1.getStart().equals(e2.getEnd()))
                    return e1.getStart();

                if (e1.getEnd().equals(e2.getStart()) || e1.getEnd().equals(e2.getEnd()))
                    return e1.getEnd();
            }
        }

        throw new IllegalArgumentException("Crossing not found in map");
    }

    String labelBetween(Crossing n1, Crossing n2)
    {
        for(Action a: actionList) {
            Street e = (Street)a;
            if ((e.getStart().equals(n1) && e.getEnd().equals(n2)) || (e.getStart().equals(n2) && e.getEnd().equals(n1)))
                return e.label;
        }
        throw new IllegalArgumentException("Street not");
    }

    double dist(Crossing a, Crossing b)
    {
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }

    public static Map populatedMap()
    {
        Map map = new Map();
        map.add(new Street(new Crossing(10.0, 70.0), "Vestervoldgade", new Crossing(20.0, 50.0)));
        map.add(new Street(new Crossing(20.0, 50.0), "Vestervoldgade", new Crossing(10.0, 70.0)));
        map.add(new Street(new Crossing(20.0, 50.0), "Vestervoldgade", new Crossing(35.0, 35.0)));
        map.add(new Street(new Crossing(35.0, 35.0), "Vestervoldgade", new Crossing(20.0, 50.0)));

        map.add(new Street(new Crossing(10.0, 70.0), "SktPedersStraede", new Crossing(35.0, 80.0)));
        map.add(new Street(new Crossing(35.0, 80.0), "SktPedersStraede", new Crossing(50.0, 90.0)));
        map.add(new Street(new Crossing(65.0, 100.0), "SktPedersStraede", new Crossing(50.0, 90.0)));

        map.add(new Street(new Crossing(20.0, 50.0), "Studiestraede", new Crossing(45.0, 70.0)));
        map.add(new Street(new Crossing(45.0, 70.0), "Studiestraede", new Crossing(70.0, 85.0)));

        map.add(new Street(new Crossing(55.0, 55.0), "Vestergade", new Crossing(35.0, 35.0)));
        map.add(new Street(new Crossing(80.0, 70.0), "Vestergade", new Crossing(55.0, 55.0)));

        map.add(new Street(new Crossing(60.0, 150.0), "Noerregade", new Crossing(65.0, 110.0)));
        map.add(new Street(new Crossing(65.0, 110.0), "Noerregade", new Crossing(65.0, 100.0)));
        map.add(new Street(new Crossing(65.0, 100.0), "Noerregade",new Crossing(70.0, 85.0)));
        map.add(new Street(new Crossing(70.0, 85.0), "Noerregade",new Crossing(80.0, 70.0)));

        map.add(new Street(new Crossing(45.0, 70.0), "Larsbjoernsstraede", new Crossing(55.0, 55.0)));
        map.add(new Street(new Crossing(45.0, 70.0), "Larsbjoernsstraede", new Crossing(35.0, 80.0)));

        map.add(new Street(new Crossing(25.0, 100.0), "TeglgaardsStraede", new Crossing(35.0, 80.0)));

        map.add(new Street(new Crossing(50.0, 90.0), "LarslejStraede", new Crossing(35.0, 120.0)));

        map.add(new Street(new Crossing(10.0, 70.0), "Noerrevoldgade", new Crossing(25.0, 100.0)));
        map.add(new Street(new Crossing(25.0, 100.0), "Noerrevoldgade",new Crossing(10.0, 70.0)));
        map.add(new Street(new Crossing(25.0, 100.0), "Noerrevoldgade", new Crossing(35.0, 120.0)));
        map.add(new Street(new Crossing(35.0, 120.0), "Noerrevoldgade", new Crossing(25.0, 100.0)));
        map.add(new Street(new Crossing(35.0, 120.0), "Noerrevoldgade", new Crossing(60.0, 150.0)));
        map.add(new Street(new Crossing(60.0, 150.0), "Noerrevoldgade", new Crossing(35.0, 120.0)));

        return map;
    }
}
