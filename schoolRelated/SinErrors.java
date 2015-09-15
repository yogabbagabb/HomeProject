
public class SinErrors {

	public static void main (String[]args)
	{
		for (double i = 0.0; i < Math.PI * 2 ; i += 0.001)
		{
			if (Math.abs(Math.abs((Math.cos(i) - (1-Math.pow(i,2.0)/2))/Math.cos(i)) - 0.01) < 0.0001)
			{
				System.out.println(i * 360 / (2*Math.PI)); 
			}
		}
	}
}
