package chap14;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Ex14_23 {
	
	
	public static void main (String[]args)
	{
		
		try
		{
			
			URL site = new URL ("http://cs.armstrong.edu/liang/data/Scores.txt");
			Scanner scan = new Scanner (site.openStream());
			
			int count = 0;
			int sum = 0;
			while (scan.hasNext())
			{
				String num = scan.next();
				if (num.matches("[0-9]+"))
				{
					++count;
					sum += Integer.parseInt(num);
				}
				
				else
				{
					System.out.println("It: " + num);
				}
			}
			
			System.out.println(sum);
			System.out.println(sum/count);
		}
		
		catch(MalformedURLException e)
		{
			
		}
		
		catch(IOException e)
		{
			
		}
	}

}
