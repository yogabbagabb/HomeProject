package binarySearch;

import java.util.Arrays;

public class TestStepBubbles {
	

	public static void main (String[]args)
	{
		int[] array = new int [6];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		
		StepBubbleSort sort = new StepBubbleSort(array);
		java.util.Timer timer = new java.util.Timer();
		System.out.println(Arrays.toString(array));

		timer.schedule(new java.util.TimerTask()
		{

			@Override
			public void run() {
				boolean stop = sort.step();
				int[] array = sort.getArray();
				System.out.println(Arrays.toString(array));
				System.out.println(sort.geti());
				System.out.println(sort.getChanged());
				
				if (stop)
				{
					
					timer.cancel();
				}
			}
			
		},0,50);

		
	}
}
