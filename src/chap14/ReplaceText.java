package chap14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {

	/**
	 * 
	 * 1) make a directory and add a file to it
	 * 2) make a file on the system
	 * 3) smart way of changing the text
	 * 
	 * 
	 */
	
	public static void main (String[]args)
	{
		if (args.length != 4)
			System.out.println("Format: oldFile, newFile, oldString, newString");
		
		File firstFile = new File (args[0]);
		File secondFile = new File (args[1]);
		
		if (!firstFile.exists())
			System.exit(1);
		
		if (secondFile.exists())
			System.exit(2);
		Scanner input;
		PrintWriter output;
		try
		{
		 input = new Scanner (firstFile);
		 output = new PrintWriter (secondFile);
		while(input.hasNext())
		{
			String s = input.nextLine();
			System.out.println(s);
			output.write(s.replaceAll(args[2], args[3]));
		}
		input.close();
		output.close();
		}
		catch (IOException e)
		{
			System.out.println("Exception");
			e.printStackTrace();
			
		}
		
			
		
		
		
	}
}
