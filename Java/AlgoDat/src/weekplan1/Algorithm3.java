package weekplan1;

import java.util.Scanner;

public class Algorithm3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] A = new int[sc.nextInt()];

		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		System.out.println(algorithm3(A, 0, A.length));

		sc.close();
	}

	private static int algorithm3(int[] A, int i, int j) {

		int m = (i + j) / 2;

		if (m == 0) {
			if (A[m] >= A[m + 1])
				return m;
		} else if (m == A.length - 1) {
			if (A[m] >= A[m - 1])
				return m;
		} else if (A[m - 1] <= A[m] && A[m] >= A[m + 1]) {
			return m;
		} else if (A[m - 1] > A[m]) {
			return algorithm3(A, i, m - 1);
		} else if (A[m] < A[m + 1]) {
			return algorithm3(A, m + 1, j);
		}

		return 0;
	}

}
