public class UseThree {

	public static void main(String[] args) {

		System.out.print("Hi ");
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.print(args[i]);
			if (i > 0) {
				System.out.print(", ");
				if (i == 1) {
					System.out.print("and ");
				} 
				
			} else {
				System.out.print(".");
			}
		}
		System.out.println();

	}

}
