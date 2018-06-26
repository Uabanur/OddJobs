package weekplan0;

public class Exercise0 {

	public static void main(String[] args) {
		int n = 4;
		int[] A = {1, 2, 3, 4, 5};
		System.out.println(f(A, A.length));
		System.out.println(1+2+3+4+5);
	}

	static int loop1(int n) {
		int x = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				x++;
		}
		return x;
	}

	static int loop2(int n) {
		int x = 0;
		for (int i = 0; i < n; i++)
			x++;
		for (int j = 0; j < n; j++)
			x++;
		return x;
	}

	static int loop3(int n) {
		int x = 0;
		for (int i = 0; i < n; i++) {
			if (i == n - 1)
				for (int j = 0; j < n; j++)
					x++;
		}
		return x;
	}

	static int loop4(int n) {
		int x = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++)
				x++;
		}
		return x;
	}

	static int f(int[] A, int n) {
		if (n == 0)
			return 0;
		else
			return f(A, n - 1) + A[n - 1];
	}
}
