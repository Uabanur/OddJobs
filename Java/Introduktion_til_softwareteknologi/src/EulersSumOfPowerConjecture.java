public class EulersSumOfPowerConjecture {

	public static void main(String[] args) {
		

		int startingNumber = 27, maxNumber = 133;
		long maxRange, minRange, startTime = System.currentTimeMillis();
		
		
		int x = (int) (long) Math.pow(1, 1);
		
		for (int a = startingNumber; a <= maxNumber; a++) {
//			System.out.println(a);

			for (int b = a; b <= maxNumber; b++) {
//				System.out.println("\t" + b);

				for (int c = b; c <= maxNumber; c++) {

					for (int d = c; d <= maxNumber; d++) {
						
						minRange = (long) (Math.pow(Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5), (float) 1 / 5) - 1);
						maxRange = (long) (Math.pow(Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5), (float) 1 / 5) + 1);
//						System.out.println(a + " " + b + " " + c + " " + d);
						
						for (long e = minRange; e <= maxRange; e++) {
//							System.out.println(e);
							if (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5) == Math.pow(e, 5)) {
								System.out.println(a + "^5 + " + b + "^5 + " + c + "^5 + " + d + "^5 = " + e + "^5\n");
								System.out.printf("Compilation time: %.1fs",(float)(System.currentTimeMillis() - startTime)/1000); 
								System.exit(1);
							}
						}
					}
				}
			}
		}
	}
}


// a^5 + b^5 + c^5 + d^5 = e^5









