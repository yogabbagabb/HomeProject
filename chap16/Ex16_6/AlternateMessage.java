package Ex16_6;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class AlternateMessage extends JFrame {
	
	public AlternateMessage()
	{
		this.add(new MessagePanel("Message 1"));
	}
	
	

	class MessagePanel extends JPanel
	{
		String s;
		
		public MessagePanel(String message)
		{
			s = message;
//			this.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("DOWN"), "actionMapKey");
//			this.getActionMap().put("actionMapKey", new AbstractAction()
//			{
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					MessagePanel.this.setVisible(!MessagePanel.this.isVisible());
//					System.out.println("helo");	
//				}
//				
//			});
			this.addMouseListener(new MouseListener (){

				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (MessagePanel.this.s.equals("Second"))
						MessagePanel.this.s = "Message 1";
					
					else 
						MessagePanel.this.s = "Second";
					repaint();
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub


				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString(s,10,10);
		}
		
		
	}
	
	public static void main (String[]args)
	{
		AlternateMessage frame = new AlternateMessage ();
		frame.setVisible(true);
		frame.setSize(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
	
}
