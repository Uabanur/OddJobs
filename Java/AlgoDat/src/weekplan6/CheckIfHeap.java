package weekplan6;

public class CheckIfHeap {

	public static void main(String[] args) {

		int[] A = new int[20];
		A[1] = 2000;
		for(int i = 1; i < A.length; i++){
			if(i*2 < A.length)
				A[i*2] = A[i] - 5;
			if(i*2+1 < A.length)
				A[i*2+1] = A[i] - 100;
		}
		
		
		int[] array = new int[A.length-1];
		for(int i = 0; i < array.length; i++)
			array[i] = A[i+1];
				
		for(int n: array)
			System.out.print(n + " ");
		System.out.println();
		
		if (M2(array))
			System.out.println("It is a heap");
		else
			System.out.println("It is NOT a heap");

	}

	public static boolean M2(int[] A) {
		int[] array = new int[A.length + 1];
		for (int i = 0; i < A.length; i++)
			array[i + 1] = A[i];
		return check(1, array);
	}

	private static boolean check(int i, int[] A) {

		if (i >= A.length)
			return true;

		if (A[i / 2] < A[i] && i != 1) {

			System.out.println("index " + i / 2 + " (" + A[i / 2] + ") and " + i + " (" + A[i] + ")");
			return false;
		} else if(i != 1)
			System.out.println(A[i/2] + " >= " + A[i]);

		return check(i * 2, A) && check(i * 2 + 1, A);

	}
}
