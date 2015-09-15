package insertionSort;

import java.util.Arrays;
import java.util.List;

public class Sort  {
	
	private static <E extends Comparable<E>> void insertionSort(E[] list)
	{
		
		for (int i = 1; i <list.length; i++)
		{
			E inQ = list[i];
			
			for (int j = i - 1; j >= 0; j--)
			{
				if (inQ.compareTo(list[j]) < 0)
				{
					list[j + 1] = list[j];
					list[j] = inQ;
				}
				
				else
				{
					inner: break;
				}
			}
			
		}
		
		
		}
	
	public static void main (String[]args)
	{
		String[] list = new String [] {"Hello", "Bye", "Sigh"};
		Sort.insertionSort(list);
		System.out.println(Arrays.toString(list));
		
		
	}
	
	

}
