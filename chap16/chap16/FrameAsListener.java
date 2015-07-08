package chap16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameAsListener extends JFrame implements ActionListener {
	
	JButton openButton;
	JButton closeButton;
	
	public FrameAsListener()
	{
		openButton = new JButton ("Open");
		closeButton = new JButton ("Close");
		JPanel panel = new JPanel ();
		panel.add(openButton);
		panel.add(closeButton);
		
		
		
		openButton.addActionListener(this);
		closeButton.addActionListener(this);
		
		panel.add(openButton);
		panel.add(closeButton);
		
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == openButton)
			System.out.println("open");
		
		if (e.getSource() == closeButton)
			System.out.println("close");
	}
	
	public static void main(String[]args)
	{
		JFrame frame = new FrameAsListener();
		frame.setTitle("no title");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
