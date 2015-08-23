package binarySearch;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class BinarySearchFrame extends javax.swing.JPanel {
	
	private int[] array;
	private javax.swing.Timer timer;
	private StepBinarySort search;
	
	
	public BinarySearchFrame(int[] array)
	{
		this.array = array;
		search = new StepBinarySort(this.array,this.array[7]);
		
		timer = new javax.swing.Timer(500
				, new java.awt.event.ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean stop = search.step();
				if (stop)
				{
					search.finalStep();
					timer.stop();
				}
				repaint();
			}
			
		});
		
		timer.start();
		this.repaint();
	}
	
	public void paintComponent(java.awt.Graphics g)
	{
		super.paintComponent(g);
		int[] ends = search.getEnds();
		for (int i = 0; i < array.length; i++)
		{
			
			if (i < ends[0] || i > ends[1])
			{
				g.setColor(java.awt.Color.RED);
				g.fillRect(this.getWidth()/2 + i*10,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
			}
			
			else
			{
				g.setColor(Color.BLACK);
				g.drawRect(this.getWidth()/2 + i*10,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
			}
			
		}
		
		if (search.getFinalStep())
		{
			
			if (search.getFound())
			{
				g.setColor(java.awt.Color.GREEN);
				g.fillRect(this.getWidth()/2 + search.getMid()*10,this.getHeight()/2 - (array[search.getMid()] * 10), 10, array[search.getMid()] * 10);
				g.setColor(java.awt.Color.RED);
				for (int i = 0; i < array.length; i++)
				{
					if (i != search.getMid())
						g.fillRect(this.getWidth()/2 + i*10,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
				}
			}
			
			else
			{
				g.setColor(java.awt.Color.RED);
				g.fillRect(this.getWidth()/2 + search.getMid()*10,this.getHeight()/2 - (array[search.getMid()] * 10), 10, array[search.getMid()] * 10);
				for (int i = 0; i < array.length; i++)
				{
					g.fillRect(this.getWidth()/2 + i*10,this.getHeight()/2 - (array[i] * 10), 10, array[i] * 10);
				}
			}
		}
		
	}
	
	public static void main(String[]args)
	{
		int[] array = new int [20];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		BubbleSort.bubbleSort(array);
		
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.add(new BinarySearchFrame(array), java.awt.BorderLayout.CENTER);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
	}
}
