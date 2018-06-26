public class Checkerboard {

	public static void main(String[] args) {

		for (int i = 0; i < Integer.parseInt(args[0]); i++) {

			for (int j = 0; j < Integer.parseInt(args[0]); j++) {

				if ((j + i) % 2 == 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}
	}
}