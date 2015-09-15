package heap;

public class Node<E> {

	public E element;
	public Node<E> next;
	public Node<E> previous;
	
	public Node (E e)
	{
			element = e;
			previous = null;
			next = null;
	}

	public String toString()
	{
		return element.toString() + " ---> ";
	}
//	
//	public Node<E> getNext()
//	{
//		return next;
//	}
//	
//	public E getElement()
//	{
//		return element;
//	}
}
