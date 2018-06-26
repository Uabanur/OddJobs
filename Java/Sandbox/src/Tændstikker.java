
public class Tændstikker {
	
	public static void main(String[] args){
		
		int[] first = {6, 9, 5, 3, 2, 8}, 
				second1 = first, 
				second2 = {5, 2, 3, 4, 6, 8, 9}, 
				result1 = {2, 3, 4, 5, 6, 8, 9}, 
				result2 = {6, 9, 5, 3, 2, 8};
			
		
		int[] second = new int[second1.length * second2.length];
		int[] result = new int[result1.length * result2.length];
		int tick = 0, count = 0;
		
		for(int i = 0; i < second1.length; i++)
		{
			for(int j = 0; j < second2.length; j++)
			{
				second[tick] = second1[i] * 10 + second2[j];
				tick++;
			}
		}
		
		tick=0;
		
		for(int i = 0; i < result1.length; i++)
		{
			for(int j = 0; j < result2.length; j++)
			{
				result[tick] = result1[i] * 10 + result2[j];
				tick++;
			}
		}
		
		
		
		for(int i = 0; i < first.length; i++)
		{
			for(int j = 0; j < second.length; j++)
			{
				for(int k = 0; k < result.length; k++)
				{
					if(first[i] + second[j] == result[k])
					{
						count++;
						System.out.println(first[i] + " + " + second[j] + " = " + result[k]);
					}
				}
			}
		}
		System.out.println(first.length * second.length * result.length);
		System.out.println(count);
		
		
		
		
	}
	
	
}
