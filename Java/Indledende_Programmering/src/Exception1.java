public class Exception1 {

	public static void main(String[] args) {

		try {

			System.out.println(getCharAt("DTU-compute", -1));
		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

		try {

			System.out.println(getCharAt("DTU-compute", 6));

		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

		try {

			System.out.println(getCharAt("DTU-compute", 12));

		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

	}

	public static char getCharAt(String text, int k) {
		return text.charAt(k);
	}

}
