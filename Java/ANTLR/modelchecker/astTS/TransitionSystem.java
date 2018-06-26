package modelchecker.astTS;

import modelchecker.EnvironmentTS;
import modelchecker.VariableNotDefinedException;

import modelchecker.astTS.State;
import java.util.LinkedList;
import java.util.List;

public class TransitionSystem {
	
	public List<State> states = new LinkedList<>();

	public TransitionSystem(LinkedList<State> states) {
		
		this.states.addAll(states);
	}

	

	public List<State> evaluate(EnvironmentTS env) throws VariableNotDefinedException {
		for(State state: states)
			state.evaluate(env);


		 return states;
	}
}
