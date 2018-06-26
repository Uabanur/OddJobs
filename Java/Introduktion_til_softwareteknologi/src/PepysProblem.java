import java.util.Random;

public class PepysProblem {

	public static void main(String[] args) {

		Random r = new Random();
		int sum = 0, runGames = 10000000, runTestofGames = 1;

		newtonsTest(runGames, runTestofGames, r);
		pepysTest(runGames, runTestofGames, r);

	}

	private static void newtonsTest(int runGames, int runTestofGames, Random r) {
		boolean first1 = false, second1 = false;
		int sum = 0;

		for (int k = 0; k < runTestofGames; k++) {

			for (int j = 0; j < runGames; j++) {

				for (int i = 0; i < 12; i++) {

					if (first1 && (r.nextInt(6) + 1 == 1))
						second1 = true;

					if (r.nextInt(6) + 1 == 1)
						first1 = true;

				}

				if (second1) {
					sum++;
				}
				
				first1 = second1 = false;

			}

			System.out.printf("Newton \n%f\n", (float) sum / (float) runGames);
			sum = 0;
			first1 = second1 = false;
		}

	}

	private static void pepysTest(int runGames, int runTestofGames, Random r) {

		boolean check = false;
		int sum = 0;

		for (int trys = 0; trys < runTestofGames; trys++) {

			for (int i = 0; i < runGames; i++) {

				for (int j = 0; j < 6; j++) {

					if ((r.nextInt(6) + 1) == 1)
						check = true;

				}

				if (check) {
					sum++;
					check = false;
				}

			}

			System.out.printf("Pepy \n%f\n", (float) sum / (float) runGames);
			sum = 0;
			check = false;
		}

	}

}