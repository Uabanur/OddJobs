package weekplan5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RandomSequence {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("/Users/Roar/Documents/DTU/Algoritmer og Datastrukturer/Assignment 4/default.txt"));
		for (int i = 0; i <= 100; i++) {

			long time = System.currentTimeMillis();
			int[] A = generate(i);

			Arrays.sort(A);

			System.out.println("Length of array: " + A.length);
			System.out.println("Time used: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds.");
			System.out.println();

			pw.println(A.length + " " + (System.currentTimeMillis() - time));
		}
		pw.close();
	}

	public static int[] generate(int i) {
		int[] A = new int[i * 1000000];

		for (int n = 0; n < A.length; n++) {
			A[n] = (int) (Math.random() * 100);
		}

		return A;
	}

}
