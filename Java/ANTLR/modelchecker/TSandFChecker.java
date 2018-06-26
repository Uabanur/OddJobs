package modelchecker;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import modelchecker.astTS.TransitionSystem;
import modelchecker.parserTS.ModelCheckerLexer;
import modelchecker.parserTS.ModelCheckerParser;

import modelchecker.astF.Formula;
import modelchecker.parserF.FormulaCheckerLexer;
import modelchecker.parserF.FormulaCheckerParser;

public class TSandFChecker {

	public static void main(String args[]) throws Exception {
                if (args.length < 2) {
                        System.out.println("Error: Needs transition system and formula.");
                        return;
                }
		
        ModelCheckerLexer lexTS = new ModelCheckerLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokensTS = new CommonTokenStream(lexTS);

        FormulaCheckerLexer lexF = new FormulaCheckerLexer(new ANTLRFileStream(args[1]));
        CommonTokenStream tokensF = new CommonTokenStream(lexF);

        ModelCheckerParser parserTS = new ModelCheckerParser(tokensTS);
        TransitionSystem myTS = parserTS.system();

        FormulaCheckerParser parserF = new FormulaCheckerParser(tokensF);
        Formula formula = parserF.formula();

        try {
        	EnvironmentTS envTS = new EnvironmentTS();
        	myTS.evaluate(envTS);
        	System.out.println("System: \n" + envTS.toString());
                
                System.out.println("\n");

                EnvironmentF envF = new EnvironmentF();
                envF.setStates(envTS.getStates());

                formula.evaluate(envF);
                System.out.println("Result: \n" + envF.toString());

        } catch (VariableNotDefinedException e) {
        	System.out.println("Error: " + e);
        } catch (NullPointerException e) {
        	System.out.println("Error parsing program.");
        }

	}
	
}
