package modelchecker.astTS;

import modelchecker.EnvironmentTS;
import modelchecker.VariableNotDefinedException;

public class StateInfo {
	
	public int stateNr;
	public boolean initialState;
	
	public StateInfo(int stateNr, boolean initialState) {
		this.stateNr = stateNr;
		this.initialState = initialState;
	}
	

	public void evaluate(EnvironmentTS env) throws VariableNotDefinedException {
		
	}

}
