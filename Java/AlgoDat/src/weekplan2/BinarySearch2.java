package weekplan2;
import java.io.*;
import java.util.*;

public class BinarySearch2
{
	// This method takes an array of integers as input parameters
	// and a value val. It should return the index of val in the array.
	// If val does not occur it should return -1.
	private int find(int[] numbers, int val) {
		
		return binaryIter(numbers, val, 0, numbers.length-1);
	}
	
	public static int binaryRec(int[] A, int request, int i, int j) {

		if (A.length < 1 || j < i)
			return -1;

		int m = (i + j) / 2;

		if (A[m] == request) {
			return m;
		} else if (A[m] > request) {
			return binaryRec(A, request, i, m - 1);
		} else {
			return binaryRec(A, request, m + 1, j);
		}
		
	}
	
	public static int binaryIter(int[] A, int request, int i, int j){
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

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

	public static void main(String[] args) throws IOException {
		new BinarySearch2().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = readIntArray(in);
		int[] queries = readIntArray(in);

		for (int i = 0; i < queries.length; i++) {
			int solution = find(numbers, queries[i]);
			System.out.println(solution);
		}
	}

	private int[] readIntArray(BufferedReader in) throws IOException {
		int length = Integer.parseInt(in.readLine());
		int[] array = new int[length];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		return array;
	}
}