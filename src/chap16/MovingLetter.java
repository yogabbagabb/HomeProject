package chap16;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.event.*;
public class MovingLetter extends JFrame {

	
	
	
	public MovingLetter()
	{
		this.add(new MessagePanel("Some message #1"));
		this.add(new MessagePanel("Some message #2"));
		
	}
	
	public static void main (String[]args)
	{
		
		MovingLetter frame = new MovingLetter ();
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Animation Demo");
		
		
	}
	
	static class MessagePanel extends JPanel
	{
		// data fields
		String message;
		int xCoor;
		int yCoor;
		private Timer timer = new Timer(1000, new TimerListener());
		
		public MessagePanel(String s)
		{

			xCoor = 0;
			yCoor = 20;
			
			message = s;
			timer.start();
			// who adds the timelistener; the clock
			// yes, the clock adds the timerlistener
			// who listens for the timerlistener
			// a method method within listens for the listener
			// in this case; we want the graphic to update its appearance
			// each time an increment of clock goes through;

			this.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					int delay = timer.getDelay();
					
					if (e.getButton() == MouseEvent.BUTTON1)
					timer.setDelay(delay > 10? delay - 10 : 0);
					if (e.getButton() == MouseEvent.BUTTON3)
					timer.setDelay(delay > 1000? 1000 : delay + 10);
				}
			});
		
		}
		
		
	
	
	
	class TimerListener implements ActionListener
	{
		// how does the KeyListener work in conjunction
		// with the TimerListener
		// it does not, it repaints everytime the timer fires an ActionEvent
		public void actionPerformed(ActionEvent e)
		{
			
			repaint();
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (xCoor > getWidth()) {
			xCoor = -20;
		}
			xCoor += 5;
			g.drawString(message, xCoor, yCoor);
	}
	
	}
	
	
	
	
}
