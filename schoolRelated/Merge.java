
public class Merge {
	
	
	public static void main (String[]args)
	{
		int[] array = Merge.merge(new int[] {1, 7, 12, 14, 23}, new int[] {2, 5, 7, 9, 9, 14, 24, 27, 30, 32});
		System.out.println(java.util.Arrays.toString(array));
		
		
	}

	static int[] merge(int [] arr1, int [] arr2)
	{
		int[] merged = new int[arr1.length + arr2.length];
		
		int oneIndex = 0, twoIndex = 0;
		
		while (oneIndex + twoIndex + 1 < arr1.length + arr2.length)
		{
			int first = 0;
			int second = 0;
			
			if (oneIndex < arr1.length)
				first = arr1[oneIndex];
			else
				first = arr2[twoIndex] + 1;
			

			if (twoIndex < arr2.length)
				second = arr2[twoIndex];
			else
				second = arr1[oneIndex] + 1;
			
			
			if (first < second)
			{
				merged[oneIndex + twoIndex] = first;
				oneIndex++;
			}
			else
			{
				merged[oneIndex + twoIndex] = second;
				twoIndex++;
			}
			
		}
		
		if (oneIndex < arr1.length || twoIndex < arr2.length)
		{	
			int smaller = (int)Math.min(oneIndex, twoIndex);
			
			if (twoIndex == 0 || twoIndex >= arr2.length)
				smaller = oneIndex;
			if (oneIndex == 0 || oneIndex >= arr1.length)
				smaller = twoIndex;
			
			if (smaller == oneIndex)
				merged[oneIndex + twoIndex] = arr1[smaller];
			else
				merged[oneIndex + twoIndex] = arr2[smaller];
		}
		
		return merged;
	}
}
