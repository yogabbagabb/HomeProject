package displayFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

import myBinaryTree.HuffmanCode;


public class Display {

	public Display() {
		// TODO Auto-generated constructor stub
	}
	
	public static String collectFile(File file) throws FileNotFoundException
	{
		Scanner sys = new Scanner (file);
		String output = "";
		
		while (sys.hasNextLine())
		{
			output += sys.nextLine();
			output += "\n";
		}
		sys.close();
		return output;
	}
	
	public static <K,V> void printMap(java.util.Map <K,V> tree)
	{
		java.util.Set<Map.Entry<K, V>> entries = tree.entrySet();
		
		for (Map.Entry<K, V> entry: entries)
		{
			if (entry.getKey().equals(" "))
			{
				System.out.println("Dected");
				System.out.println("[" + "space" + "," + entry.getValue() + "]");
			}
				
			if (entry.getKey().equals("\n"))
			{
				System.out.println("[" + "\"\\n\"" + "," + entry.getValue() + "]");
			}
			else
				System.out.println("[" + entry.getKey() + "," + entry.getValue() + "]");
		}
	}
	
	public static void main (String[]args)
	{
		String out = "";
		try
		{

		Path homeDir = Paths.get(System.getProperty("user.home"));
		Path secondDir = homeDir.resolve("Documents//Senior Year//16Outline.txt");
		
		out = Display.collectFile(secondDir.toFile());
		}
		
		catch (java.io.FileNotFoundException e)
		{
			
		}
		
		HuffmanCode.getEncoding(out);
		
		Display.printMap(HuffmanCode.getFreqMap());
		System.out.println("___");
		Display.printMap(HuffmanCode.getEncoding());
		
		
	}
	
	

}
