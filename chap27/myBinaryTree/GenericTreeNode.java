package myBinaryTree;

public class GenericTreeNode <E extends java.lang.Number & Comparable<E>>	
{
	
	protected TreeNode<E> left;
	protected TreeNode<E> right;
	protected E element;
	protected E averageRight;
	protected int numRight;
	protected E averageLeft;
	protected int numLeft;
	
	public GenericTreeNode (E el)
	{
		element =  el;
	}
	
	public GenericTreeNode()
	{
		
	}
	
	public TreeNode<E> clone()
	{
		return new TreeNode<E> (this.element);
	}
	
	public String toString()
	{
		return left.element.toString() + "---->" + element + "<-----" + right.element.toString(); 
	}
	
	public E add(E another)
	{
		return null;
	}
	
	
	
}
