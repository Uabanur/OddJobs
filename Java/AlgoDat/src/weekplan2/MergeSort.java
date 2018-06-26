package weekplan2;
import java.io.*;
import java.util.*;

public class MergeSort
{
	// This method takes an array of integers as input parameter,
	// and it should then return the integers sorted
	// in ascending order using the MergeSort algorithm.
	private int[] sort(int[] numbers) {

		return mergeSort(numbers, 0, numbers.length-1);
	}
	
	private int[] mergeSort(int[] numbers, int i, int j){
		
		if(i<j){
			int m = (i+j)/2;
			numbers = mergeSort(numbers, i, m);
			numbers = mergeSort(numbers, m+1, j);
			numbers = merge(numbers, i, m, j);
		}
		
		return numbers;
	}

	private int[] merge(int[] numbers, int i, int m, int j){
		int first = i, second = m+1;
		int[] result = numbers.clone();

		for(int inc = i; inc <= j; inc++){
			
			if(first > m){
				result[inc] = numbers[second];
				second++;
			} else if(second > j){
				result[inc] = numbers[first];
				first++;
			} else if(numbers[first] < numbers[second]){
				result[inc] = numbers[first];
				first++;
			} else {
				result[inc] = numbers[second];
				second++;
			}
			
		}
		
		
		return result;
	}
	
	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################


	public static void main(String[] args) throws IOException {
		new MergeSort().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = readIntArray(in);
		
		numbers = sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
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