package chap14;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExploreNextLine {

	public static void main (String[]args) throws FileNotFoundException
	{
		
		Scanner input = new Scanner (new File ("cop.txt"));
		while(input.hasNext())
		{
			String s = input.nextLine();
			System.out.println(s);
		}
		
		input.close();
	}
	
}
