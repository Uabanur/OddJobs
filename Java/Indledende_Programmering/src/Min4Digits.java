public class Min4Digits {


	public static String min4Digits(int n) {
		
		boolean isNegative = false;

		if (n < 0)
			isNegative = true;

		n = Math.abs(n);
		
		String s = Integer.toString(n);

		
		for(int i = s.length(); i < 4; i++ ){
			s = "0" + s;
		}

		if (isNegative)
			s = "-" + s;

		return s;
	}

}


