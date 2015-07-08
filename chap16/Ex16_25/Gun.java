package Ex16_25;

public class Gun {

	private int xBasePos, yBasePos, length;
	private double degree;
	
	public Gun (int a, int b, int c)
	{
		xBasePos = a;
		yBasePos = b;
		length = c;
		
		degree = 90.0;
	}
	
	
	public void regulateAngle()
	{
		if (degree <= 0)
			degree = 0;
		if (degree >= 180)
			degree = 180;
	}
	public void addDegree(double degree)
	{
		this.degree += degree;
		regulateAngle();
	}
	
	public int getX()
	{
		return xBasePos;
	}
	
	public int getY()
	{
		return yBasePos;
	}
	
	public double getTurretX()
	{
		return xBasePos - (length * Math.cos(Math.toRadians(degree)));
	}
	
	public double getTurretY()
	{
		return yBasePos - (length * Math.sin(Math.toRadians(degree)));
	}
	
	
}
