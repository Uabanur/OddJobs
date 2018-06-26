package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;

import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;
import java.util.LinkedList;

public class AGPhi extends Phi{
	

	public AGPhi(Phi phi){
		super(phi);
	}

	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		return ctlAG(env.getStates(), phi.evaluate(env), env);
	}

	public HashMap<Integer, State> ctlAG(HashMap<Integer, State> states, HashMap<Integer, State> endStates, EnvironmentF env) {
		LinkedList<Integer> stateNrs = new LinkedList<>();
		HashMap<Integer, State> matches = new HashMap<>();

		for (Integer key : endStates.keySet()) {
			State state = endStates.get(key);
			stateNrs.add(state.stateNr);
		}

		for (Integer key : states.keySet()) {
			State state = states.get(key);
			env.resetVisit();
			if (chkAG(state, stateNrs, env))
				matches.put(state.stateNr, state);
		}

		return matches;
	}

	private boolean chkAG(State state, LinkedList<Integer> stateNrs, EnvironmentF env) {
		if (!state.visited) {
			if (stateNrs.contains(state.stateNr)) {

				state.visited = true;

				boolean check = true;
				for (int target : state.targets)
					check &= chkAG(env.getState(target), stateNrs, env);

				return check;
			} else
				return false;
		} else
			return true;
	}

}
