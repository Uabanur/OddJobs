import java.util.ArrayList;

public class ArrayListX {

	public static void append(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for(int elements: list2){
			list1.add(elements);
		}
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int maxLength = Math.max(list1.size(), list2.size());
		
		for(int i = 0; i < maxLength; i++){
			if(i < list1.size())
				res.add(list1.get(i));
			
			if(i < list2.size())
				res.add(list2.get(i));
		}
		
		return res;	
	}
	
	public static void printList(ArrayList<Integer> list, String name) {
		System.out.println("------------------------\n"+name+":\n");
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
	}	
}
