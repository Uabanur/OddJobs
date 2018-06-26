import AbstractFramework.*;
import InferenceProof.*;
import RouteFinding.*;

public class Main {
    public static void main(String[] args)
    {

        // Test AStar

        Map map = Map.populatedMap();
        map.setStart("Vestervoldgade", "Studiestraede");
        map.setGoal("SktPedersStraede", "Noerregade");

        AStar astar = new AStar(map);
        Result res2 = astar.solve();
        Crossing start = (Crossing) map.getInitialState();
        Crossing end = (Crossing) map.getGoalState();
        System.out.println("\nAstar from " + start + " to " + end + ": ");
        if(res2.success)
        {
            Crossing goal = (Crossing)res2.state;
            System.out.println("Path: " + goal.getPath(map));
        } else
        {
            System.out.println("AStart found no path");
        }


        // Test Inference proover

        System.out.println("\nResulotion Inference Prover: ");
        KnowledgeBase KB = new KnowledgeBase();
        KB.add(new Clause(new Literal('a', false),
                            new Literal('b', false)));
        RefutationProver res = new RefutationProver(KB);

        Clause phi = new Clause(new Literal('a', false));
        System.out.println("Hypothesis: " + phi);
        System.out.println("Knowledge base: " + KB);

        KB.setHypothesis(phi);
        Result r = res.solve();
        if(r.success)
        {
            System.out.println("Succeeded!");
        }
        else
        {
            System.out.println("Not proven");
        }
    }
}
