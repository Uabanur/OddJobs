package modelchecker;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import modelchecker.astF.Formula;
import modelchecker.parserF.FormulaCheckerLexer;
import modelchecker.parserF.FormulaCheckerParser;

public class FormulaChecker {

	public static void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.out.println("Error: No program specified.");
			return;
		}
		
        FormulaCheckerLexer lex = new FormulaCheckerLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        FormulaCheckerParser parserF = new FormulaCheckerParser(tokens);
        Formula formula = parserF.formula();

        try {
        	EnvironmentF env = new EnvironmentF();
        	formula.evaluate(env);
        	System.out.println(env.toString());
        } catch (VariableNotDefinedException e) {
        	System.out.println("Error: " + e);
        } catch (NullPointerException e) {
        	System.out.println("Error parsing program.");
        }

	}
	
}
