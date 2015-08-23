package cS23_4;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountingKeywords {
	
	static String[] keywordString = {"abstract", "assert", "boolean",
			 "break", "byte", "case", "catch", "char", "class", "const",
			 "continue", "default", "do", "double", "else", "enum",
			 "extends", "for", "final", "finally", "float", "goto",
			 "if", "implements", "import", "instanceof", "int",
			 "interface", "long", "native", "new", "package", "private",
			 "protected", "public", "return", "short", "static",
			 "strictfp", "super", "switch", "synchronized", "this",
			 "throw", "throws", "transient", "try", "void", "volatile",
			 "while", "true", "false", "null"};
	
	public static void main(String[]args)
	{
		File file = new File ("chap12/examples/FlowLayoutExample.java");
		System.out.println(file.exists());
		System.out.println(countOccurences(file));		
	}
	
	
	public static int countOccurences(File file)
	{
		
		int n = 0;

		try{
		Scanner scan = new Scanner(file);
		java.util.Set <String> set = new java.util.HashSet <> ();
		java.util.Set setTwo = new java.util.HashSet <> (set);
			while (scan.hasNext())
			{
				String next = scan.next();
				System.out.println(next);
				if (setTwo.contains(next) && !set.contains(next))
				{
					set.add(next);
					n++;
				}
			}
			
			
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return n;
	
		
	}

}
