package binarySearch;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) 
	{
		int[] array = new int [20];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		
		BubbleSort.bubbleSort(array);
		System.out.println(Arrays.toString(array));

	}
	
	public static void bubbleSort(int[]array)
	{
		boolean changed = false;
		for (int i = 0; i < array.length -1; i++)
		{
			if (array[i+1] < array[i])
			{
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				changed = true;
			}
		}
		
		if (changed)
		{
			bubbleSort(array);
		}
	}

}
