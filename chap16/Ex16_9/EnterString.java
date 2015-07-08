package Ex16_9;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class EnterString extends JFrame {
	
	
	public EnterString()
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
			
			this.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK), "key");
			this.getActionMap().put("key", new AbstractAction()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					System.out.println("1");
					display = field.getText();
					field.setText("");	
					Panel.this.repaint();
				
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
		EnterString frame = new EnterString ();
		frame.setVisible(true);
		frame.setSize(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	
	
	

}
