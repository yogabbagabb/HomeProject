package Ex16_14;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class RacingCar extends JFrame {
	
	public RacingCar()
	{
		this.add(new Panel());
	}
	
	public class Panel extends JPanel
	{
		
		int xLeftWheel, xRightWheel, xRectangle, xTrapezoid;
		Timer timer;
		
		

		public Panel()
		{
			
			xLeftWheel = 1;
			xRightWheel = 70;
			xRectangle = 2;
			xTrapezoid = 3;
	
			
			timer = new Timer (100
			, new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
				
			});
			
			timer.start();
			
			
			this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),
					"Down");
			this.getActionMap().put("Down", new UpDownAction());
			
			
					
			
			
			
		}
		
		class UpDownAction extends AbstractAction
		{
			public void actionPerformed(ActionEvent e)
			{
				
				if (e.getActionCommand().equals("DOWN"))
				{
					timer.setDelay(timer.getDelay() + 100);
					System.out.println("1");
				}
				if (e.getActionCommand().equals("UP"))
					timer.setDelay(timer.getDelay() - 100);
				
			}
		}
		
		class PauseAction extends AbstractAction
		{
			public void actionPerformed(ActionEvent e)
			{
				if (timer.isRunning())
				timer.stop();
				
				else
				timer.start();
			}
		}
	
		public void paintComponent(Graphics g)
		{
			xLeftWheel += 5;
			xRightWheel += 5;
			xRectangle += 5;
			xTrapezoid += 5;
			
			int radius = 10;
			
			g.drawRect(xRectangle, 40, 70, 30);
			g.drawOval(xRectangle + 70 - radius/2,70, 10, 10);
			g.drawOval(xRectangle - radius/2, 70, 10, 10);
			
		}
		
	}

	
	
	public static void main(String[]args)
	{
		RacingCar frame = new RacingCar ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
}
