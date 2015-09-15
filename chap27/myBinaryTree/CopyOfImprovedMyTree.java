package myBinaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class CopyOfImprovedMyTree<E extends java.lang.Number & Comparable<E>, SpecifiedTreeNode extends GenericTreeNode<E>> {

	SpecifiedTreeNode root;
	
	public void add(E e, TreeNode<E> root)
	{
		GenericTreeNode <E> toAdd = new GenericTreeNode ();
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		boolean right = false;
		
		SpecifiedTreeNode f = null;
		
		
		while (current != null)
		{
		 
			if (toAdd.element.compareTo(current.element) > 0)
			{
				if (checkSwap(current, current.right, toAdd))
				{	
					E standby = toAdd.element;
					toAdd.element = current.right.element;
					current.right.element = standby;
				}
				
					parent = current;
					current = current.right;
					right = true;
			}
			
			else if (toAdd.element.compareTo(current.element) <= 0)
			{
				if (checkSwap(current, current.left, toAdd))
				{	
					E standby = toAdd.element;
					toAdd.element = current.left.element;
					current.left.element = standby;
				}
				
					parent = current;
					current = current.left;
					right = false;
			}
		}
		
			if (right)
				parent.right = toAdd;
			else
				parent.left = toAdd;
	}
	
	public java.util.Iterator iterator()
	{
		java.util.List <TreeNode<E>> list = new java.util.ArrayList<> ();
		inOrder(root,list);
		
		return new java.util.Iterator <E>()
		{

			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < list.size();
			}

			@Override
			public E next() {
				E ret = list.get(i).element;
				i++;
				return ret;
			}
			
			
		};
	}
	
	
	
	 public boolean checkSwap(TreeNode<E> root, TreeNode <E> potential, TreeNode<E> toAdd)
	 {
		 if (potential == null)
			 return false;
		double diffS = Math.abs(root.element.doubleValue() - potential.element.doubleValue());
		double diffE = Math.abs(root.element.doubleValue() - toAdd.element.doubleValue());
		
		if (diffE < diffS)
		{
			return true;
		}
		return false;
	
	 }
	
	public boolean removeSecond(E e)
	{
		TreeNode <E> node = new TreeNode<> (e);
		
		SpecifiedTreeNode parent = null;
		TreeNode<E> current = root;
		
		while (current != null)
		{
			if (current.element.compareTo(node.element) < 0)
			{
				parent = current;
				current = current.left;
			}
			
			if (current.element.compareTo(node.element) > 0)
			{
				parent = current;
				current = current.right;
			}
			
			else
				break;
		}
		
		if (current == null)
		{
			return false;
		}
		
		if (current.left == null)
		{
			if (parent == null)
			{
				root = current.right;
			}
			else
			{
				if (current.right.element.compareTo(parent.element) < 0)
				{
					parent.left = current.right;
				}
				else
				{
					parent.right = current.right;
				}
			}
			
		}
		else
		{
			
			TreeNode<E> parentOfRightMost = null;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null)
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			if (parentOfRightMost == null)
			{
				if (current.right.element.compareTo(parent.element) < 0)
				{
					parent.left = rightMost;
					rightMost.right = current.right;
				}
				else
				{
					parent.right = rightMost;
					rightMost.right = current.right;
				}
			}
			
			else
			{
				if (current.right.element.compareTo(parent.element) < 0)
				{
					parent.left = rightMost;
					rightMost.right = current.right;
					parentOfRightMost.right = rightMost.left;
					rightMost.left = current.left;
				}
				else
				{
					parent.right = rightMost;
					rightMost.right = current.right;
					parentOfRightMost.right = rightMost.left;
					rightMost.left = current.left;
					
				}
			}
			
			
		}
		
		return true;
		
	}
	
	public void inOrder(TreeNode <E> root, java.util.List list)
	{
		
		if (list == null)
			list = new java.util.ArrayList <TreeNode<E>> ();
		
		if (root == null)
			return;
	
		inOrder(root.left,list);
		list.add(root.clone());
		inOrder(root.right,list);
		
	}
	
	
	
	
	public boolean remove(E e)
	{
		
		
		TreeNode<E> remove = new TreeNode<E> (e);
		TreeNode<E> current = root;
		
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
	
	public CopyOfImprovedMyTree()
	{
		
	}
	
	public CopyOfImprovedMyTree(E[] array)
	{
		
		Collections.sort(Arrays.asList(array));
		root = new TreeNode <E> (array[array.length/2]);
		for (int i = 0; i < array.length; i++)
		{
			add(array[i], root);
		}
		
	}
	
	
}
