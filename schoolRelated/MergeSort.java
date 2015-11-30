import java.util.Arrays;


public class MergeSort {

	public static int[] merge(int [] array, int beginOne, int endOne, int beginTwo, int endTwo)
	{
		int[] secondArray = Arrays.copyOf(array, array.length);
		
		int i = beginOne;
		int j = beginTwo;
		
		int index = beginOne;
		
		while (i <= endOne && j <= endTwo)
		{
			if (array[i] <  array[j])
			{
				secondArray[index] = array[i];
				i++;
			}
			
			else
			{
				secondArray[index] = array[j];
				j++;
			}
			
			index++;
		}
		
		while (index <= endTwo ){
		secondArray[index] = (i <= endOne? array[i++]: array[j++]);
		index++;
		}
		
		return secondArray;
	}
	
	
	public static void sort(int[] array, int start, int end)
	{
		if (start < end)
		{
			int mid = (start + end)/2;
			sort(array, start, mid);
			sort(array, mid + 1, end);
			int[] secondArray = merge(array, start, mid, mid+1, end);
			for (int i = 0; i < array.length; i++)
			{
				array[i] = secondArray[i];
			}
		}
		
		return;
	}
	
	public static void main (String[]args)
	{
		int[] array = new int[] {1,2,5,23,1,2,55,66,74,63,23,4,5};
		MergeSort.sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
}
