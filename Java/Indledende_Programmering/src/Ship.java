
public class Ship {
	
	protected String name;
	protected int length;
	
	public Ship(String name, int length){
		this.name = name;
		this.length = length;
	}
	
	public String toString(){
		return "Ship "+name+" l="+length;
	}
	
}
