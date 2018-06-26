package weekplan5;

import java.io.*;
import java.util.*;

class MaxHeap {

	private int[] elements = new int[10001];
	private int size = 0;

	public void insert(int e) {
		size++;
		elements[size] = e;
		bubbleUp(size);
	}

	private void bubbleUp(int i) {
		if(i <= 1) return;
		
		if (elements[i] > elements[parent(i)]) {

			int tmp = elements[parent(i)];

			elements[parent(i)] = elements[i];
			elements[i] = tmp;

			bubbleUp(parent(i));
		}
	}

	public int extractMax() {
		if(size == 0) return 0;
		
		int max = elements[1];
		elements[1] = elements[size];
		size--;
		bubbleDown(1);
		return max;
	}

	private void bubbleDown(int i) {
		
		if(left(i) > size) return;
		
		int maxIndex;

		if(right(i) > size) 
			maxIndex = left(i);
		
		else if (elements[left(i)] > elements[right(i)])
			maxIndex = left(i);
		
		else
			maxIndex = right(i);
		
		if (elements[i] < elements[maxIndex]) {

			int tmp = elements[maxIndex];

			elements[maxIndex] = elements[i];
			elements[i] = tmp;

			bubbleDown(maxIndex);
		}
	}

	private int parent(int i) {
		return i / 2;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

	public void print(PrintWriter out) {
		for (int i = 1; i <= size; i++) {
			out.print(elements[i] + " ");
		}
		out.println();
	}
}

public class MaxHeapDriver {
	public static void main(String[] args) throws IOException {
		 new MaxHeapDriver().run();

	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		MaxHeap maxHeap = new MaxHeap();

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String type = st.nextToken();

			if (type.charAt(0) == 'I') {
				maxHeap.insert(Integer.parseInt(st.nextToken()));
			} else if (type.charAt(0) == 'E') {
				out.println(maxHeap.extractMax());
			} else {
				maxHeap.print(out);
			}
		}
		out.flush();
	}
}

