
public class TheTwelveDaysofChristmas {

public static void main(String[] args) {
		
		String [] intro = {
				"first",
				"second",
				"third",
				"fourth",
				"fifth",
				"sixth",
				"seventh",
				"eighth",
				"nineth",
				"tenth",
				"eleventh",
				"twelfth"
		};
		
		String[] lines = {
				"a partridge in a pear tree",
				"two turtle doves",
				"three French hens",
				"four calling birds",
				"five gold rings",
				"six geese a-laying",
				"seven swans a-swimming",
				"eight maids a-milking",
				"nine ladies dancing",
				"ten lords a-leaping", 
				"eleven pipers piping",
				"twelve drummers drumming"
		};
		
		for(int i=0; i < intro.length; i++){
			System.out.println("On the " + intro[i] + " day of Christmas, ");
			System.out.println("my true love sent to me");
			
			for(int j = i; j >= 0; j--){
				System.out.print(lines[j]);
				if(j==0){
					System.out.print(".");
				} 
				if(j > 0){
					System.out.print(",");
				}
				if(i > 0 && j == 1){
					System.out.print(" and");
				}
				
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
}
