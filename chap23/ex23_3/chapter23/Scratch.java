package ex23_3.chapter23;

import java.util.Arrays;

public class Scratch {

	
	public static void main (String[]args)
	{
		String word = "Hello my name is Jules   Vernes";
		
		String[] array = word.split(" ");
		
		System.out.println(Arrays.toString(array));
	}
}

