
public class Ackermann {
	
	static long evaluations = 0;
	
	public static void main(String[] args) {
		System.out.println(ack(4, 1));
		System.out.println(evaluations);
	}

	
	public static long ack(long m, long n){
		evaluations++;
//		System.out.println("m:" + m + "  n: " + n);
		
		if(m == 0) return n+1;
		
		if(m > 0 && n == 0) return ack(m-1, 1);
		
		else return ack(m-1, ack(m, n-1));
		
	}
}
	