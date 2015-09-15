package examples;
import java.awt.BorderLayout;

import javax.swing.*;

public class FlowLayoutExample extends JFrame {
	
// final
	
 /**
**  public static void main
*/
	
	
	
	public FlowLayoutExample()
	{
		this.setLayout(new BorderLayout ());
		this.add(new JButton("1"),BorderLayout.EAST);
		this.add(new JButton("2"),BorderLayout.EAST);
		this.add(new JButton("3"));
	}
	
	
	public static void main (String[]args)
	{
		FlowLayoutExample frame = new FlowLayoutExample ();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
