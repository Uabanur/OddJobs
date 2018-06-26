package while_language.ast;

import while_language.Environment;
import while_language.VariableNotDefinedException;

public class WhileStatement extends Statement {

	private BoolExpr condition;
	private Statement doBranch;
	
	public WhileStatement(BoolExpr condition, Statement doBranch) {
		this.condition = condition;
		this.doBranch = doBranch;
	}
	
	@Override
	public void evaluate(Environment env) throws VariableNotDefinedException {
		while (condition.evaluate(env)) {
			doBranch.evaluate(env);	
		} 
	}

}
