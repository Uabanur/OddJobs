
public class GradeConverter {
	
	
	public static int convert13to7(int grade){
		
		switch(grade){
			case 13: return 12;
			case 11: return 12;
			case 10: return 10;
			case 9: return 7;
			case 8: return 7;
			case 7: return 4;
			case 6: return 02;
			case 5: return 00;
			case 03: return 00;
			case 00: return -03;
		
		default: throw new IllegalArgumentException(Integer.toString(grade));
		
		}	
	}
}
