package myBinaryTree;

public class Construct extends javax.swing.JFrame {

	public Construct(myPrinter panel)
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
//		BTreePrinter.printTreeNode(tree.root);
		
		System.out.println(tree.countLeaves(tree.root));
		java.util.Iterator<Integer> it = tree.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		
		while (it.hasPrevious())
		{
			System.out.println(it.previous());
		}

		myPrinter <Integer> printer = new myPrinter <> ();
		Construct frame = new Construct (printer);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		printer.print(tree.root);
		System.out.println("Done");
		
		
		
		
	}
}
