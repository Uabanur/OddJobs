
public class BinCoeff {


	
	
	public static int binomialSmart(int n, int k){
		
		int result = 1;
		int top[] = new int[n];
		int buttom[] = new int[n];
		
		for(int i = 0; i < n; i++){
			top[i]=i+1;
			if(i<k)
				buttom[i]=i+1;
			else
				buttom[i] = i-k+1;
			
			//System.out.println("top: " + top[i] + "\tButtom: " + buttom[i]);
			
			
			result = result*top[i]/buttom[i];
		}


		return result;
	}
	
	public static int binomial(int n, int k){
		
		return fac(n)/(fac(k)*fac(n-k));
		
	}
	
	public static int fac(int n){

		if(n == 0)
			return 1;
		else
			return n*fac(n-1);
		
	}
	
}
