import java.util.Arrays;


public class PossibleError {

	
	public static void main (String[]args)
	{
		int [] array = new int [] {1,2,3,4,5,5,6};
		for (int i = 0; i < array.length; i++)
		{
			int temp = array[i];
			array[i] = array[array.length -1 - i];
			array[array.length - 1 - i] = temp;
		}
		
		System.out.println(Arrays.toString(array));
		
		
	}
}
