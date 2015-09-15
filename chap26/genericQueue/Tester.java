package genericQueue;

public class Tester<E> 
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
		
		System.out.println("_____________________");
		GenericQueue<Integer> q = new GenericQueue<> (array);
		Tester.printLink(q);
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(q.deQueue());
		}
	}
}
