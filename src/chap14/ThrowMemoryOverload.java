package chap14;

public class ThrowMemoryOverload {

	public static void main(String[]args)
	{
		int sum = 0;
		int [] array = new int [20000];
		for (int num: array)
			sum += num;
	}
}
