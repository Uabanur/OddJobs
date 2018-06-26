
public class PlasticBottle extends Bottle{
	
	private String material;

	public PlasticBottle(int volume, String content, String material) {
		super(volume, content);
		if(material.equalsIgnoreCase("PET"))
			this.material = material;
		else 
			this.material = "OTHER";
	}
	
	public String toString(){
		return "This "+material+" bottle has a volume of "+volume+" and contains "+content;
	}

	
}
