package ex23_8;

public class WordOccurence implements Comparable<WordOccurence>{

	String word;
	int value;
	
	public WordOccurence(String a, int b)
	{
		word = a;
		value = b;
	}
	public int compareTo(WordOccurence o) {
		return  this.value - o.value;
	}
	
	@Override
	public String toString()
	{
	
		return "Word is " + word + "; Value is " + value;
	}
	
	
	

}
