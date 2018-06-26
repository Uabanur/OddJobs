
public class IndexHex {

	public static void main(String[] args) {
		
		
		int start = 15*16+10;
		
		for(int i = start+1; i < 400; i++){
			String hexCounter = Integer.toString(i,16);
			System.out.println(hexCounter.toUpperCase() +  " ");
			
		}
		
	}
	
}
