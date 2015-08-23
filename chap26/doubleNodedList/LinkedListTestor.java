package doubleNodedList;

public class LinkedListTestor<E> 
{

	
	public static <E> void printLink(MyLinkedList <E> obj)
	{
		Node<E> Last = obj.getHeadNode();
		Node<E> last = obj.getLastNode();
		
		while (Last != last.next)
		{
			System.out.println(Last.element);
			Last = Last.next;
		}
	}
	
	public static void main (String[]args)
	{
		MyLinkedList<String> list = new MyLinkedList <> ();
		list.addLast("1");
		list.addLast("Aaha");
		list.addLast("Aah");
		list.addLast("Aahan");
		list.addLast("Aaha");
		list.add(1, "2");
		System.out.println();
		LinkedListTestor.printLink(list);
		
	}
}
