package myBinaryTree;

public class MyRevisedPrinter <E extends java.lang.Number & Comparable<E>> extends javax.swing.JPanel
{
	private int spacing, verticalSpacing;
	
	public MyRevisedPrinter(int spacing, int verticalSpacing)
	{
		this.spacing = spacing;
		this.verticalSpacing = verticalSpacing;
	}
	
	public void printTree(MyTree <E> copy)
	{
		
	}
	
	public void printNodeInOrder(TreeNode <E> node, int x, int y, int depth)
	{
		if (node == null)
			return;
		printTreeNode(node);
		printNodeInOrder(node.left, x - (int)(spacing/depth + 1), y + verticalSpacing, depth + 1);
		printNodeInOrder(node.right, x + (int)(spacing/depth + 1), y + verticalSpacing, depth + 1);
	}
	
	public void printTreeNode(TreeNode<E> node)
	{
		
	}
	
}
