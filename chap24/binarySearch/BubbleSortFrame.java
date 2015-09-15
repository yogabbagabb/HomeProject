package binarySearch;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class BubbleSortFrame extends javax.swing.JPanel {
	
	private StepBubbleSort sort;
	private int[] array;
	private javax.swing.Timer timer;
	boolean running;
	
	public StepBubbleSort getBubbles()
	{
		return sort;
	}
	public BubbleSortFrame()
	{
		running = true;
		array = new int [20];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		
		
		sort = new StepBubbleSort(array);
		timer = new javax.swing.Timer(10, new java.awt.event.ActionListener (){

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean stop = sort.step();
				repaint();
				if (stop)
				{
					timer.stop();
					running = false;
				}
			}
			
		});
		
		timer.start();
		this.repaint();
	}
	
	public boolean running()
	{
		return running;
	}
	
	public void paintComponent(java.awt.Graphics g)
	{
		super.paintComponent(g);
		int x = 0;
		int firstChangedBar;
		int secondChangedBar;
		if (sort.getChanged())
		{
			firstChangedBar = sort.geti();
			secondChangedBar = firstChangedBar + 1;
		}
		
		else
		{
			firstChangedBar = array.length;
			secondChangedBar = array.length;
		}
		for (int i = 0; i < array.length; i++, x+= 10)
		{
			if (i == firstChangedBar)
			{
				g.setColor(Color.BLUE);
				g.fillRect(this.getWidth()/2 + x,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
			}
			else if (i == secondChangedBar)
			{
				g.setColor(Color.BLUE);
				g.fillRect(this.getWidth()/2 + x,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
			}
			else
			{
				g.setColor(Color.BLACK);
				g.drawRect(this.getWidth()/2 + x,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
			}
				
		}
	}
	
	public static void main(String[]args)
	{
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.add(new BubbleSortFrame(), java.awt.BorderLayout.CENTER);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	
	
	

}
