
public class Staircase {
	
	public static final int STAIRS = 5;
	public static final int standardSpace = 5;
	
	public static void main(String[] args) {
		
		String[] men= {"  O  ******", " /|\\ *     "," / \\ *     "};
		
		
		for(int i = 0; i < STAIRS; i++){
			
			spaces((STAIRS-i-1)*standardSpace);
			System.out.print(men[0]);

			spaces(i*standardSpace);
			System.out.println("*");
			
			spaces((STAIRS-i-1)*standardSpace);
			System.out.print(men[1]);
			spaces(i*standardSpace);
			System.out.println("*");
			
			spaces((STAIRS-i-1)*standardSpace);
			System.out.print(men[2]);
			spaces(i*standardSpace);
			System.out.println("*");
			
		}

		ending();
	}
	
	private static void ending(){
		for(int i = 0; i < STAIRS; i++){
			System.out.print("*****");
		}
		System.out.println("*******");
	}
	
	private static void spaces(int spaceCount){
		for(int i = 0; i < spaceCount; i++)
			System.out.print(" ");
	}
	
}
