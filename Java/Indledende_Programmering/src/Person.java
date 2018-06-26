
public class Person {
	private String firstName, lastName;
	private static int counter = 1;
	private final int id = counter;
	

	public Person(String firstName, String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		counter++;
	}
	
	
	
	public String toString(){
		
		String s= id + ": " + firstName + " " + lastName;
		return s;
	}
	
}
