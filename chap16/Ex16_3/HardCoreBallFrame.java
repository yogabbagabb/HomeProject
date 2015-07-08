package Ex16_3;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * Not yet working. This program won't work, because I don't supply a keystroke for the mapping I attempt
 * with the left button. I don't know the keystroke that would represent a button being hit.
 */
public class HardCoreBallFrame extends JFrame {
	
	JPanel panel = new BallPanel ();
	
	
	public HardCoreBallFrame()
	{
		this.add(panel);
	}
	
	public static void main (String[]args)
	{
		HardCoreBallFrame frame = new HardCoreBallFrame();
		frame.setVisible(true);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	
	class BallPanel extends JPanel
	{
		int x,y;
		JButton leftButton, rightButton, downButton, topButton;
		
		public BallPanel()
		{
			leftButton = new JButton ("left");
//			leftButton.getInputMap().put(leftButton.get, "Hit");
			
			
			rightButton = new JButton ();
			rightButton.addActionListener(new CircleListener ());
			this.add(rightButton);
			
			topButton = new JButton ();
			topButton.addActionListener(new CircleListener ());
			this.add(topButton);
			
			downButton = new JButton ();
			downButton.addActionListener(new CircleListener ());
			this.add(downButton);
		}
		
		class CircleListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == leftButton)
				{
					x -= 10;
				}
				
				if (e.getSource() == rightButton)
				{
					x += 10;
				}
				
				if (e.getSource() == downButton)
				{
					y += 10;
				}
				
				if (e.getSource() == topButton)
				{
					y -= 10;
				}
				
				repaint();
			}
		
		}
		
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawOval(x, y, 20, 20);
		}

	}
}
