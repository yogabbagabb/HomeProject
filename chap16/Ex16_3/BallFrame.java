package Ex16_3;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallFrame extends JFrame {
	
	JPanel panel = new BallPanel ();
	
	
	public BallFrame()
	{
		this.add(panel);
	}
	
	public static void main (String[]args)
	{
		BallFrame frame = new BallFrame();
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
