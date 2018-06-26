package Assignment1;

public class NumberCheck {
	

	
	
	public static boolean check(String number){
		
		int[] array = new int[number.length()];
		int sum = 0;
		
		//Convert all characters from the string, to the corresponding integer in the new array 
		//Index counts from the end of the array
		
		for(int i = number.length()-1; i >=0; i--){
			
			if(-(i-number.length()-1) % 2 == 1){
				
				if(Character.getNumericValue(number.charAt(i))*2 < 10)
					array[i] = 2*Character.getNumericValue(number.charAt(i));
				else
					array[i] = (2*Character.getNumericValue(number.charAt(i)))%10 + 1;
			} else 
				array[i] = Character.getNumericValue(number.charAt(i));
		}
		
		//Calculate sum of array elements
		for(int i = 0; i < array.length; i++ ){
			sum += array[i];
			//System.out.print(array[i] + " ");
		}
		//System.out.println();
		//System.out.println(sum);

		//Determine the output from mod 10;
		if(sum % 10 == 0)
			return true;
		else 
			return false;
	}
	
	

	
	
}
