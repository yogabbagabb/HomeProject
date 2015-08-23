package myBinaryTree;

public class Number extends java.lang.Number implements Comparable<Number> {

	
	private int i;
	
	public Number(int i) 
	{
		this.i = i;
	}

	@Override
	public int compareTo(Number o)
	{
		return this.i = o.i;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return (int)i;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long)i;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float)i;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return (double)i;
	}
	
	public String toString()
	{
		return intValue() + "";
	}

	
	
}
