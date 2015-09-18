package myBinaryTree;

public class Construct <E extends java.lang.Number & Comparable<E>> extends javax.swing.JFrame {

	public Construct(MyRevisedPrinter <E> panel)
	{
		this.add(panel);
	}
	
	public static void main (String[] args)
	{
		
		Integer [] array = new Integer [15];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(array.length * Math.random());
		}
		
		ImprovedMyTree <Integer> tree = new ImprovedMyTree<> (array);
		BTreePrinter.printTreeNode(tree.root);
		
		System.out.println(tree.countLeaves(tree.root));
		java.util.Iterator<Integer> it = tree.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		
		MyRevisedPrinter <Integer> printer = new MyRevisedPrinter <> (50,30);
		Construct <Integer> frame = new Construct <> (printer);
		frame.setLayout(new java.awt.BorderLayout ());
		frame.setPreferredSize(printer.getPreferredSize());
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		printer.printTree(tree);
		System.out.println("Done");
		
		
		
		
	}
}
