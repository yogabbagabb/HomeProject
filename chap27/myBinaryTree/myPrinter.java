package myBinaryTree;

import java.awt.Graphics;

public class myPrinter<E extends java.lang.Number & Comparable<E>> extends javax.swing.JPanel {

	static final int RADIUS = 40; 
	java.util.ArrayList <Integer> depthList;
	java.util.ArrayList <Integer> depthListInP;
	java.util.ArrayList <Line> lines;	
	java.util.ArrayList <Circle> circles;
	
	public myPrinter() {
		depthList = new java.util.ArrayList <> ();
		depthListInP = new java.util.ArrayList <> ();
		circles = new java.util.ArrayList <> ();
		lines = new java.util.ArrayList <> ();
	}
	
	public void print(TreeNode<E> node)
	{
		checkTree(node, null);
		printTreeB(node, 1);
	}
	
	public void checkTree(TreeNode<E> node, Counter count)
	{
		int depth;
		
		if (count == null)
		{
			depth = 1;
			if (depth > depthList.size())
			{
				for (int i = depthList.size(); i < depth; i++)
				{
					depthList.add(0);
				}
			}
			depthList.set(0, 1);
		}
		else
		{
			depth = count.previousDepth + 1;
			if (depth > depthList.size())
					for (int i = depthList.size(); i < depth; i++)
					{
						depthList.add(0);
					}
			depthList.set(depth - 1, depthList.get(depth-1) + 1);
		}
		
		if (node.left != null)
		{
			checkTree(node.left, new Counter (node, depth));
		}
		
		if (node.right != null)
		{
			checkTree(node.right, new Counter (node, depth));
		}
		
	}
	
	public void printTreeB(TreeNode<E> node, int depth)
	{

		if (depth > depthListInP.size())
			for (int i = depthListInP.size(); i < depth; i++)
			{
				depthListInP.add(0);
			}
		depthListInP.set(depth - 1, depthListInP.get(depth-1) + 1);
		
		if (node.left != null)
		{
			printTreeB(node.left, depth + 1);
		}
		
		if (node.right != null)
		{
			printTreeB(node.right, depth + 1);
		}
		
		if (depth != 1)
		{	
			int numberFigures = depthList.get(depth - 1);
			int spacing = 50;
			
			int farLeft = this.getWidth()/2;
			int halfLineSpace =  spacing*(depth-1);
			if (numberFigures != 1)
				numberFigures -= 1;
			double spacesThrough = depthListInP.get(depth-1)-1;
			double fractionRight = (spacesThrough)/(numberFigures);
			
			int x1 = (int)(farLeft - halfLineSpace + fractionRight*(2*halfLineSpace));
			int y1 = (int)(spacing*(depth-1));
		
			numberFigures = depthList.get(depth-2);
			halfLineSpace =  spacing*(depth-2);
			if (numberFigures != 1)
				numberFigures -= 1;
			spacesThrough = depthListInP.get(depth-2)-1;
			fractionRight = (spacesThrough)/(numberFigures);
			
			int x2 = (int)(farLeft - halfLineSpace + fractionRight*(2*halfLineSpace));
			int y2 = (int)(spacing*(depth - 2));
			
			double d = Math.sqrt(spacing * spacing + (x2 - x1) * (x2 - x1));
			int x11 = (int)(x1 + RADIUS/2 - RADIUS/2 * (x1 - x2) / d);
			int y11 = (int)(y1 + RADIUS/2 - RADIUS/2 * (y1 - y2) / d);
			int x21 = (int)(RADIUS/2 + x2 + RADIUS/2 * (x1 - x2) / d);
			int y21 = (int)(RADIUS/2 + y2 + RADIUS/2 * (y1 - y2) / d);
			
			circles.add(new Circle (x1, y1, RADIUS,node.element));
			lines.add(new Line (x11,y11,x21,y21));
		}
		else
		{
			 circles.add(new Circle(this.getWidth()/2, 0, RADIUS,node.element));
		}
	}
	
	public void printTree(TreeNode<E> node, Counter count)
	{
		int depth;
		
		if (count == null)
		{
			depth = 1;
			if (depth > depthList.size())
			{
				for (int i = depthList.size(); i < depth; i++)
				{
					depthList.add(0);
				}
			}
			depthList.set(0, 1);
			printTree(node.left, new Counter (node, depth));
			printTree(node.right, new Counter (node, depth));
			return;
		}
		else
		{
			depth = count.previousDepth + 1;
			if (depth > depthList.size())
					for (int i = depthList.size(); i < depth; i++)
					{
						depthList.add(0);
					}
			depthList.set(depth - 1, depthList.get(depth-1) + 1);
		}
		
		if (node.left != null)
		{
			printTree(node.left, new Counter (node, depth));
		}
		
		if (node.right != null)
		{
			printTree(node.right, new Counter (node, depth));
		}
		
		drawFigure(node, count);
	}
	
	public void drawFigure(TreeNode<E> node, Counter count)
	{
		// root is drawn
		if (count == null)
		{
			 circles.add(new Circle(this.getWidth()/2 - RADIUS/2, 25, RADIUS,node.element));
		}
		
		else
		{
			int depth = count.previousDepth + 1;
			int numberFigures = depthList.get(depth - 1);
			boolean leftOfTop = node.element.compareTo(count.previousValue.element) < 0;
			int spacing = 50;
			
			int x1 = 0;
			int farLeft = this.getWidth()/2;
			int halfLineSpace =  spacing*(depth-1);
			double fractionRight = (numberFigures - 1)/(Math.pow(2, depth-1) -1);
			x1 = (int)(farLeft - halfLineSpace + fractionRight*(2*halfLineSpace));
			
			int y1 = (int)(spacing*(depth-1));
		
			numberFigures = depthList.get(depth-2);
			halfLineSpace =  spacing*(depth-2);
			fractionRight = (numberFigures - 1)/(Math.pow(2, depth-2) -1);
			int x2 = (int)(farLeft - halfLineSpace + fractionRight*(2*halfLineSpace));

			
			int y2 = (int)(spacing*(depth - 2));
			
			circles.add(new Circle (x1, y1, RADIUS,node.element));
			lines.add(new Line (x1,y1,x2,y2));
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		for (Line line: lines)
		{
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
		
		for (Circle circle: circles)
		{
			g.drawOval((int)circle.x, (int)circle.y, (int)circle.RADIUS, (int)circle.RADIUS);
			String str = circle.value.toString();
			g.drawString(str, (int)(circle.x + circle.RADIUS/2), (int)(circle.y + circle.RADIUS/2));
		}

	}
	
	
	class Counter
	{
		private TreeNode<E> previousValue;
		private int previousDepth;
		
		public Counter(TreeNode<E> node, int previousDepth)
		{
			this.previousValue = node;
			this.previousDepth = previousDepth;
		}
		
	}
	
	class Line
	{
		private int x1, y1, x2, y2;
		
		public Line (int a, int b, int c, int d)
		{
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
		
		public double[] getLine()
		{
			return new double[]{x1,y1,x2,y2};
		}
		
	}
	
	class Circle
	{
		private double x,y, RADIUS;
		private E value;
		
		public Circle(double a, double b, double r, E val)
		{
			x = a;
			y = b;
			RADIUS = r;
			value = val;
		}
		
		public double[] getCircle()
		{
			return new double []{x,y,RADIUS};
		}
	}

}
