import java.util.Arrays;


public class Arrays3 {

	
	
	public static int modeX(int[] a){
		return mode(a);
	}
	
	public static int mode(int[] a){
		int counter = 0;
		int max = 0;
		int value = a[0];
		
		Arrays.sort(a);
		
		for(int i = 0; i < a.length-1; i++){
			
			if(a[i] == a[i+1]){
				counter++;
				if(counter > max){
					max = counter;
					value = a[i];
				}
			}else
				counter = 0;

		}
		return value;
	}
}


