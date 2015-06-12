package chap16;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class MoveableMessage extends JFrame{
	
	private InnerMessagePanel panel = new InnerMessagePanel ("Hello");

	
	public MoveableMessage()
	{
		add(panel);
	}
	
	static class InnerMessagePanel extends JPanel{
		
		private int x = 20;
		private int y = 20;
		String message = "Java";
		
		public InnerMessagePanel(String s)
		{
			message = s;
			addKeyListener(new KeyListener()
			{

				@Override
				public void keyReleased(KeyEvent e) {

					System.out.println("What");

					switch (e.getKeyCode())
					{
					case KeyEvent.VK_DOWN: y -= 10;
					System.out.println("What1");
					break;
					case KeyEvent.VK_UP: y += 10; 
					System.out.println("What2");
					break;
					case KeyEvent.VK_LEFT: x-= 10;
					System.out.println("What3");
					break;
					case KeyEvent.VK_RIGHT: x+= 10;
					System.out.println("What4");
					break;
					
					}
					
					repaint();
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					System.out.println("What");

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					System.out.println("What");

				}					
				
				
			});

		}	
		
		
		@Override /** Draw the character */
		 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		
		 g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		 g.drawString(message, x, y);
		 }
		
	}
	
	public static void main(String[]args)
	{
		MoveableMessage body = new MoveableMessage ();
		body.setSize(300,300);
		body.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		body.setVisible(true);
		body.setLocationRelativeTo(null);
	}

}
