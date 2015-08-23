package linkedList;

import java.util.Iterator;

public class LinkedListTestor<E> 
{

	
	public static <E> void printLink(MyLinkedList <E> obj)
	{
		Node<E> first = obj.getHeadNode();
		Node<E> last = obj.getLastNode();
		
		while (first != last.next)
		{
			System.out.println(first.element);
			first = first.next;
		}
	}
	
	public static void main (String[]args)
	{
		MyLinkedList<String> list = new MyLinkedList <> ();
		list.addFirst("1");
		list.addFirst("Aaha");
		list.addFirst("Aah");
		list.addFirst("Aahan");
		list.addFirst("Aaha");		
		
		Iterator<String> it = list.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
	}
}
