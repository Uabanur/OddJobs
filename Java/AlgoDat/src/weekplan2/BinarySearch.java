package weekplan2;

import java.util.Scanner;

public class BinarySearch {
	private static int[] A;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			System.out.println(binaryIter(sc.nextInt(), 0, N - 1));
		}

		sc.close();
	}

	public static int binaryRec(int request, int i, int j) {

		if (A.length < 1 || j < i)
			return -1;

		int m = (i + j) / 2;

		if (A[m] == request) {
			return m;
		} else if (A[m] > request) {
			return binaryRec(request, i, m - 1);
		} else {
			return binaryRec(request, m + 1, j);
		}
		
	}
	
	public static int binaryIter(int request, int i, int j){
		if (A.length < 1)
			return -1;
		
		while(true){
			if (j < i)
				return -1;
			
			int m = (i + j) / 2;
			
			if (A[m] == request) {
				return m;
			} else if (A[m] > request) {
				j = m-1;
			} else {
				i = m+1;
			}
			
			
		}
		
	}
	
}
