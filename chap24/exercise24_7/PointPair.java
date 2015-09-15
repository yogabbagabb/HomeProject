package exercise24_7;

public class PointPair 
{
	
	Point pointOne;
	Point pointTwo;
	boolean samePoint;
	
	public PointPair(Point a, Point b)
	{
		pointOne = a;
		pointTwo = b;
		samePoint = false;
	}
	
	public PointPair(Point a, Point b, boolean samePoint)
	{
		pointOne = a;
		pointTwo = b;
		this.samePoint = samePoint;
	}
	
	public void setUnique(boolean state)
	{
		samePoint = !state;
	}
	public double getDistance()
	{
		return pointOne.findDistance(pointTwo);
	}
	
	public static PointPair findMin(PointPair[] array)
	{
		java.util.List <PointPair> distinct = new java.util.ArrayList <> ();
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getUnique() == true)
			{
				distinct.add(array[i]);
			}
		}
		
		if (distinct.size() > 0)
		{
			PointPair min = distinct.get(0);
			
			for (int i = 1; i < distinct.size(); i++)
			{
				if (distinct.get(i).getDistance() < min.getDistance())
				{
					min = distinct.get(i);
				}
			}
			
			return min;
		}
		
		else
		{
			return array[0];
		}
	}
	
	public boolean getUnique()
	{
		return !samePoint;
	}
	
	public String toString()
	{
		return pointOne.toString() + " " + pointTwo.toString() + 
				 "| Apart by: " + this.getDistance();
	}
	
	

	
}
