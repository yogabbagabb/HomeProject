package myBinaryTree;

import java.util.Arrays;
import java.util.Collections;

public class MyTree <E extends java.lang.Number & Comparable<E>> {

	TreeNode <E> root;
	
	public void add(E e, TreeNode<E> root)
	{
		TreeNode<E> toAdd = new TreeNode<E> (e);
		TreeNode<E> current = root;
		
		
		boolean go = true;
		boolean right = true;
		
		while (go)
		{
		 
			if (toAdd.element.compareTo(current.element) > 0)
			{
				
				if (current.right == null)
				{
					go = false;
					right = true;
					break;
				}
				if (checkSwap(current, current.right, toAdd))
				{	
					TreeNode<E> standby = toAdd;
					toAdd = current.right;
					current.right = standby;
				}
				else
				{
					current = current.right;
				}
			}
			
			if (toAdd.element.compareTo(current.element) <= 0)
			{
				if (current.left == null)
				{
					go = false;
					right = false;
					break;
				}
				if (checkSwap(current, current.left, toAdd))
				{	
					TreeNode<E> standby = toAdd;
					toAdd = current.left;
					current.left = standby;
				}
				else
				{
					current = current.left;
				}
			}
		}
		
		if (right)
		{
			current.right = toAdd;
		}
		else
		{
			current.left = toAdd;
		}
	}
	
	 public boolean checkSwap(TreeNode<E> root, TreeNode<E> potential, TreeNode<E> toAdd)
	 {
		 
			int diffS = Math.abs(root.element.compareTo(potential.element));
			int diffE = Math.abs(root.element.compareTo(toAdd.element));
			
		
		if (diffE < diffS)
		{
			return true;
		}
		return false;
	 }
	
	public boolean remove(E e)
	{
		
		
		TreeNode<E> remove = new TreeNode<E> (e);
		TreeNode <E> current = root;
		
		boolean go = true;
		boolean right = true;
		
		while (go)
		{
		 
			if (remove.element.compareTo(current.element) > 0)
			{
				
				if (current.right == null || current.right.element.equals(e))
				{
					go = false;
					right = true;
					break;
				}
				else
				{
					current = current.right;
				}
			}
			
			if (remove.element.compareTo(current.element) < 0)
			{
				if (current.left == null || current.left.element.equals(e))
				{
					go = false;
					right = false;
					break;
				}
				else
				{
					current = current.left;
				}
			}
		}
		
		if (right)
		{
			if (current.right == null)
			{
				return false;
			}
			
			else
			{
				java.util.List <E> list = new java.util.ArrayList <> ();
				collectTree(list, current.right);
				current.right = null;
				for (E element: list)
				{
					add(element,current);
				}
			}
		}
		else
		{
			if (current.left == null)
			{
				return false;
			}
			else
			{
				java.util.List <E> list = new java.util.ArrayList <> ();
				collectTree(list, current.left);
				current.left = null;
				for (E element: list)
				{
					add(element,current);
				}
			}
		}
		
		return false;
	}
	
	
	public void collectTree(java.util.List <E> list, TreeNode<E> current )
	{
		TreeNode <E> left = current.left;
		TreeNode <E> right = current.right;
		
		if (left != null)
		{
			list.add(left.element);
			collectTree(list,left);
		}
		
		if (right != null)
		{
			list.add(right.element);
			collectTree(list,right);
		}
		
	}
		
		
		
	
	
	public boolean search(E e)
	{
		TreeNode<E> current = root;
		while(current != null)
		{
			if (root.element.equals(e))
			{
				return true;
			}
			else if(root.element.compareTo(e) > 0)
			{
				current = current.left;
			}
			else
			{
				current = current.right;
			}
		}
		
		return false;
	}
	
	public MyTree()
	{
		
	}
	
	public MyTree(E[] array)
	{
		
		Collections.sort(Arrays.asList(array));
		root = new TreeNode <E> (array[array.length/2]);
		for (int i = 0; i < array.length; i++)
		{
			add(array[i], root);
		}
		
	}
	
	
}
