package functionPlotter;

public class SumFunction extends Function {

	private Function[] f;
	
	public SumFunction(Function[] f){
		this.f = f;
	}
	
	
	public double evaluate(double x) {
		
		double sum = 0;
		
		for(int i = 0; i < f.length; i++){
			sum += f[i].evaluate(x);
		}
		
		return sum;
	}
}
