
public class Exception2 {
	
	public static void main(String[] args) {

		try {

			printCharAt("DTU-compute", -1);
		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

		try {

			printCharAt("DTU-compute", 6);

		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

		try {

			printCharAt("DTU-compute", 12);

		} catch (StringIndexOutOfBoundsException siobe) {
			System.out.println("ERROR");
		}

	}

	public static void printCharAt(String text, int k) {
		System.out.println( text.charAt(k) );
	}

}
