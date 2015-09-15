package exercise24_7;

import java.util.Arrays;

public class Scratch {
	
	public static void main (String[]args)
	{
		Point[] array = new Point [100];
		
		for (int i = 0; i < 100; i++)
		{
			array[i] = new Point(Math.random() * 100, Math.random() * 100);
		}
		
		Arrays.sort(array, new YComparator ());
		System.out.println(Arrays.toString(array));
		
	}

}
