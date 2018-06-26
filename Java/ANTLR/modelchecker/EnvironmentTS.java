package modelchecker;

import java.util.HashMap;
import java.util.Map.Entry;

import modelchecker.astTS.State;

public class EnvironmentTS {

	private HashMap<Integer, State> states = new HashMap<>();
	
	public EnvironmentTS() { }
	
	public void setState(Integer stateNr, State state) {
		states.put(stateNr, state);
	}
	
	public State getState(Integer stateNr) throws VariableNotDefinedException {
		State state = states.get(stateNr); 
		if (state == null) throw new VariableNotDefinedException(""+stateNr);
		return state;
	}

		public HashMap<Integer, State> getStates(){
		return states;
	}
	
	public String toString() {
		String table = "";
		for (Integer key : states.keySet()) {
			State state = states.get(key);

			table +=   key + (state.initialState? "*" : "") + "\t-> " + state.ap + "\t" + state.targets + "\n";
		}
		return table;
	}
	
}
