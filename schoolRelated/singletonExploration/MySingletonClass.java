package singletonExploration;

public final class MySingletonClass 
{

	private static MySingletonClass instance = null;
	private static String ID = "fool";
	
	private MySingletonClass(String ID)
	{
		this.ID  = ID;
	}
	
	public static MySingletonClass getSingleton()
	{
		if (instance == null)
		{
			instance = new MySingletonClass("No fool");
			return instance;
		}
		else
		{
			return instance;
		}
	}
	
	public static void doMath()
	{
		System.out.println(1+1);
	}
	
	public String getID()
	{
		return ID;
	}
	
}
