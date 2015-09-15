package chap14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex14_12 {

	public static void main(String[] args) {
		
		
		try{
			
		
		File file = new File (args[0]);
		if (!file.exists())
		{
			System.out.println("No such file");
			System.exit(1);
		}
		Scanner scan = new Scanner (file);
		
		String s = "";
		
		while (scan.hasNextLine())
		{
			String d = scan.nextLine();
			System.out.println(d.substring(d.length()-1));
			
			if (d.length() > 0 && d.substring(d.length()-1).equals(")")){
					s += d;
					System.out.println("It works");
					
					d = scan.nextLine();
					if (d.contains("{")){
						s += (" {");
					}
					
					else{
						s += "/n" + d;
					}
					
					
			}
			
			else if (d.length() == 0)	{
				s += "\n";
				
			}
			
			else{
				s += "\n" + d;
			}
		}
		
		scan.close();
		
		PrintWriter out = new PrintWriter (file);
		out.print(s);
		out.close();
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
