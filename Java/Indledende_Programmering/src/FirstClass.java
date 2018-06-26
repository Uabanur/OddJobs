
public class FirstClass {
	private String name = "";
	private int id;
	
	public FirstClass(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public String toString(){
		
		String s= id + " - " + name;
		
		return s;
	}

}
