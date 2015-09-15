package Ex16_13;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

public class Slideshow extends JFrame {
	
	public Slideshow(File file)
	{
		this.add(new Panel (file));
	}

	class Panel extends JPanel
	{
		JLabel label;
		Timer timer;
		File picFile;
		int n = 1;
		ImageIcon icon;
		
		public Panel(File file)
		{
			picFile = file;
			String [] files = picFile.list();
			System.out.println(Arrays.toString(files));
			
			icon = new ImageIcon (picFile.getPath() + "//" + files[n]);
			
			label = new JLabel ();
			label.setIcon(icon);
			this.add(label);
			
			timer = new Timer (1000, new ActionListener() {
			
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("3");
					++n;
					icon = new ImageIcon (picFile.getPath() + "//" + files[n % files.length]);
					label.setIcon(icon);
					
				}
				
				});
			
			timer.start();
		}
	}
	
	public static void main (String[]args)
	{
		Slideshow frame = new Slideshow (new File ("chap16Pic"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
