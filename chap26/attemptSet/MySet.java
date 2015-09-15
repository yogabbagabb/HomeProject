package attemptSet;

public class MySet <E> {
	
	MyLinkedList <E> sequence;
	
	public MySet()
	{
		sequence = new MyLinkedList <> ();
	}
	
	public void add (E e)
	{
		if (!sequence.contains(e))
			sequence.add(e);
	}
	
	public E getLast(E e)
	{
		return sequence.getLast();
	}
	
	public E getFirst(E e)
	{
		return sequence.getFirst();
	}
	
	public E get(int i)
	{
		return sequence.get(i);
	}
	
//	public String toString() 
//	{
//		
//	}
//	
//	public boolean contains(E e)
//	{
//		
//	}
	
}
