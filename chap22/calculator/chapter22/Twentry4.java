package calculator.chapter22;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Twentry4 extends JFrame
{

	private JButton add,refresh;
	private JLabel one, two, three, four;
	private JTextField entry;
	final int answer = 24; 
	
	
	public Twentry4()
	{
		this.setLayout(new java.awt.GridLayout(2,0));
		this.add(new ControlPanel());
		this.add(new DisplayPanel());
		
	}
	
	class ControlPanel extends JPanel
	{
		public ControlPanel()
		{
			add = new JButton ("Add");
			add.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(24 == EvaluateExpression.evaluateExpression(entry.getText()));
				}
				
			});
			
			refresh = new JButton ("Refresh");
			refresh.addActionListener(new ActionListener ()
			{
				public void actionPerformed(ActionEvent e)
				{
					JLabel[] array = new JLabel [] {one,two,three,four};
					
					for (int i = 0; i < array.length; i++)
					{
						int x = (int)(Math.random()*(51) + 1);
						array[i].setIcon(new ImageIcon ("card/"
								 + x +".png"));
					}
				}
			});
			
			entry = new JTextField("Enter your answer");
			entry.setColumns(20);
			
			this.setLayout(new java.awt.FlowLayout ());
			this.add(refresh);
			this.add(add);
			this.add(entry);
		}
		
	}
	
	class DisplayPanel extends JPanel
	{
		JLabel[] array;
		
		public DisplayPanel()
		{
			one = new JLabel();
			two = new JLabel();
			three = new JLabel();
			four = new JLabel();
			array = new JLabel [] {one,two,three,four};
			
			for (int i = 0; i < array.length; i++)
			{
				int x = (int)(Math.random()*(51) + 1);
				array[i].setIcon(new ImageIcon ("/Users/ahanagrawal/Documents/Java/HomeProject/chap22/calculator/chapter22/card/"
				 + x +".png"));
				
				System.out.println("chap22/calculator/chapter22/card"
				 + x +".png");
			}
			
			this.add(one);
			this.add(two);
			this.add(three);
			this.add(four);
		}
		
		
	}

	public static void main (String[]args)
	{
		Twentry4 frame = new Twentry4();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
}
