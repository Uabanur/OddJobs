
public class Triag {

	public static int computeIndex(int n){
		
		int i = 0;
		int ti = 0;

		while(ti < n){
			ti += ++i;
		}
		
		return i;
	}
	
}
