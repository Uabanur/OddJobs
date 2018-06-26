package modelchecker.astF;

import modelchecker.EnvironmentF;
import modelchecker.VariableNotDefinedException;

public class Formula {
	
	public Phi phi;

	public Formula(Phi phi){
		this.phi = phi;
	}

	public void evaluate(EnvironmentF env) throws VariableNotDefinedException {
		env.setResult(phi.evaluate(env));
	}
}
