package ex22_7;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ControlPanel extends JFrame {
	
	private JLabel message;
	private JTextField enterLetter;
	private JButton add;
	private FormulateString wordMan;
	private HangmanPanel hang;

	
	public ControlPanel(FormulateString man, HangmanPanel hang)
	{
		this.hang = hang;
		wordMan = man;
		LowerPanel lowerPanel = new LowerPanel ();
		StringPanel upperPanel = new StringPanel ();
		
		this.setLayout(new java.awt.GridLayout(3,0));
		
		this.add(lowerPanel);
		this.add(upperPanel);
		this.add(hang);
		
		
		
	}
	
	class LowerPanel extends JPanel
	{
		
		
		public LowerPanel()
		{
			enterLetter = new JTextField ();
			enterLetter.setColumns(3);
			add = new JButton ("Add");
			
			add.addActionListener(new ActionListener ()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					String text = enterLetter.getText();
					wordMan.addWord(text);
					message.setText(wordMan.getLabel());
					hang.firePaint(wordMan.getWrong());
				}
				
			});
			
			this.setLayout(new FlowLayout());
			this.add(enterLetter);
			this.add(add);
		}
		
	
	}
	
	
	
	class StringPanel extends JPanel
	{
		
		public StringPanel()
		{
			message = new JLabel();
			this.add(message);
		}
	}


	



	public static void main(String[] args) {
		HangmanPanel hang = new HangmanPanel();
		FormulateString string = new FormulateString ("Aask");
		ControlPanel frame = new ControlPanel (string,hang);

		
		frame.setSize(300,300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		
	}	
	
	class HangmanPanel extends JPanel
	{
		
		int wrong;
		
		public HangmanPanel()
		{
			wrong = 0;
		}
		
		public void firePaint(int num)
		{
			repaint();
			wrong = num;
			System.out.println("Fired Paint");
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.BLACK);
			g.drawOval(50, 50, 25, 25);
			g.fillOval(50, 50, 25, 25);
			System.out.println("Fired Paint2");


			if (wrong >= 1)
			{
				g.drawOval(50, 50, 25, 25);
			}
			
			if (wrong >= 2)
			{
				g.drawLine(62, 75, 62, 150);
			}
			
			if (wrong >= 3)
			{
				
			}
			
			if (wrong >= 4)
			{
				
			}
			
			if (wrong >= 5)
			{
				
			}
			
			if (wrong >= 6)
			{
				
			}
			
		
		}
	

	
	}
	
	
	class FormulateString
	{
		
		java.util.List<String> guesses;
		private String[] word;
		private int wrong;
		
		public FormulateString(String word)
		{
			guesses = new java.util.ArrayList <> ();
			this.word = word.split("");
			wrong = 0;
		}
		
		public String getLabel()
		{
			
			String[] output = word.clone();
			
			for (int i = 0; i < output.length; i++)
			{
				if (guesses.contains(output[i]))
				{
					continue;
				}
				else
				{
					output[i] = "*";
				}
			}
			
			
			return this.convertStringArrayToString(output); 
		}
		
		public void addWord(String word)
		{
			if (!this.convertStringArrayToString(this.word).contains(word))
			{	++wrong;
				System.out.println("False");
			}
			guesses.add(word);
		}
		
		public int getWrong()
		{
			return wrong;
		}
		
		private String convertStringArrayToString(String[] strArr)
		{
	        StringBuilder sb = new StringBuilder();
	        for(String str : strArr) sb.append(str);
	        return sb.toString();
	    }
		
	}

	







