package chap14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PlayAround {
	
	public static void main (String[]args)
	{
		File file = new File ("bobo//bobo", "dojo");
		if (!file.exists())
		{
			System.out.println("Helo");
			file.mkdirs();
		}
		
		File file2 = new File (file, "this.txt");
			PrintWriter writer;
		try{
		writer = new PrintWriter(file2);
		writer.print("Helklo");
		System.out.println("another");
		writer.close();
		}
		
		catch(IOException e)
		{
			System.out.println("Exception detected");
			e.printStackTrace();
			System.exit(1);
		}
		
		
		
	}

}
