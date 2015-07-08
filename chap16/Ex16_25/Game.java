package Ex16_25;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Game extends JFrame {
	
	public class Panel extends JPanel
	{
		
		Gun gun;
		java.util.List <CannonBall> balls;
		
		public Panel()
		{
			this.setSize(300, 300);
			gun = new Gun (this.getWidth()/2,this.getHeight(),100);
			balls = new java.util.ArrayList <CannonBall> ();
			
			

			this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(
					KeyStroke.getKeyStroke("RIGHT"), "right");
			
			this.getActionMap().put("right", new AbstractAction()
			{
				
				public void actionPerformed(ActionEvent e)
				{
					gun.addDegree(1);
					repaint();
				}
				
				
			});
			
			
			this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(
					KeyStroke.getKeyStroke("LEFT"), "left");
		
			this.getActionMap().put("left", new AbstractAction()
			{
				
				public void actionPerformed(ActionEvent e)
				{
					gun.addDegree(-1);
					repaint();
				}
				
				
			});
			
			this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(
					KeyStroke.getKeyStroke("ENTER"), "enter");
			
			this.getActionMap().put("enter", new AbstractAction()
			{
				
				public void actionPerformed(ActionEvent e)
				{
					balls.add(new CannonBall(20, gun.getTurretX(), gun.getTurretY(),
							gun.getTurretX() - gun.getX(), gun.getTurretY() - gun.getY()));
					repaint();
				}
				
				
			});
			
			
			
			
		}
		
		
		public void paintComponent(Graphics g)
		{
			g.drawLine(gun.getX(), gun.getY(), (int)gun.getTurretX(), (int)gun.getTurretY());
			
			for (CannonBall ball: balls)
			{
				g.drawOval((int) ball.getX(),(int) ball.getY(), ball.getR(), ball.getR());
				ball.update();
			}
			
			
		}
		
		
	}
	
	public Game()
	{
		this.add(new Panel());
	}
	
	
	
	public static void main(String[]args)
	{
		Game frame = new Game ();
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	

}
