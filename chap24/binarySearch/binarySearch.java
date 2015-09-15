package binarySearch;

import java.util.Arrays;

public class binarySearch {

	
	public static int binarySearch(int[] array, int key)
	{
		int start = 0;
		int last = array.length - 1;
		int mid = (start + last)/2;
		
		while (start != mid)
		{
			if (array[mid] == key)
				return mid;
			else if(array[mid] > key)
			{
				last = mid;
				mid = (start + last)/2;
			}
			else if(array[mid] < key)
			{
				start = mid;
				mid = (start + last)/2;
			}
		}
		
		if(array[mid] == key)
		{
			return mid;
		}
		if (array[mid+1] == key)
		{
			return mid+1;
		}
		else
			return -(mid + 1);
	}
	
	public static void main(String[]args)
	{
		int[] array = new int [20];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		
		BubbleSort.bubbleSort(array);
		System.out.println(Arrays.toString(array));

		
		for (int key: array)
		System.out.println(binarySearch.binarySearch(array, key));
	}
}
