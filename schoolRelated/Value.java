public class Value
{
	
	private int value;
	boolean wasModified;
	boolean usedParameter;
	private int previousValue;
	
	public Value(int value)
	{
		this.value = value;
		usedParameter = true;
	}
	
	public Value()
	{
		
	}
	
	public void setVal(int val)
	{
		previousValue = value;
		this.value = val;
		wasModified = true;
	}
	
	public boolean wasModified()
	{
		return wasModified;	
	}
	
	public int getVal()
	{
		if (wasModified())
			return previousValue;
		
		if (usedParameter)
			return value;

		return 0;
	}
	
	public static void main (String[]args)
	{
		Value val = new Value (0);
		val.setVal(10);
		System.out.println(val.getVal());
		
		val.setVal(3);
		System.out.println(val.getVal());
	}
		
}