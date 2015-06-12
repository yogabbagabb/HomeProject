package chap16;

import java.awt.event.*;

import javax.swing.*;


public class Listing16_5 extends JFrame {
	
	JButton button1 = new JButton ("done");
	JButton button2 = new JButton ("done");
	JButton button3 = new JButton ("done");
	JButton button4 = new JButton ("done");
	
	public Listing16_5()
	{
		
	JPanel panel = new JPanel ();
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	panel.add(button4);
	
	button1.addActionListener(new ActionListener ()
			
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("done");
				}
			});
	

	button2.addActionListener(new ActionListener ()
			
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("done");
				}
			});
	

	button1.addActionListener(new ActionListener ()
			
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("done");
				}
			});
	add(panel);
	
	}
	
	public static void main (String[]args)
	{
		JFrame frame = new Listing16_5();
		frame.setTitle("doneDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();	
		frame.setVisible(true);
	}
	
	
	
	

}
