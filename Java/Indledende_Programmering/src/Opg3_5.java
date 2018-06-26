
public class Opg3_5 {

	
	public static void main(String[] args) {
		int balance = 1000;
		System.out.printf("\tCurrent balance \tInterest \tDeposit \tNew Balance\n\n");
		
		for(int i = 0; i < 25; i++){
			System.out.printf("Year: %d \t%d \t\t%d \t\t%d \t\t%d\n\n",i+1, balance, balance*=1.065, 100, balance+=100);
		}
	}
}
