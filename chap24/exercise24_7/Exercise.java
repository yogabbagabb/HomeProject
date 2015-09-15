package exercise24_7;

public class Exercise {
	
	
	public static PointPair findLeast(Point[] arrayOne, Point[] arrayTwo)
	{
		
		PointPair d1 = null, d2 = null, d3 = null;
		PointPair min = null;
		boolean d1Set = false, d2Set = false;
	
		if (arrayOne.length <= 2)
		{
			if (arrayOne.length == 1)
			{
				d1 =  new PointPair(arrayOne[0],arrayOne[0]);
				d1.setUnique(false);
			}
			else
			{
				d1 = new PointPair(arrayOne[0],arrayOne[1]);
			}
			
			d1Set = true;
		}
		
		if (arrayTwo.length <= 2)
		{
			if (arrayTwo.length == 1)
			{
				d2 = new PointPair(arrayTwo[0],arrayTwo[0]);
				d2.setUnique(false);
			}
			
			else
			{
				d2 = new PointPair(arrayTwo[0],arrayTwo[1]);
			}	
			
			d2Set = true;
		}
		
		
		
		if (!d1Set)
		{
			Point[][] array = Exercise.helpSplit(arrayOne);
			d1 = findLeast(array[0],array[1]);
		}
		
		
		
		
		if (!d2Set)
		{
			Point[][] array = Exercise.helpSplit(arrayTwo);
			d2 = findLeast(array[0],array[1]);
		}		
		
		d3 = new PointPair(arrayOne[0],arrayTwo[0]);
		
		for (int i = 0; i < arrayOne.length; i++){
			for (int j = 0; j < arrayTwo.length; j++)
			{
				if (arrayOne[i].findDistance(arrayTwo[j]) < d3.getDistance())
				{
					d3 = new PointPair (arrayOne[i], arrayTwo[j]); 
				}
			}
		}
		
		
		PointPair[] array = new PointPair[] {d1,d2,d3};
		return PointPair.findMin(array);
	}
	
	public static Point[][] helpSplit(Point [] array)
	{

		Point[] anotherArrayOne = new Point[array.length/2];
		Point[] anotherArrayTwo = new Point[array.length - array.length/2];
		int m = 0;
		
		for (int i = 0; i < anotherArrayOne.length; i++)
		{
			anotherArrayOne[i] = array[m];
			m++;
		}
		
		for (int i = 0; i < anotherArrayTwo.length; i++)
		{
			anotherArrayTwo[i] = array[m];
			m++;
		}
		
		Point[][] container = new Point[][] {anotherArrayOne, anotherArrayTwo};
		return container;
		
	}
	
	public static void main (String[]args)
	{
		Point[] array = new Point [102];
		
		for (int i = 0; i < 100; i++)
		{
			array[i] = new Point(Math.random() * 100, Math.random() * 100);
		}
	
		array[100] = new Point (23,23);
		array[101] = new Point (23.05,23.23);
		
		
		Point[][] secondArray = Exercise.helpSplit(array);
		System.out.println(Exercise.findLeast(secondArray[0], secondArray[1]));
		
	}

}
