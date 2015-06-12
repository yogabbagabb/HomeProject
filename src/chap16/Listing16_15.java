package chap16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listing16_15 extends JFrame {
	
		
	public Listing16_15()
	{
				
		JButton oneButton = new JButton ("1");
		JButton twoButton = new JButton ("2");
		
		JPanel panel = new JPanel ();
		panel.add(oneButton);
		panel.add(twoButton);
		
		this.add(panel);
	}
	
}

 class stringAgent()
{
	
	 String key, standby;
	
	stringAgent()
	{
		key = "";
		standby = "";
	}
	
	public void clearTab()
	{
		standby = "";
	}
	
	public boolean detectMatch()
	{
		if (key.equals(standby))
			return true;
		else
			return false;
	}
	
	public void addPart(String s)
	{
		standby += s;
	}
	
	
}


class oneActionListener implements ActionListener
{
	
	private final String num;
	private Listing16_15 proto;
	
	public oneActionListener()
	{
		num = "1";
		proto = new Listing16_15 ();
	}
	
	public void actionPerformed (ActionEvent e)
	{
		System.out.println(num);
		proto.addPart(num);
	}
	
	
}

class twoActionListener implements ActionListener
{
	
	private final String num;
	private Listing16_15 proto;
	
	public twoActionListener()
	{
		num = "2";
		proto = new Listing16_15 ();
	}
	
	public void actionPerformed (ActionEvent e)
	{
		System.out.println(num);
		proto.addPart(num);
	}
	
	
}

class threeActionListener implements ActionListener
{
	
	private final String num;
	private Listing16_15 proto;
	
	public threeActionListener()
	{
		num = "3";
		proto = new Listing16_15 ();
	}
	
	public void actionPerformed (ActionEvent e)
	{
		System.out.println(num);
		proto.addPart(num);
	}
	
	
}
