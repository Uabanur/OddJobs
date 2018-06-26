
public class PascalsTriangle {
	
	public static void main(String[] args){
		int levels;
		if(args.length > 0)
			levels = Integer.parseInt(args[0]);
		else
			levels = 11;
	 	
		int[][] elements = createTriangle(levels);
		print(elements);

	}
	
	private static int[][] createTriangle(int levels){
		int[][] elements = new int[levels][];
		for(int i = 0; i < levels; i++){
			elements[i] = new int[i+1];
			elements[i][0] = 1;
			elements[i][i] = 1;
			
			for(int j = 1; j < elements[i].length-1; j++){
				elements[i][j] = elements[i-1][j-1]+elements[i-1][j];
			}
			
		}
		return elements;
	}
	
	private static void print(int[][] elements){
		
		for(int j = 0; j < elements.length; j++){
			for(int i = elements.length - j; i >= 0; i--){
				System.out.print("  ");
			}
			
			for(int i = 0; i < elements[j].length; i++){
				System.out.printf("%4d",elements[j][i]);
			}
			
			System.out.println();
		}
		
	}

}
