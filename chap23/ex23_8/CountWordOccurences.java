package ex23_8;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class CountWordOccurences {
  public static void main(String[] args) throws FileNotFoundException {
    // Set text in a string
    String text = "chap12/examples/FlowLayoutExample.java";
    java.util.Scanner scan = new java.util.Scanner (new java.io.File (text));
    scan.useDelimiter("[ \n\t\r.,;:!?(){}]");

    // Create a TreeMap to hold words as key and count as value
    Map<String, Integer> map = new TreeMap<String, Integer>();

    
    while (scan.hasNext())
	  {
		  String key = scan.next().toLowerCase();
		  
	      if (key.length() > 0) {
	        if (!map.containsKey(key)) {
	          map.put(key, 1);
	        }
	        
	        else {
	          int value = map.get(key);
	          value++;
	          map.put(key, value);
	        }
	      }
	  
	  }

    // Get all entries into a set
    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    java.util.List <WordOccurence> list = new java.util.ArrayList <> ();
    // Get key and value from each entry
    
    for (Map.Entry<String, Integer> entry: entrySet){
      System.out.println(entry.getKey() + "\t" + entry.getValue());
      list.add(new WordOccurence(entry.getKey(),entry.getValue()));
    }
    
    Collections.sort(list);
    System.out.println(list.toString());
    
  }
}