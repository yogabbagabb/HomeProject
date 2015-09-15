package linkedList;

public class Node<E> {

	public E element;
	public Node<E> next;
	
	public Node (E e)
	{
			element = e;
			next = null;
	}

	public String toString()
	{
		return element.toString() + " ---> "
				+ next.toString();
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
