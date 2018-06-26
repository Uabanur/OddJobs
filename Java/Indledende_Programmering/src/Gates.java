
public class Gates {
	
	
	public static void main(String[] args) {
		System.out.println(NOT(true));AND(true, true);
	}
	public static boolean AND(boolean p, boolean q){
		
		return p&&q;
	}
	
	public static boolean OR(boolean p, boolean q){
			
		return p||q;
	}
	
	public static boolean NAND(boolean p, boolean q){
		
		return !(p&&q);
	}
	
	public static boolean EXOR(boolean p, boolean q){
		
		return (p||q) && !(p&&q);
	}
	
	public static boolean NOT(boolean p){
		
		return !p;
	}
}
