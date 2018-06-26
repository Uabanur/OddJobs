package functionPlotter;

public class SineFunction extends Function{
	
	private double a, b;
	
	public SineFunction(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public double evaluate(double x) {
		
		return a * Math.sin(b*x);
	}

}
