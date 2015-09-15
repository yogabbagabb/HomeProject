package chap16;
import javax.swing.*;

public class InsetsExplorationFrame extends JFrame {
	
	
	public InsetsExplorationFrame()
	{
		
	}
	
	public static void main (String[]args)
	{
		InsetsExplorationFrame frame = new InsetsExplorationFrame();
		InsetsExploration panel = new InsetsExploration();
		
		panel.add(new JButton ("Hello"));
		frame.add(panel);
		
		frame.setSize(440,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
