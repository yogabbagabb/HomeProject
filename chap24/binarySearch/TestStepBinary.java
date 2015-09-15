package binarySearch;

import java.util.Arrays;

public class TestStepBinary {

	public static void main (String[]args)
	{
		int[] array = new int [100];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * array.length);
		}
		BubbleSort search = new BubbleSort();
		search.bubbleSort(array);
		
		StepBinarySort sort = new StepBinarySort(array,array[4]);
		java.util.Timer timer = new java.util.Timer();

		timer.schedule(new java.util.TimerTask()
		{

			@Override
			public void run() {
				boolean stop = sort.step();
				int[] array = sort.getArray();
				System.out.println(Arrays.toString(array));
				System.out.println(sort.getMid());				
				if (stop)
				{
					boolean exists = sort.finalStep();
					if (exists)
					{
						System.out.println(sort.getMid() + " is the position");
						timer.cancel();
					}
					else
					{
						System.out.println("Non-existent");
						timer.cancel();
					}
				}
			}
			
		},0,50);

		
	}

}
