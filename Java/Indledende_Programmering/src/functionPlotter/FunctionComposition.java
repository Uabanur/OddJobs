package functionPlotter;

public class FunctionComposition extends Function {

	private Function[] f;
	
	public FunctionComposition(Function[] f){
		this.f = f;
	}
	
	public double evaluate(double x) {
		
		return value(x, 0);
	}
	
	private double value(double x, int i){
		
		if(i >= f.length){
			return x;
		} else {
			
			return f[i].evaluate(value(x, i+1));
		}
	}
}
 