package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;

import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;

public class EXPhi extends Phi{

	public EXPhi(Phi phi){
		super(phi);
	}
	
	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		return ctlEX(env.getStates(),phi.evaluate(env))  ;
	}

	private HashMap<Integer, State> ctlEX(HashMap<Integer, State> states, HashMap<Integer, State> satPhi) {
		HashMap<Integer, State> matches = new HashMap<>();

		loop: for (Integer key1 : states.keySet()) {
			State state = states.get(key1);

			for (int target : state.targets) {

				for (Integer key2 : satPhi.keySet()) {
					State end = satPhi.get(key2);

					if (target == end.stateNr) {
						matches.put(state.stateNr, state);
						continue loop;
					}
				}
			}
		}
		return matches;
	}

}
