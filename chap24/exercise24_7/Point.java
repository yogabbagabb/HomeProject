package exercise24_7;

public class Point implements java.lang.Comparable<Point>
{
	
	private double x, y;
	
	public Point(double a, double b)
	{
		x = a;
		y = b;
	}
	
	public double findDistance(Point other)
	{
		return Math.sqrt(Math.pow(this.x - other.x,2) + Math.pow(this.y - other.y,2));
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}

	@Override
	public int compareTo(Point o) {
		
		final int SCALE = 100;
		
		double xDif = this.x - o.x;
		if (xDif != 0)
		{
			return (int)(xDif *SCALE);
		}
		
		else
		{
			return (int)(SCALE * (this.y - o.y));
		}
	}
	
	public boolean withinRange(Point another, double verticalDistance, double horizontalDistance)
	{
		if (Math.abs(this.x - another.x) <= horizontalDistance && Math.abs(this.y - another.y) <= verticalDistance)
		{
			return true;
		}
		else return false;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
}
