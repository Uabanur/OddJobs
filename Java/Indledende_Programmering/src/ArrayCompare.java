import java.util.Arrays;


public class ArrayCompare {
	

	
	public static boolean equals(int[][] a, int[][] b){
		
		if(a.length != b.length){
			return false;
		} else {
			for(int i = 0; i<a.length; i++){
				if(a[i].length != b[i].length)
					return false;
			}
		}
		
		
		for(int i = 0; i < a.length; i++){
			if(!Arrays.equals(a[i], b[i]))
				return false;
		}
		
		return true;
	}

}
