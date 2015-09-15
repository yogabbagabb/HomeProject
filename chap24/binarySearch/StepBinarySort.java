package binarySearch;

public class StepBinarySort {

	int[] array;
	int start, mid, last, key;
	boolean finalStep, found;

	public StepBinarySort(int[] arr, int key)
	{
		
		finalStep = false;
		found = false;
		
		array = arr;
	    start = 0;
	    this.key = key;
	    last = array.length - 1;
	    mid = (start + last)/2;
	}
	
	public boolean step()
	{
		if (array[mid] == key)
		{
			finalStep = true;
			return true;
		}
		else if(array[mid] > key)
		{
			last = mid;
			mid = (start + last)/2;
			return false;
		}
		else if(array[mid] < key)
		{
			start = mid;
			mid = (start + last)/2;
			return false;
		}
		else if (start == mid)
		{
			finalStep = true;
			return true;
		}
		
		return false;
	}
	
	public boolean finalStep()
	{
		if(array[mid] == key)
		{
			found = true;
			return true;
		}
		else if (array[mid+1] == key)
		{
			found = true;
			mid = mid + 1;
			return true;
		}
		else
		{
			found = false;
			mid = -(mid + 1);
			return false;
		}
	}
	
	public boolean getFinalStep()
	{
		return finalStep;
	}
	
	public boolean getFound()
	{
		return found;
	}
	
	public int[] getEnds()
	{
		return new int []{start,last};
	}
	
	public int getMid()
	{
		return mid;
	}
	
	public int[] getArray()
	{
		int[] clone = array.clone();
		return clone;
	}
	
	
}
