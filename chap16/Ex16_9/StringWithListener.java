package Ex16_9;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class StringWithListener extends JFrame {
	
	
	public StringWithListener()
	{
		this.add(new Panel ());
	}
	
	class Panel extends JPanel
	{
		String display;
		JTextField field;
		
		public Panel()
		{
			display = "";
			field = new JTextField ("Field");
			
			this.add(field);
			
			field.addKeyListener(new KeyListener ()
			{

				@Override
				public void keyTyped(KeyEvent e) {

					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					
					if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
						
						System.out.println("1");
						display = field.getText();
						field.setText("");	
						Panel.this.repaint();
						}					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			
				
			});
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString(display,10,10);
		}
		
	}
	
	public static void main (String[]args)
	{
		StringWithListener frame = new StringWithListener ();
		frame.setVisible(true);
		frame.setSize(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	
	
	

}
