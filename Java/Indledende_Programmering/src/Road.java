public class Road {

	private double width, length;
	private String name, surface;

	public Road(double length, double width, String name, String surface) {
		this.length = length;
		this.width = width;
		this.name = name;
		this.surface = surface;

		if (width < 1.0 || !checkSurface(surface)) {
			this.name = "ILLEGAL";
		}
		
		if(this.name.equals("ILLEGAL")){
			this.width = 0;
			this.length = 0;
			this.surface = "";
		}
		
	}

	private boolean checkSurface(String surface) {

		return surface.equals("asphalt") || surface.equals("concrete") || 
				surface.equals("gravel") || surface.equals("dirt");
	}

	public String toString(){
		String s = "Road " + name + " l=" + String.format("%.2f",length) + 
				" w=" + String.format("%.2f", width) + " surface=" + surface; 
		return s;
	}
	
	// GETTERS AND SETTERS
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		System.out.println("No, this is not allowed.");
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width < 1)
			System.out.println("No, this is not allowed.");
		else
			this.width = width;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		if(!checkSurface(surface))
			System.out.println("No, this is not allowed.");
		else
			this.surface = surface;
	}

}
