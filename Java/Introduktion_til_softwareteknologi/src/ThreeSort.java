
public class ThreeSort {
	
	public static void main(String[] args) {
		
		
		int min = findMin(args[0], args[1], args[2]);
		int max = fintMax(args[0], args[1], args[2]);
		
		System.out.println(min + " " + getMid(min, args[0], args[1], args[2], max) + " " + max );
		
	}

	private static int getMid(int min, String arg1, String arg2, String arg3, int max) {
		
		return (Integer.parseInt(arg1) + Integer.parseInt(arg2) + Integer.parseInt(arg3)) - min - max ;
	}

	private static int fintMax(String arg1, String arg2, String arg3) {
		
		return Math.max(Math.max(Integer.parseInt(arg1), Integer.parseInt(arg2)), 
				Math.max(Integer.parseInt(arg2), Integer.parseInt(arg3)));
	}

	private static int findMin(String arg1, String arg2, String arg3) {
		
		
		return Math.min(Math.min(Integer.parseInt(arg1), Integer.parseInt(arg2)), 
				Math.min(Integer.parseInt(arg2), Integer.parseInt(arg3)));	
	}
	
}
