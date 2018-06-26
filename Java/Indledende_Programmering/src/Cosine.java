
public class Cosine {
	
	
	public static double cosine(double x, int k){
		double result = 0;
		
		for(int i = 0; i <= k ; i++){
			
			result += (Math.pow(-1,i)*Math.pow(x, 2*i))/factorial(2*i);

		}
		
		return result;
		
	}
	
	public static int factorial(int n){

		if(n == 0)
			return 1;
		else
			return n*factorial(n-1);
		
	}

}
