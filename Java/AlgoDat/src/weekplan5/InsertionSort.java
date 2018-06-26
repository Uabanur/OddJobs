package weekplan5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("/Users/Roar/Documents/DTU/Algoritmer og Datastrukturer/Assignment 4/data.txt"));

		for (int N = (int) Math.pow(2, 0); N <= Math.pow(2, 18); N *= 2) {
			int[] A = new int[N];
			for (int i = 0; i < N; i++)
				A[i] = (int) (Math.random() * 100);

			long start1 = System.currentTimeMillis();
			sort(A);
			long end1 = System.currentTimeMillis();

			for (int i = 0; i < N; i++)
				A[i] = (int) (Math.random() * 100);

			long start2 = System.currentTimeMillis();
			Arrays.sort(A);
			long end2 = System.currentTimeMillis();

			pw.println(A.length + " " + (end1 - start1) + " " + (end2 - start2));
			System.out.println(N);
		}

		pw.close();
	}

	public static int[] sort(int[] A) {
		if (A.length <= 1)
			return A;

		for (int i = 1; i < A.length; i++) {
			int j = i;
			while (j > 0 && A[j] < A[j - 1]) {
				int temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				j--;
			}
		}

		return A;
	}

	public static void print(int[] A) {
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
