package Ex16_22;
import javax.swing.*;

import Ex16_20.InsideACircle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BeanMachine extends JFrame {

	public BeanMachine()
	{
		this.add (new Panel());
	}
	
	class Panel extends JPanel
	{
		java.util.List <Circle> balls;
		Timer timer;
		int mouseX, mouseY;
		
		public Panel()
		{
			
			
			balls = new java.util.ArrayList <Circle> ();
			timer = new Timer (100, new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					for (Circle ball: balls)
					{
						ball.addY(5);
					}
					
					repaint();
				}
				
				//tuca hua
				// havaii
					
					
			});
			
			timer.start();
			this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"),"code");
			this.getActionMap().put("code", new AbstractAction()
					{

						@Override
						public void actionPerformed(ActionEvent e) {
							balls.add(new Circle(mouseX, mouseY, 10));
							repaint();
						}
						
					
				
					});
			
			
			this.addMouseMotionListener(new MouseMotionListener(){

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseMoved(MouseEvent e) {
					mouseX = e.getX();
					mouseY = e.getY();
				}
			});
			
		}
		
		
		public void paintComponent(Graphics g)
		{
			
			java.util.List <Circle> blocks = new java.util.ArrayList <Circle> ();
			final int ballApart = 30;
			int x = this.getWidth()/2 + ballApart/2;
			int y = 0;
			
			for (int numBalls = 1; numBalls <= 5; numBalls++)
			for (int i = 0; i < numBalls ; i++)
			{
				if (i == 0)
				{
					y += 30;
					x -= (numBalls * ballApart);
					x += ballApart/2;
				}
				
				g.setColor(new Color (244,233,60));
				g.fillOval(x, y, 20, 20);
				blocks.add(new Circle (x,y,20));
				
				
				g.setColor(Color.BLACK);
				if (numBalls == 5)
					g.drawLine(x, y , x, y + 15);
				
				x += ballApart;
				
				
			}
			
			
			g.setColor(Color.BLACK);
			for (Circle ball: balls)
			{
				g.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR());
				
				for (Circle other: blocks)
				{
					double [] array = ball.detectCollision(other);
					ball.addX(array[0]);
					ball.addY(array[1]);
				}
			}
			
			
		}
		
		
		
	}
	
	public static void main (String[]args)
	{
		BeanMachine frame = new BeanMachine ();
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}






class Circle
{
	private int x, y, radius;
	
	public Circle(int a, int b, int c)
	{
		x = a;
		y = b;
		radius = c;
	}
	
	public void addY(double y)
	{
		this.y += y;
	}
	
	public void addX(double x)
	{
		this.x += x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getR()
	{
		return radius;
	}
	
	public double[] detectCollision(Circle other)
	{
		double xOne = this.getX() + this.getR()/2.0;
		double xTwo = other.getX() + other.getR()/2.0;
		
		double yOne = this.getY() + this.getR()/2.0;
		double yTwo = other.getY() + other.getR()/2.0;
		
		if (Math.pow((xTwo - xOne),2) + Math.pow((yTwo - yOne),2) - (Math.pow((other.getR() - this.getR()),2)) < 0.001) 
			return new double [] {xOne - xTwo, yOne - yTwo};
		else
			return new double [] {0,0};
	}
	
	
}

