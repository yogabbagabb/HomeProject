package chap16;

import javax.swing.*;
import java.awt.event.*;

// JFrame is an extended version of Frame that allows users to implement Swing,
// which allows for the creation of GUIS irrespective of the operating system
// on which they're coded

public class Listing16_1 extends JFrame{
	
	
	
	public Listing16_1()
	{
		// An implementation of a push button
		JButton jbtOK = new JButton ("OK");
		JButton jbtCancel = new JButton ("Cancel");
		
		// JPanel is a generic lightweight "container"
		JPanel panel = new JPanel ();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		
		// Adding the panel to the frame
		this.add(panel);
		
		OKListenerClass listener1 = new OKListenerClass();
		CancelListenerClass listener2 = new CancelListenerClass();	
		OKListenerClass listener3 = new OKListenerClass();
		
		/**
		 * Button add listeners; listeners respond to the ActionEvents
		 * thrown by these buttons; the throwing of these actionevents is built
		 * into each button, which throws an event when clicked
		 */
		jbtOK.addActionListener(listener1);
		jbtCancel.addActionListener(listener2);
		jbtOK.addActionListener(listener3);
	}
	
	
	class OKListenerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("OK button clicked");
		}
	}
	
	class CancelListenerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Cancel Button clicked");
		}
	}
	
	public static void main(String[]args)
	{
		JFrame frame = new Listing16_1();
		frame.setTitle("Copying from a book");
		frame.setSize(200,150);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
