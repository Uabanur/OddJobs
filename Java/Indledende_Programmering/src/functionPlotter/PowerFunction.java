package functionPlotter;

public class PowerFunction extends Function {

	private double a, b;
	
	public PowerFunction(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public double evaluate(double x) {
		
		return b*Math.pow(Math.abs(x),a);
	}

}
