
public class StringReplicator {

	public static void main(String[] args) {
		
		repl("hello", 1);
		
	}

	private static void repl(String string, int amount) {
		String output = "";
		for(int i = 0; i < amount; i++ )
			output += string;
		
		System.out.println(output);
	}
	
	
}


