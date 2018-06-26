package weekplan4;

import java.io.*;
import java.util.*;

// TODO: Create a "Node" class

class Stack {
	
	int[] A = new int[1];
	int count = 0;
	
	public void push(int e) {
		if(count == A.length) increseArray();
		A[count] = e;
		count++;
	}

	public int pop() {
		count--;
		return A[count];
	}
	
	private void increseArray(){
		int[] newA = new int[A.length*2];
		for(int i = 0; i < A.length; i++)
			newA[i] = A[i];
		
		A = newA;
	}
	
}

public class StackDriver
{
	public static void main(String[] args) throws IOException {
		new StackDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		Stack stack = new Stack();

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String type = st.nextToken();

			if (type.equals("PU")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else {
				out.println(stack.pop());
			}
		}
		out.flush();
	}
}
