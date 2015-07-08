package chap16;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MouseEventDemo extends JFrame {

	private JButton button;
	
	public MouseEventDemo()
	{
		button = new JButton ("Button");
		JPanel pane = new JPanel ();
		pane.add(button);
		this.add(button);
		button.addMouseListener(new MouseListener () 
		{
			public void mousePressed(MouseEvent e)
			{
				System.out.println("1");
			}
			
			public void mouseReleased(MouseEvent e)
			{
				System.out.println("2");
			}
			
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("3");
			}
			
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("4");
			}
			
			public void mouseExited(MouseEvent e)
			{
				System.out.println("5");
			}
			
			
		});
	}
	
	public static void main(String[]args)
	{
		MouseEventDemo demo = new MouseEventDemo();
		demo.setVisible(true);
		demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
		demo.pack();
		demo.setLocationRelativeTo(null);
	}
	
	
}
