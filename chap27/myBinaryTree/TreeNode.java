package myBinaryTree;

public class TreeNode <E extends Comparable<E>>	
{
	
	protected TreeNode<E> left;
	protected TreeNode<E> right;
	protected E element;
	protected E averageRight;
	protected E averageLeft;
	
	public TreeNode(E el)
	{
		element = el;
	}
	
	public TreeNode<E> clone()
	{
		return new TreeNode<E> (this.element);
	}
	
	public String toString()
	{
		return left.element.toString() + "---->" + element + "<-----" + right.element.toString(); 
	}
	
	
	
	
}
