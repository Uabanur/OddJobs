public class Finder {


	public static String find(int k, int n, int b) {
		if (k < 0 || n < 0 || b <= 0)
			return "Error";

		int i = 0;
		while (n % b != 0) {

			n = n + k + (++i - 1);

		}

		if (n < 0)
			return "Overflow";
		else
			return Integer.toString(n);
	}

}
