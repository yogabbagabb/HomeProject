package revisedStack;

import java.util.Collection;

public class GenericStack<E> extends java.util.ArrayList<E> {
	
	
	private void printLastFive()
	{
		for (int i = this.size() - 1; i >= this.size() - 3; --i)
		{
			System.out.println(this.get(i));
		}
	}
	
	public static void main (String[]args)
	{
		GenericStack<String> list = new GenericStack <> ();
		list.add("Hello");
		list.add("Bye");
		list.add("Namaste");
		
		list.printLastFive();
		
		
	}
	

}