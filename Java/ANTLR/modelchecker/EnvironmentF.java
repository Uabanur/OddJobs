package modelchecker;

import java.util.HashMap;
import java.util.Map.Entry;

import modelchecker.astTS.State;

public class EnvironmentF {

	private HashMap<Integer, State> states = new HashMap<>();
	private HashMap<Integer, State> result = new HashMap<>();
	
	public EnvironmentF() { }
	
	public void setResult(HashMap<Integer, State> result) throws VariableNotDefinedException{
		if(result == null) throw new VariableNotDefinedException("result");
		this.result = result;
	}
	
	public HashMap<Integer, State> getResult() {
		return this.result;
	}
	
	public HashMap<Integer, State> getStates(){
		return states;
	}

	public State getState(int stateNr){
		return states.get(stateNr);
	}

	public void resetVisit() {
		for (Integer key : result.keySet()) {
			State state = result.get(key);
			state.visited = false;
		}
	}

	public void setStates(HashMap<Integer, State> states){
		this.states = states;
	}

	public String toString() {
		String table="";

		for (Integer key : result.keySet()) {
			State state = result.get(key);

			table +=   key + (state.initialState? "*" : "") + "\t-> " + state.ap + "\t" + state.targets + "\n";
		}
		return table;
	}


	
}
