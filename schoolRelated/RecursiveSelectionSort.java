import java.util.Arrays;


public class RecursiveSelectionSort {
	
	public static void sort(int from, int [] array)
	{
		if (from == array.length - 1)
			return;
		RecursiveSelectionSort.swap(array, from, RecursiveSelectionSort.findMin(from, array));
		RecursiveSelectionSort.sort(from + 1, array);
	}

	public static int findMin(int from, int[] array)
	{
		if (from == array.length-1)
			return from;
		
		int first = array[from];
		int possibleIndex = RecursiveSelectionSort.findMin(from + 1, array);
		int second = array[possibleIndex];		
		if (first < second)
			return from;
		else 
			return possibleIndex;
	}
	
	public static void swap(int[] array, int indexOne, int indexTwo)
	{
		int med = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = med;
	}
	
	public static void main (String[]args)
	{
		int[] array = new int[] {1,4,5,2,8,99};
		RecursiveSelectionSort.sort(0, array);
		System.out.println(Arrays.toString(array));
	}
}
