package heap;

public class Heap <E extends Comparable <E>> {
	
	MyLinkedList<E> list;
	
	public Heap()
	{
		list = new MyLinkedList <> ();
	}
	
	public Heap(E[]array)
	{
		list = new MyLinkedList <> ();
		for (E e: array)
		{
			list.add(e);
		}
	}

	public String toString()
	{
		int i = 0;
		String output = "";
		Node<E> node = list.getHeadNode();
		while (i < size())
		{
			output += node.toString();
			node = node.next;
			i++;
		}
		
		return output;
	}
	
	public void add(E e)
	{
		list.addLast(e);
		int i = size() - 1;
		sort(i);
		
	}
	
	public void sort(int i)
	{
		boolean swap = true;
		
		
		while (swap)
		{
			
			E bottom = list.get(i);
			E top = list.get(i/2);
			if (bottom.compareTo(top) > 0)
			{
				list.swap(i, i/2);
			}
			else
			{
				swap = false;
			}
			i = i/2;
		}
		
	}
	
	public E remove(int i)
	{
		E r = list.remove(i);
		for (int j = i; j < list.size(); j+= 2)
		{
			sort(j);
		}
		
		return r;
	}
	
	
	public int size()
	{
		return list.size();
	}
	
	public MyLinkedList<E> getList()
	{
		return list;
	}
	
	
	
	
}
