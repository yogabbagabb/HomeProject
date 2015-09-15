package chap14;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Ex14_1 {

	public static void main (String[]args)
	{
		File file = new File (args[1]);
		if (!file.exists())
		{
			System.out.println("File does not exist");
			System.exit(0);
		}

		try{

			Scanner scan = new Scanner (file);
			String s = "";
			while(scan.hasNext())
			{
				s += scan.nextLine().replaceAll(args[0], "");
			}
			
			scan.close();
			
			PrintWriter print = new PrintWriter (file);
			print.write(s);
			print.close();
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
