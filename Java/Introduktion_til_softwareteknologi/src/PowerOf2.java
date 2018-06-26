
public class PowerOf2 {
	
	public static void main(String[] args) {
		int i = 1;
		while(true){
			
			if(Math.pow(2, i) <= Long.parseLong(args[0])){
				System.out.println((int) Math.pow(2, i));
			} else {
				break;
			}
			
			i++;
		}
	}

}
