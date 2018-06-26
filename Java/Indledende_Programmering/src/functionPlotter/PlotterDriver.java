package functionPlotter;

public class PlotterDriver {
	
	public static void main(String[] args) {
		
		Function f1 = new SineFunction(0.8, 2.1);
		Function f2 = new PowerFunction(2.1, 2.0);
		Function f3 = new ExponentialFunction(3.2, 1.3);
		
		double[] f4a = {-3.1, 4.1, -2.1, 0.4};
		
		Function f4 = new PolynomialFunction(f4a);

		double[] f5a = new double[20];
		f5a[1] = 1.0;
		f5a[3] = -0.1666666667;
		f5a[5] = 0.008333333333;
		f5a[7] = -0.0001984126984;
		f5a[9] = 0.000002755731922;
		f5a[11] = -0.00000002505210839;
		f5a[13] = 0.0000000001605904384;
		f5a[15] = -7.647163732e-13;
		f5a[17] = 2.811457254e-15;
		f5a[19] = -8.220635247e-18;

		Function f5 = new PolynomialFunction(f5a);
		
		Function[] f6f = {f1, f2, f3, f4, f5};
		Function f6 = new SumFunction(f6f);
		
		Function[] f7f = {f4, f1, f3, f5, f2};
		Function[] test = {f6, f6};
		
		Function f7 = new FunctionComposition(f7f);


		FunctionPlotter fup = new FunctionPlotter();
		fup.plotGraph(f7, -2, 2, 500);
		
	}

}
