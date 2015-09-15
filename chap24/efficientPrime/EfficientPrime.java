package efficientPrime;

public class EfficientPrime {

	
	public static boolean isPrime(int number)
	{
		
		if (number == 1)
		{
			return true;
		}
		
		for (int i = 2; i <= (int) Math.sqrt(number); i++)
		{
			if(isPrime(i))
			{
				if (number % i == 0)
				{
					System.out.println(i);
					return false;		
				}
			}
		
		
		}
		
		return true;

	}
	
	public static void main (String[]args)
	{
		System.out.println(EfficientPrime.isPrime(12));
	}
	
}
