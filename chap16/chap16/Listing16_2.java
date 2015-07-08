package chap16;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.*;


public class Listing16_2 extends JFrame {
	
	private JButton enlargeBut;
	private JButton reduceBut; 
	private CirclePanel canvas = new CirclePanel ();

	
	public Listing16_2()
	{
		enlargeBut = new JButton("Enlarge");
		enlargeBut.addActionListener(new EnlargeEventListener ());
		reduceBut = new JButton ("Reduce");
		reduceBut.addActionListener(new ReduceEventListener());
		
		JPanel panel = new JPanel ();
		panel.add(enlargeBut);
		panel.add(reduceBut);
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}
	
	class CirclePanel extends JPanel
	{
		private int radius = 5;
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawOval(getWidth()/2 - radius, getHeight()/2 - radius, 2 * radius, 2 * radius);
			g.drawOval(getWidth()/2 + radius, getHeight()/2 + radius, 2 * radius, 2 * radius);
		}
		
		private void enlarge()
		{
			radius += 2;
			repaint();
		}
		
		private void reduce()
		{
			radius -= 2;
			repaint();
		}
	}
	
	class EnlargeEventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			canvas.enlarge();
		}
	}
	
	class ReduceEventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			canvas.reduce();
		}
	}
	
	public static void main (String[]args)
	{
		JFrame frame = new Listing16_2 ();
		frame.setTitle("ControlCircleWithoutEventHandling");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,200);
		frame.setVisible(true);
		
	}
	

}
