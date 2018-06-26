public class Bottle extends Vessel {

	protected String content;

	public Bottle(int volume, String content) {
		super(volume);
		this.content = content;
	}
	
	public String toString(){
		return "This bottle has a volume of "+volume+"  and contains " + content;
	}

}
