package huffApp;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class BufferedImagePlay extends JFrame
{
	public void paintComponent(Graphics g)
	{
		g.drawImage(new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR), 100, 100, null);
	}
	
	
	public static void main (String[]args)
	{
		BufferedImagePlay panel = new BufferedImagePlay ();
		panel.setDefaultCloseOperation(panel.EXIT_ON_CLOSE);
		panel.pack();
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
	}

}
