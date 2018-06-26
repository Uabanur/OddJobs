public class CaesarCipher {

	public static String encode(String input, int k) {
		boolean error = false;
		
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >90 || input.charAt(i) < 65 || k < 0 || k > 25){
				error = true;
				break;
			}
			output += (char) (((input.charAt(i) - 65 + k) % 26) + 65);
		}
		if(error)
			return "**ERROR**";
		else
			return output;
	}

	public static String decode(String input, int k) {
		boolean error = false;

		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >90 || input.charAt(i) < 65 || k < 0 || k > 25){
				error = true;
				break;
			}
			
			if(input.charAt(i) >= k+65){
				output += (char) (input.charAt(i) - k);
			} else if (input.charAt(i) <= k+90){
				output += (char) (input.charAt(i)-k+26);
			}
			
		}
		if(error)
			return "**ERROR**";
		else
			return output;
	}
}
