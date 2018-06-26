package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;


import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;
import java.util.LinkedList;

public class AXPhi extends Phi{
	

	public AXPhi(Phi phi){
		super(phi);
	}

	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		return ctlAX(env.getStates(), phi.evaluate(env));
	}


	public HashMap<Integer, State> ctlAX(HashMap<Integer, State> states, HashMap<Integer, State> endStates) {
		LinkedList<Integer> stateNrs = new LinkedList<>();
		HashMap<Integer, State> matches = new HashMap<>();

		for (Integer key: endStates.keySet()) {
			State state = endStates.get(key);
			stateNrs.add(state.stateNr);
		}

		for (Integer key: states.keySet()) {
			State state = states.get(key);
			boolean check = true;
			for (int target : state.targets) {
				check &= stateNrs.contains(target);
			}

			if (check && state.targets.size() >= 1)
				matches.put(state.stateNr, state);
		}

		return matches;
	}

}
