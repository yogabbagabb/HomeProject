package genericQueue;

public class GenericQueue<E> extends MyLinkedList<E> {
	
	
	public GenericQueue()
	{
		super();
	}
	
	public GenericQueue(E[] array)
	{
		super(array);
	}

	public void enQueue(E e)
	{
		this.addFirst(e);
	}
	
	public E deQueue()
	{
		return this.removeLast();
	}
}
