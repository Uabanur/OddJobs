
public class EnumTester {

	enum test{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}
	
	public static void main(String[] args) {
		
		
		test tester;
		
		tester = test.TUESDAY;
		
		switch(tester){
		case MONDAY: System.out.println("monday"); break;
		case TUESDAY: System.out.println("tuesday"); break;
		case WEDNESDAY: System.out.println("wednesday"); break;
		case THURSDAY: System.out.println("thursday"); break;
		case FRIDAY: System.out.println("friday"); break;
		case SUNDAY: System.out.println("sunday"); break;
		case SATURDAY: System.out.println("saturday"); break;
		default: System.out.println("N/A"); break;
		}
			
	}
	
}
