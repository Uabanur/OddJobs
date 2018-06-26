import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> list;

	public Stack() {
		list = new ArrayList<T>();
	}

	public void push(T e) {
		list.add(e);
	}

	public T pop() {
		if (list.size() == 0)
			return null;
		else {
			T tmp = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return tmp;
		}
	}

	public boolean empty() {
		return list.size() == 0;
	}
}
