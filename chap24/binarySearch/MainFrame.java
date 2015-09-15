package binarySearch;

public class MainFrame {

	public static void main(String[] args) {

		javax.swing.JFrame mFrame = new javax.swing.JFrame();
		
		
		javax.swing.JPanel frame = new javax.swing.JPanel();
		frame.setLayout(new java.awt.CardLayout());
		BubbleSortFrame bubbles = new BubbleSortFrame();
		frame.add(bubbles, "BUBBLES");
		frame.add(new BinarySearchFrame(bubbles.getBubbles().getArray()), "BINARY");
		

		mFrame.add(frame);
		mFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.pack();
		mFrame.setVisible(true);
		
		while(bubbles.running())
		{
			
		}
		
		java.awt.CardLayout layout = (java.awt.CardLayout)(frame.getLayout());
		layout.show(frame, "BINARY");
	}

}
