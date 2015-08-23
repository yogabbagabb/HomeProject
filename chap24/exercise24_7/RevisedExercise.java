package exercise24_7;

import java.util.*;

public class RevisedExercise {
	
	
	public static void main (String[]args)
	{
			Point[] array = new Point [102];
			
			for (int i = 0; i < 100; i++)
			{
				array[i] = new Point(Math.random() * 100, Math.random() * 100);
			}
			
			array[100] = new Point (23,23);
			array[101] = new Point (23.05,23.56);
			
			
			RevisedExercise.sort(array);
			
			System.out.println(RevisedExercise.findMinimum(array));
	}
	
	
	/**
	 * Sorts the points on the basis of x coordinates first
	 * and, then, on the basis of y coordinates.
	 * @param array
	 */
	public static void sort(Point [] array)
	{
		Arrays.sort(array);
	}
	
	/**
	 * 
	 * @param array, the collection to be solved for
	 * @return PointPair, the pair of points closest together in the collection
	 */
	public static PointPair findMinimum(Point[] array)
	{
		
		if (array.length == 2)
		{
			return new PointPair(array[0],array[1]);
		}
		
		if (array.length == 1)
		{
			return new PointPair(array[0],array[0],true);
		}
		
		
		Point[][] container = RevisedExercise.helpSplit(array);
		PointPair first = RevisedExercise.findMinimum(container[0]);
		PointPair second = RevisedExercise.findMinimum(container[1]);
		
		PointPair minDistancePair = PointPair.findMin(new PointPair[]{first,second});
		double minDistance = minDistancePair.getDistance();
		Point midPoint = array[array.length/2];
		
		List <Point> leftHand = new ArrayList <> ();
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getX() < midPoint.getX() && midPoint.getX() - array[i].getX() < minDistance)
			{
				leftHand.add(array[i]);
			}
		}
		
		List <Point> rightHand = new ArrayList <> ();
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].getX() >= midPoint.getX() && array[i].getX() - midPoint.getX() < minDistance)
			{
				rightHand.add(array[i]);
			}
		}
		
		YComparator comparator = new YComparator ();
		
		
		Collections.sort(leftHand, comparator);
		Collections.sort(rightHand, comparator);
		
		int i = 0;
		for (Point point: leftHand)
		{
			while (i < rightHand.size() && rightHand.get(i).getY() <=  point.getY() - minDistance)
			{
				i++;
			}
			
			int j = i;
			
			while(j < rightHand.size() && Math.abs(rightHand.get(j).getY() - point.getY()) < minDistance)
			{
				if (rightHand.get(j).findDistance(point) < minDistance)
				{
					minDistance = rightHand.get(j).findDistance(point);
					minDistancePair = new PointPair(rightHand.get(j),point);
				}
				
				j += 1;
			}
			
			
			
		}

		
//		java.util.List <Point> boundedPoints = new java.util.ArrayList <> ();
//		
//		for (int i = 0; i < array.length; i++)
//		{
//			if (midPoint.withinRange(array[i], minDistance, minDistance))
//			{
//				boundedPoints.add(array[i]);
//			}	
//		}
//		
//		for (int i = 0; i < boundedPoints.size(); i++)
//		{
//			for (int j = i+1; j < boundedPoints.size(); j++)
//			{
//				if (boundedPoints.get(i).findDistance(boundedPoints.get(j)) < minDistance)
//				{
//					minDistancePair = new PointPair(boundedPoints.get(i),boundedPoints.get(j));
//					minDistance = minDistancePair.getDistance();
//				}
//			}
//		}
		
		return minDistancePair;
		
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
	
	

}
