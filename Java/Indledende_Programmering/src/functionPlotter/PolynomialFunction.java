package functionPlotter;

public class PolynomialFunction extends Function {

	private double[] a;
	
	public PolynomialFunction(double[] a){
		this.a = a;
	}
	
	public double evaluate(double x) {
		double sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i]*Math.pow(x, i);
		}
		return sum;
	}

}
