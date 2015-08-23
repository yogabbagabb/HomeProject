package ex23_3.chapter23;

import java.util.*;
import java.io.*;

public class CountNoComments {
  public static void main(String[] args) throws Exception {  
  

    File file = new File("chap12/examples/FlowLayoutExample.java");
    if (file.exists()) {
      System.out.println("The number of keywords in "   
        + " is " + countKeywords(file));
    }
    else {
      System.out.println("File " + " does not exist");
    }    
  }

  public static int countKeywords(File file) throws Exception {  
    // Array of all Java keywords + true, false and null
    String[] keywordString = {"abstract", "assert", "boolean", 
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int", 
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", 
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

    Set<String> keywordSet = 
      new HashSet<String>(Arrays.asList(keywordString));
    int count = 0;    

    Scanner input = new Scanner(file);
    boolean comment = false;
    
    while (input.hasNextLine()) 
    {
      String word = input.nextLine();
      String[] array = word.split(" ");
      String firstTerm = CountNoComments.returnNextOperator(array, 0);
      
      if (firstTerm.contains("//") || firstTerm.contains("/**") || firstTerm.contains("*"))
    	  comment = true;
      else
    	  comment = false;
      
      for (int i = 0; i < array.length; i++)
      {
      if (keywordSet.contains(array[i]) && comment == false) 
        count++;
      
      System.out.print(array[i] + " ");
      }
      
      System.out.println();
    }

    return count;
  }
  
  private static String returnNextOperator(String[] array, int index)
	{
		for (int i = index; i < array.length; i++)
		{
			if (!array[i].equals(" ") && !array[i].equals("") && !array[i].equals("\t"))
			{
				return array[i];
				             
			}
		}
		
		return "";
	}
}
