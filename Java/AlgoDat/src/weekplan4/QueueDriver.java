package weekplan4;

import java.io.*;
import java.util.*;

// TODO: Create a "Node" class to use for your queue

class Queue {
	
	int[] A = new int[1];
	int end = 0, start = 0;
	
	public void enqueue(int e) {
		if(end == A.length) increseArray();
		A[end] = e;
		end++;
	}

	public int dequeue() {
		start++;
		return A[start-1];
	}
	
	private void increseArray(){
		int[] newA = new int[A.length*2];
		for(int i = 0; i < A.length; i++)
			newA[i] = A[i];
		
		A = newA;
	}
	
}

// ##################################################
// # You do not need to modify anything below here. #
// ##################################################

public class QueueDriver
{
	public static void main(String[] args) throws IOException {
		new QueueDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		Queue queue = new Queue();

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String type = st.nextToken();

			if (type.charAt(0) == 'E') {
				queue.enqueue(Integer.parseInt(st.nextToken()));
			} else {
				out.println(queue.dequeue());
			}
		}
		out.flush();
	}
}