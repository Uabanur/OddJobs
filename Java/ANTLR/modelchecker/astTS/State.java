package modelchecker.astTS;

import modelchecker.EnvironmentTS;
import modelchecker.VariableNotDefinedException;

import modelchecker.astTS.StateInfo;
import java.util.LinkedList;

public class State  {
	
	public boolean visited = false;
	public boolean initialState;
	public int stateNr;
	public LinkedList<String> ap;
	public LinkedList<Integer> targets;


	
	public State(StateInfo info, LinkedList<String> ap, LinkedList<Integer> targets) {
		this.initialState = info.initialState;
		this.stateNr = info.stateNr;
		this.ap = ap;
		this.targets = targets;
	}
	
	public void evaluate(EnvironmentTS env) throws VariableNotDefinedException {
		env.setState(stateNr, this);
	}

}
