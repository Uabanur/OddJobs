package functionPlotter;

public class ExponentialFunction extends Function {
	private double a, b;
	
	public ExponentialFunction(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public double evaluate(double x) {
		
		return a*Math.pow(Math.E,b*x);
	}

}
