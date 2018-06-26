package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;


import modelchecker.astF.Phi;


import java.util.HashMap;
import java.util.Map.Entry;
import modelchecker.astTS.State;

public class ANDPhi extends Phi{
	
	public Phi phi1;
	public Phi phi2;

	public ANDPhi(Phi phi1, Phi phi2){
		super("");
		this.phi1=phi1;
		this.phi2=phi2;

	}
	
	@Override
	public HashMap<Integer, State> evaluate(EnvironmentF env) {
		return ctlAND(this.phi1.evaluate(env), this.phi2.evaluate(env));
	}

	public HashMap<Integer, State> ctlAND(HashMap<Integer, State> satPhi1, HashMap<Integer, State> satPhi2) {
		HashMap<Integer, State> matches = new HashMap<>();

		for (Integer key1 : satPhi1.keySet()) {
			State phi1 = satPhi1.get(key1);

			if (satPhi2.containsValue(phi1))
				matches.put(phi1.stateNr, phi1);
		}

		return matches;
	}

}
