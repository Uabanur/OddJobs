
public class OrderCheck {
	
	public static void main(String[] args) {
		
		if((number(args[0]) > number(args[1]) && 
			number(args[1]) > number(args[2])) || 
			(number(args[0]) < number(args[1]) && 
			number(args[1]) < number(args[2]))){
			System.out.println("true");
		} else{
		System.out.println("false");
		}
	}
	
	private static double number(String args){
		return Double.parseDouble(args);
	}

}
