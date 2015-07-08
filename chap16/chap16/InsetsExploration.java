package chap16;
import javax.swing.*;
import java.awt.*;

public class InsetsExploration extends JPanel {
	
	
	private static final Insets insets = new Insets (10,10,10,10);

	public InsetsExploration()
	{
		
	}
	
	public Insets getInsets()
	{
		return insets;
	}

	public void paintComponent (Graphics g)
	{
		Dimension size = getSize();
		g.draw3DRect(5,5,size.width - 11, size.height - 11, true);
	}
}

