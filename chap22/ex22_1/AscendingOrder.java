package ex22_1;
import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AscendingOrder {
	
	public static void main (String[]args)
	{
		String fileName = args[0];
		File file = new File (fileName);
		
		java.util.Comparator<String> instance = new java.util.Comparator <String> () 
		{

			@Override
			public int compare(String o1, String o2)
			{
				
				return o1.compareTo(o2);
				
			}
		
		
		};
		
		PriorityQueue <String >queue = new PriorityQueue <> (11, instance);
		Scanner scan = null;
		
		try
		{
			java.io.FileReader reader = new java.io.FileReader (file);
			scan = new Scanner(reader);
		}
		
		catch(java.io.IOException e)
		{
			e.printStackTrace();
		}
		
		while (scan.hasNext())
		{
			queue.add(scan.next());
		}
		
		while(queue.size() != 0)
		{
			System.out.println(queue.poll());
		}
	}
	

}
