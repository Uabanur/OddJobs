
public class Factors {
	
	public static void main(String[] args){
		factors(127);
		
		
	}
	
	private static void factors(int n){
		System.out.println("Factors of " + n + " are:");
		for(int i = 1; i <= n; i++){
			if(n%i == 0){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

}
