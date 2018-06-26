package modelchecker;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import modelchecker.astTS.TransitionSystem;
import modelchecker.parserTS.ModelCheckerLexer;
import modelchecker.parserTS.ModelCheckerParser;

public class ModelChecker {

	public static void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.out.println("Error: No program specified.");
			return;
		}
		
        ModelCheckerLexer lex = new ModelCheckerLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ModelCheckerParser parserTS = new ModelCheckerParser(tokens);
        TransitionSystem myTS = parserTS.system();

        try {
        	EnvironmentTS env = new EnvironmentTS();
        	myTS.evaluate(env);
        	System.out.println(env.toString());
        } catch (VariableNotDefinedException e) {
        	System.out.println("Error: " + e);
        } catch (NullPointerException e) {
        	System.out.println("Error parsing program.");
        }

	}
	
}
