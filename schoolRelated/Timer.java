
public class Timer {

	
	public static void main (String[]args)
	{
		StringBuilder b = new StringBuilder();
		
		System.out.println(System.currentTimeMillis());
		
		for (int i = 0; i < 1000; i++)
			b.append("!");
		System.out.println(System.currentTimeMillis());
		
		
		System.out.println(System.currentTimeMillis());
		String s = "";
		for (int i = 0; i < 1000; i++)
			s += "!";
		System.out.println(System.currentTimeMillis());
	}
}

