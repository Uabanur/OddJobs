package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;

import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;

public class Phi{
	
	String ap;
	Phi phi;

	public Phi(String ap){
		this.ap = ap;
	}

	public Phi(Phi phi){
		this.phi = phi;
	}

	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		if(phi == null){
			if(ap.equals("tt"))
				return env.getStates();
			else
				return ctlAP(ap, env.getStates());
		}

		else
			return phi.evaluate(env);

	}
	

	private HashMap<Integer, State> ctlAP(String ap, HashMap<Integer, State> states) {
		HashMap<Integer, State> matches = new HashMap<>();
		for (Integer key : states.keySet()) {
			State state = states.get(key);
			if (state.ap.contains(ap))
				matches.put(state.stateNr, state);
		}

		return matches;
	}

}
