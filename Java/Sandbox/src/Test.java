
public class Test {

	public static void main(String[] args) {
		int n = 50;
		System.out.println(Rekur(n));
		System.out.println(RekurIter(n));
		System.out.println(RekurMine(n));
	}
	
	static int Rekur(int n){
		if(n<= 0)
			return n;
		
		return n + Rekur(n-1) + 2;
	}
	
	static int RekurIter(int n){
		int x = 0, i = 1;
		while(i <= n){
			x += 2+i;
			i+=1;
			
		}
		return x;
	}
	
	static int RekurMine(int n){
		int result = 0;
		while(n > 0){
			result += n + 2;
			n -= 1;
		}
		return result;
	}
}
