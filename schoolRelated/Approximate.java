import java.util.Arrays;


public class Approximate {

	public static void main (String[]args)
	{
		System.out.println(Arrays.toString(Approximate.approximate(5, 1)));
	}
	public static float[] approximate(float a, float b)
	{
		for (int i = 0; i < 4; i++)
		{
			float dX = a*b - 3;
			float dY = b*b - 10;
			
			a += dX*0.01;
			b += dY*0.01;
		}
		
		return new float[]{a,b};
	}
}
