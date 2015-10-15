package linkedList;

import java.util.Iterator;

public class MyLinkedList_Practice_9_6<E> extends MyAbstractList<E> {

	private Node<E> head;
	private Node<E> tail;
	
	@Override
	public void add(int index, E e) {
		if (head == null)
		{
			head = new Node<E> (e);
			size++;
		}
		
		else
		{
			int count = 0;
			Node<E> current = null;
			while (count < index)
			{
				if (current == null)
				{
					current = head;
					count++;
				}
				
				else
				{
					current = current.next;
					count++;
				}
			}
			
			if (current == null)
			{
				current = new Node <E> (e);
				current.next = head;
				head = current;
			}
			
			else if (!(current.next == null))
			{
				Node<E> next = current.next;
				current.next = new Node<E> (e);
				current.next.next = next;
			}
			
			else
			{
				current.next = new Node <E> (e);
			}
			
			size++;
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator(head,size);
	}

	class LinkedListIterator implements java.util.Iterator<E>
	{
		
		Node<E> head;
		Node<E> current;
		int size;
		int index;
		
		public LinkedListIterator(Node<E> head, int size)
		{
			this.head = head;
			this.size = size;
			current = this.head;
			index = 0;
		}
		

		@Override
		public boolean hasNext() 
		{
			return index < size;
		}

		@Override
		public E next()
		{
			E element = current.element;
			current = current.next;
			index++;
			return element;
		}
		
	}
}


