package exceptionsPlayAround;

public class Caller {

	public Caller() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void caller()
	{
		try{
		receiver();
		
		}
		
		catch(MyCheckedException e)
		{
			
		}
	}
	
	public static int callerTwo()
	{
return 2 ;
	}
	
	public void receiver() throws MyCheckedException
	{
		throw new MyCheckedException("");
	}
	
	public static void main (String[]args)
	{
		System.out.println(Caller.callerTwo());
	}

}
