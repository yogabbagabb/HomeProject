package Ex16_20;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;



public class InsideACircle extends JFrame
{

	public InsideACircle()
	{
		this.add(new Panel ());
	}
	
	class Panel extends JPanel
	{
		
		public Panel()
		{
			this.addMouseMotionListener(new MouseMotionListener(){

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseMoved(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					
					
					if (Math.pow((x - 40),2) + Math.pow ((y - 40),2) <= 100)
						System.out.println("3");
					
					
				}
				
			});
			
			
			
		}
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawOval(30, 30, 20, 20);
		}
	}
	
	public static void main (String[]args)
	{
		InsideACircle frame = new InsideACircle ();
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
