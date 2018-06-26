
public class OddPyramid {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++){
			slashes(5-i);
			for(int j = 0; j < i*2-1; j++)
			System.out.print(i*2-1);
			slashes(5-i);
			System.out.println();
		}
	}
	
	private static void slashes(int i){
		for(int j = 0; j < i+1; j++ )
		System.out.print("-");
	}
	
}
