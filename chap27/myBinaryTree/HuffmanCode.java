package myBinaryTree;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;


public class HuffmanCode {
	
	private static TreeMap <String,Integer> freqMap  = new java.util.TreeMap<> ();
	private static HashMap <String, String> encodingMap  = new java.util.HashMap<> ();
	private static TreeNode<String> root;
	
	public static void countFrequency(String message)
	{
		for (int i = 0; i < message.length(); i++)
		{
			HuffmanCode.countLetter(message.substring(i,i+1));
		}
	}
	
	private static void countLetter(String letter)
	{
		if (freqMap.containsKey(letter))
		{
			freqMap.put(letter, freqMap.get(letter)+1);
		}
		else
		{
			freqMap.put(letter, 1);
		}
		
	}
	
	public static <K,V extends Comparable<? super V>> List<Entry<K,V>> orderMap(Map<K,V> map)
	{
		java.util.ArrayList <Entry<K,V>> list = new java.util.ArrayList <> (); 
		
		
		java.util.Iterator <Entry<K,V>> it = map.entrySet().iterator();
		while (it.hasNext())
		{
			list.add(it.next());
		}
		
		Collections.sort(list, new java.util.Comparator <Entry<K,V>> (){


			public int compare(Entry<K,V> o1, Entry<K,V> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		return list;
	}
	
	
	public static <K,V> void constructHuffmanTree(List <Map.Entry<String, V>> list)
	{
		if (list.size() > 0)
		{
			
			TreeNode<String> current = new TreeNode<String> (list.get(0).getKey());
			
			for (int i = 1; i < list.size(); i++)
			{
				TreeNode<String> right = new TreeNode<String> (list.get(i).getKey());
				TreeNode<String> top = new TreeNode<String> ("TOP");
				top.left = current;
				top.right = right;
				current = top;
			}
			
			if (!current.element.equals("TOP"))
			{
				TreeNode<String> top = new TreeNode<String> ("TOP");
				top.right = current;
				top.left = new TreeNode<String> ("TOP");
				root = top;
			}
			
			else
				root = current;
		}
		
		else
		{
			root = null;
		}
		
		
	}
	
	
	public static void breakLetters()
	{
		if (root != null)
		{
			encodingMap.put(root.right.element,"0");
			
			TreeNode<String> current = root.left;
			String zeroDepth = "0";
			while (current.left != null || current.right != null)
			{
				encodingMap.put(current.right.element, zeroDepth + "1");
				current = current.left;
				zeroDepth += "0";
			}
		}
		
	}
	
	public static String getBytes(String message)
	{
		String output = "";
		for (int i = 0; i < message.length(); i++)
		{
			output += encodingMap.get(message.substring(i, i+1));
		}
		
		return output;
	}
	
	public static TreeMap<String, Integer> getFreqMap()
	{
		return freqMap;
	}
	
	public static HashMap<String, String> getEncoding()
	{
		return encodingMap;
	}
	
	public static String getEncoding(String message)
	{
		HuffmanCode.countFrequency(message);
		List <Map.Entry<String, Integer>> list = HuffmanCode.orderMap(freqMap);
		HuffmanCode.constructHuffmanTree(list);
		HuffmanCode.breakLetters();
		return HuffmanCode.getBytes(message);
	}
	

}
