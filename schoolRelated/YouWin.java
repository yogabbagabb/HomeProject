
public class YouWin {

	
	public static void main (String[]args)
	{
		java.util.Scanner stdin = new java.util.Scanner (System.in);
		String word = stdin.next().toLowerCase();
		if (word.substring(0, 1).equals(word.substring(word.length()-1)))
		{
			System.out.println("You Win");
		}
		else
		{
			System.out.println("You lose");
		}
	}
}
