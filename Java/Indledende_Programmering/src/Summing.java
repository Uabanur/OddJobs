
public class Summing {
	public static void main(String[] args) {
		summit();
	}
	
	public static void summit(){
		int sum = 0;
		for(int i = 1; i <=200; i++){
			if(i%7==0)
				sum+=i;
		}
		System.out.println(sum);
		
	}
}
