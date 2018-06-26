import java.util.Arrays;


public class BubbleSort {
	
	public static void main(String[] args) {
		sort2(new int[]{});
	}
	
	public static void sort(int[] a){
		int temp;
		if(a.length == 0)
			System.out.println("[]");
		
		for(int j = 0; j < a.length; j++){
			printArray(a);
			for(int i = 0; i < a.length-1; i++){
				
				if(a[i] > a[i+1]){
					temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
			}	
		}
	}
	
	public static void sort2(int[] a){
		boolean change = true;
		int temp;
		
		if(a.length == 0)
			System.out.println("[]");
		
		for(int j = 0; j < a.length; j++){
			change = false;
			printArray(a);
			
			for(int i = 0; i < a.length-1-j; i++){
				
				if(a[i] > a[i+1]){
					temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
					change = true;
				}
			}
			if(!change)
				break;
		}	
	}
	
	private static void printArray(int[] a){
		System.out.print("[" + a[0]);
		for(int i = 1; i < a.length; i++){
			System.out.print(", " + a[i]);
		}
		System.out.println("]");
		
	}
}
 