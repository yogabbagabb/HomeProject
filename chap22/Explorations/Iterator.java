package Explorations;
import java.util.*;

public class Iterator {
	
	public static void main (String[]args)
	{
		Collection <String> list = new ArrayList <> ();
		list.add(Arrays.toString(new String [] {"Hello","Silly"}));
		
		java.util.Iterator <String> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		
		
 	}

}
