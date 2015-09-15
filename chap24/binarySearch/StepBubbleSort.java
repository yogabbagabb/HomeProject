package binarySearch;

public class StepBubbleSort {
	
	private boolean changed;
	private int i;
	private int[] array;
	
	public StepBubbleSort(int[]array)
	{
		if (array != null)
		{
			this.array = array;
			i = 0;
			changed = false;
		}
	}
	
	public boolean step()
	{
		if(i < array.length - 1)
		{
			if (array[i+1] < array[i])
			{
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				changed = true;
			}
		}
		
		if(i >= array.length - 1)
		{
			if (changed)
			{
				reset();
				return false;
			}
			else
			{
				return true;
			}
		}
		
		i++;
		return false;

	}
	
	public boolean getChanged()
	{
		return changed;
	}
	
	public int geti()
	{
		return i;
	}
	public int[] getArray()
	{
		int[] array = this.array.clone();
		return array;
	}
	public void reset()
	{
		i = 0;
		changed = false;
	}
	
	
}
