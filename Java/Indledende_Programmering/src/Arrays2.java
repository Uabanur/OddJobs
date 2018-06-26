
public class Arrays2 {

	
	public static int countInRange(int[] a, int min, int max){
		int counter = 0;
		
		for(int i = 0; i < a.length; i++){
			if(a[i] <= max && a[i] >= min)
				counter++;
		}
		
		return counter;
	}
	
}
