package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;

import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;
import java.util.LinkedList;

public class EFPhi extends Phi{
	

	public EFPhi(Phi phi){
		super(phi);
	}

	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		HashMap<Integer, State> result = ctlEF(env.getStates(), phi.evaluate(env));
		env.resetVisit();
		return result;
	}

	public HashMap<Integer, State> ctlEF(HashMap<Integer, State> states, HashMap<Integer, State> satPhi) {

		LinkedList<State> matches = new LinkedList<>();
		for (Integer key : satPhi.keySet()) {
			State endStates = satPhi.get(key);
			matches.add(endStates);
			endStates.visited = true;
		}

		for (int i = 0; i < matches.size(); i++) {
			for (Integer key : states.keySet()) {
				State state = states.get(key);
				if (state.targets.contains(matches.get(i).stateNr) && !state.visited) {
					matches.add(state);
					state.visited = true;
				}
			}
		}

		HashMap<Integer, State> result = new HashMap<>();
		for(State state: matches){
			result.put(state.stateNr, state);
		}

		return result;
	}

}
