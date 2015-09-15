package stackOverflow;

public enum MyEnum implements Comparable<MyEnum> {

	One(1), Two(2);
	
	private int val;
	
	private MyEnum (int val)
	{
		this.val = val;
	}
	
	
	public Class<MyEnum> getDeclarfingClass()
	{
		return MyEnum.class;
	}
	

}


