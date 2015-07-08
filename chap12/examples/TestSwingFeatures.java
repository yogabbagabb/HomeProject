package examples;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;

public class TestSwingFeatures extends JFrame {
	
	public TestSwingFeatures()
	{
		JPanel panelOne = new JPanel (new GridLayout(0,4));
		panelOne.add(new JLabel ("Good"));
		panelOne.add(new JLabel ("Price per Unit"));
		panelOne.add(new JLabel ("Quantity"));
		panelOne.add(new JLabel ("Total"));
		
		for (int i = 0; i < 8; i++)
			panelOne.add(new JTextField (""));
		
		JButton button = new JButton ("Button");
		button.setForeground(new Color (200,100,10));
		button.setBackground(new Color (33,255,1));
		button.setBorder(new LineBorder(Color.BLACK,1));
		panelOne.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		button.setToolTipText("This is a bad button");
		button.setIcon(new ImageIcon ("chap16Pic/Badge-Videos.png"));
		this.add(button);
		
		this.add(panelOne, BorderLayout.NORTH);
		
		JPanel panelTwo = new JPanel (new BorderLayout());
		panelTwo.add(new JTextField(), BorderLayout.NORTH);
		panelTwo.add(new JButton ("Add"),BorderLayout.WEST);
		panelTwo.add(new JButton ("Delete"),BorderLayout.EAST);
		this.add(panelTwo, BorderLayout.SOUTH);
		
		
		
	}
	
	public static void main (String[]args)
	{
		TestSwingFeatures frame = new TestSwingFeatures ();
		frame.setSize(300,500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	
	
	
	
	

}
