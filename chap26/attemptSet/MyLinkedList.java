package attemptSet;

import java.util.Iterator;

public class MyLinkedList <E> extends MyAbstractList <E> {
	
	private Node<E> head;
	private Node<E> tail;

	public MyLinkedList()
	{

		
		head = null;
		
	}
	@Override
	public void add(int index, E e) {
		
		if (index == 0)
		{
			this.addFirst(e);
		}
		
		else if (index == size)
		{
			this.addLast(e);
		}
		
		else
		{
			Node<E> left;
			left = head;
			int i = 0;
			
			while ((i+1)< index)
			{
				left = left.next;
				i++;
			}
			
			Node<E> right = left.next;
			Node<E> newNode = new Node <E> (e);
			
			left.next = newNode;
			newNode.next = right;
			
		}
		
		
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		
	}

	@Override
	public boolean contains(E e) {
		
		Node<E> first = head;
		
		while (first != tail.next)
		{
			if (first.element.equals(e))
			{
				return true;
			}
			first = first.next;
		}
		
		return false;
	}
	
	public E getFirst()
	{
		return head.element;
	}
	
	public E getLast()
	{
		return tail.element;
	}
	
	public E removeFirst()
	{
		E e = head.element;
		head = head.next;
		size--;
		return e;
		
	}
	
	public E removeLast()
	{
		E e = tail.element;
		Node<E> penUl = head;
		
		while (penUl.next != tail)
		{
			penUl = penUl.next;
		}
		
		tail = penUl;
		size--;
		return e;
	}
	public Node<E> getHeadNode()
	{
		return head;
	}
	public Node<E> getLastNode()
	{
		return tail;
	}

	public void addFirst(E e)
	{
		
		if (head == null)
		{
			head = new Node<E>(e);
			tail = head;
			size++;
		}
		
		else
		{
			Node<E> node = new Node<E> (e);
			node.next = head;
			head = node;
			size++;
		}
	}
	
	public void addLast(E e)
	{
		
		if (head == null)
		{
			head = new Node<E> (e);
			tail = head;
			size++;
		}
		else
		{
			Node<E> node = new Node<E> (e);
			tail.next = node;
			tail = node;
			
			size++;
		}
		
		
	}

	@Override
	public E get(int index) {
		
		if (index == 0)
		{
			return getFirst();
		}
		
		if (index == size - 1)
		{
			return getLast();
		}
		
		Node <E> first = head;
		int i = 0;
		
		while (i < index)
		{
			first = first.next;
			i++;
		}
		
		return first.element;
		
	}

	@Override
	public int indexOf(E e) {
		
		Node<E> first = head;
		for (int i = 0; i < size; i++)
		{
			if (first.element.equals(e))
				return i;
			first = first.next;
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		
		Node<E> first = head;
		int matchingIndex = -1;
		for (int i = 0; i < size; i++)
		{
			if (first.element.equals(e))
				matchingIndex = i;
			first = first.next;
		}
		
		return matchingIndex;
	}

	@Override
	public E remove(int index) {
		
		if (index == 0)
		{
			E e = head.element;
			removeFirst();
			return e;
		}
		
		if (index == size - 1)
		{
			E e = tail.element;
			removeLast();
			return e;
		}
		
		
		Node<E> left = head;
		for (int i = 0; i + 1 < index; i++)
		{
			left = left.next;
		}
		
		E e = left.next.element;
		left = left.next.next;
		size--;
		return e;
		
	}

	@Override
	public Object set(int index, E e) {
		
		if (index == 0)
		{
			E el = head.element;
			Node<E> replacement = new Node <E> (e);
			
			replacement.next = head.next;
			head = replacement;
			return el;
		}
		
		Node<E> left = head;
		for (int i = 0; i + 1 < index; i++)
		{
			left = left.next;
		}
		
		Node<E> replacement = new Node <E> (e);
		Node<E> right = left.next.next;
		E el = left.next.element;
		left.next = replacement;
		replacement.next = right;
		
		return el;
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
