package Ex16_3;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallFrameThree extends JFrame {
	
	JPanel panel = new BallPanel ();
	
	
	public BallFrameThree()
	{
		this.add(panel);
	}
	
	public static void main (String[]args)
	{
		BallFrameThree frame = new BallFrameThree();
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

			x = 150;
			y = 150;
			leftButton = new JButton ("Left");
			leftButton.addActionListener(new ActionListener (){
			
				public void actionPerformed(ActionEvent e)
				{
					x -= 10;
					
				}
				
				
			});
			this.add(leftButton);
			
			rightButton = new JButton ("Right");
			rightButton.addActionListener(new CircleListener (rightButton,this));
			this.add(rightButton);
			
			topButton = new JButton ("Up");
			topButton.addActionListener(new CircleListener (topButton,this));
			this.add(topButton);
			
			downButton = new JButton ("Down");
			downButton.addActionListener(new CircleListener (downButton, this));
			this.add(downButton);
		}
		
		public void setX(int b)
		{
			x += b;
		}
		
	
		
		public void setY(int b)
		{
			y += b;
		}
		
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawOval(x, y, 20, 20);
		}

	}
	
	class CircleListener implements ActionListener
	{

		JButton button;
		BallPanel panel;
		
		public CircleListener(JButton button, BallPanel panel)
		{
			this.button = button;
			this.panel = panel;
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			if (button.getText() == "Left")
			{
				panel.setX(-10);
			}
			
			if (e.getSource() == "Right")
			{
				panel.setX(10);
			}
			
			if (e.getSource() == "Down")
			{
				panel.setY(-10);
			}
			
			if (e.getSource() == "Up")
			{
				panel.setY(10);
			}
			
		
			panel.repaint();
		}	
	
	}
}
