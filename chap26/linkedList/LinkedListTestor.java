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
		MyLinkedList_Practice_9_6 <String> list = new MyLinkedList_Practice_9_6 <> ();
		list.add("1");
		list.add("Aaha");
		list.add("Aah");
		list.add("Aahan");
		list.add("Aaha");
		list.add(0, "First");
		list.add(2, "Before Aaha");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
	}
}
