import java.util.Arrays;


public class MedianOf5 {
	
	public static void main(String[] args) {
		
		int[] array = new int[args.length];
		for(int i = 0; i < args.length; i++){
			array[i] = Integer.parseInt(args[i]);
		}
		
		Arrays.sort(array);
		System.out.println(array[(int) array.length/2]);	
	}
}

