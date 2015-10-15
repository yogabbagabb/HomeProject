import java.util.Arrays;


public class Tester {
	
	public static void main (String[]args)
	{
		
		for (int i = 0; i < 10; i++)
		{
			System.out.printf("%20.2f%n", 4.5678);
			// % SIGNALS A PATTERN
			// F SIGNALS A FLOAT, D AN INTEGER
			// %N IS JUST A CONVENTIONF FOR A NEWLINE
			// 20 signals width
			// . indicates precisin
			// normally right justified
			// unless you add a - before the field width value
			// in which case we're left justified
		}
		
		int a = 4;
		
		int x = (a == 4)?  2:  Tester.getThis();
		
	}
	
	public static int getThis()
	{
		return 2;
	}
	
	public static int  doThis()
	{
		int a = 4;
		return (a == 4)?  2:  Tester.getThis();
		// It is possible to ingreate a method into a ternary operator, this shows.
		
	}
	}

}
