package ex23_7.chapter23;

public class WordOccurence implements Comparable<WordOccurence>{

	String word;
	int value;
	
	public WordOccurence(String a, int b)
	{
		word = a;
		value = b;
	}
	public int compareTo(WordOccurence o) {
		return  this.word.compareTo(o.word);
	}
	
	@Override
	public String toString()
	{
	
		return "Word is " + word + "; Value is " + value;
	}
	
	
	

}
