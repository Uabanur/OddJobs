package starter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Stack<T> {
	private ArrayList<T> list;
	private int currentSize;

	public Stack() {
		list = new ArrayList<T>();
		currentSize = list.size();
	}

	public void push(T e) {
		list.add(e);
		currentSize++;
	}

	public T pop() {
		if (list.size() == 0)
			return null;
		else {
			T tmp = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			currentSize--;
			return tmp;
		}
	}

	public boolean empty() {
		return list.size() == 0;
	}

	public void shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(list, new Random(seed));
	}

	public int getLength() {
		return list.size();
	}


}
