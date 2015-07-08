package chap16;

public class PlayAround16_4 {

	private static String bobo;
	

	public PlayAround16_4()
	{
	
		bobo = "you";
	}
	
	
	private static class B
	{
			
		private String getYou()
		{
			return bobo;
		}
	
	}
	
	
	public static void main(String[]args)
	{
		PlayAround16_4 obj = new PlayAround16_4();
		PlayAround16_4.B obj2 = new PlayAround16_4.B ();
		System.out.println("experiment1:" + obj.bobo);
		System.out.println("experiment1:" + obj2.getYou());
		
	}
		
		
	
}
