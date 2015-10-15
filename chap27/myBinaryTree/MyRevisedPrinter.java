package myBinaryTree;

public class MyRevisedPrinter <E extends java.lang.Number & Comparable<E>> extends javax.swing.JPanel
{
	private int spacing, verticalSpacing;
	final int RADIUS = 100;
	
	public MyRevisedPrinter(int spacing, int verticalSpacing)
	{
		this.spacing = spacing;
		this.verticalSpacing = verticalSpacing;
		this.setSize(700, 500);
	}
	
	public void printTree(ImprovedMyTree <E> copy)
	{
		int height = 100;
		int initialDepth = 1;
		printNodeInOrder(copy.root, this.getWidth()/2, height, initialDepth);
		testPrint();
		repaint();
	}
	
	public void printNodeInOrder(TreeNode <E> node, int x, int y, int depth)
	{
		
		if (node == null)
			return;
		printTreeNode(node, x, y, depth);
		java.awt.Graphics g = this.getGraphics();
		printNodeInOrder(node.left, x - (int)(spacing/depth + 1), y + verticalSpacing, depth + 1);
		
		g.drawLine(x, y,  x - (int)(spacing/depth + 1), y + verticalSpacing);
		printNodeInOrder(node.right, x + (int)(spacing/depth + 1), y + verticalSpacing, depth + 1);
		g.drawLine(x, y,  x + (int)(spacing/depth + 1), y + verticalSpacing);
		
	}
	
	public void testPrint()
	{
		java.awt.Graphics g= this.getGraphics();
		g.drawOval(this.getWidth(),this.getHeight(), 50, 50);
	}
	
	@Override
	public void paint(java.awt.Graphics g)
	{
		g.drawOval(this.getWidth(),this.getHeight(), 50, 50);
	}
	
	@Override
	public void paintComponent(java.awt.Graphics g)
	{
		g.drawOval(this.getWidth(),this.getHeight(), 50, 50);
	}
	
	public void printTreeNode(TreeNode<E> node, int x, int y, int depth)
	{
		java.awt.Graphics g = this.getGraphics();
		g.drawOval(x,y,RADIUS, RADIUS);
	}
	
	@Override
	public java.awt.Dimension getPreferredSize()
	{
		return new java.awt.Dimension(this.getWidth(), this.getHeight());
	}
}
