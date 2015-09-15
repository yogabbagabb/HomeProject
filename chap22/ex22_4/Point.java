package ex22_4;

import java.util.Arrays;
import java.util.Comparator;

public class Point implements Comparable<Point> {

	protected int x;
	protected int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int compareTo(Point o)
	{
		if (this.x - o.x!= 0)
			return this.x -o.x;
		else
			return this.y - o.y;
		
	}
	
	public String toString()
	{
		return ("(" + x  + "," + y + ")  ");
	}
	
	public static void sortPoints(Point[] point, Comparator<Point> comparator)
	{
		Arrays.sort(point);
		System.out.println(Arrays.toString(point));

		
		Arrays.sort(point,comparator);
		System.out.println(Arrays.toString(point));
	}
	
	public static void main (String[]args)
	{
		
		Point[] array = new Point[100];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = new Point ((int)(Math.random() * 10), (int)(Math.random() * 10) );
		}
		
		CompareY comparator = new CompareY ();
		Point.sortPoints(array, comparator);
	}

}


class CompareY implements Comparator<Point>
{

	@Override
	public int compare(Point o1, Point o2) {
		
		int y = o1.y - o2.y;
		
		if (y != 0)
		{
			return y;
		}
		
		else
		{
			return o1.x - o2.x;
		}
	}	
}

	