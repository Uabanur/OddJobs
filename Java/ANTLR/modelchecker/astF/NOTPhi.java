package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;

import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;

public class NOTPhi extends Phi{
	

	public NOTPhi(Phi phi){
		super(phi);

	}
	
	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		return ctlNOT(env.getStates(), phi.evaluate(env));
	}


	private HashMap<Integer, State> ctlNOT(HashMap<Integer, State> states, HashMap<Integer, State> unwanted){

		HashMap<Integer, State> invertedSet = new HashMap<>();
		for (Integer key : states.keySet()) {
			State state = states.get(key);
			if (!unwanted.containsValue(state)) {
				invertedSet.put(state.stateNr, state);
			}
		}

		return invertedSet;
	}
}
