package heap;

public class LinkedListTestor<E> 
{

	
	public static <E> void printLink(MyLinkedList <E> obj)
	{
		Node<E> Last = obj.getHeadNode();
		Node<E> last = obj.getLastNode();
		int i = 0;
		while (i < obj.size() )
		{
			System.out.println(Last.element);
			Last = Last.next;
			i++;
		}
		System.out.println("Done");
	}
	
	public static void main (String[]args)
	{
		Integer[] array = new Integer [100];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		
		Heap<Integer> h = new Heap <> (array);
//		for (int i = 0 ; i < 10; i++)
//		{
//			h.add((int)(i * Math.random() * 5));
//		}
//		LinkedListTestor.printLink(h.getList());
//		
		
		for (int i = 0 ; i < array.length; i++)
		{
			int j = 0;
			System.out.println(h.remove(j));
//			LinkedListTestor.printLink(h.getList());
//			System.out.println("_________ INDEX :" + j);
		}
		
		
//		MyLinkedList <String> list = new MyLinkedList <> ();
//		list.add("One");
//		list.add("Two");
//		list.add("Three");
//		list.add("Four");
//		list.removeLast();
//		list.removeFirst();
				
	}


}
