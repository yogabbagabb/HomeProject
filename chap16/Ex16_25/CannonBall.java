package Ex16_25;

public class CannonBall {

	
	private int radius;
	private double xPos,yPos,xSpeed, ySpeed;
	
	public CannonBall(int a, double f, double g, double d, double e)
	{
		radius = a;
		xPos = f;
		yPos = g;
		xSpeed = d;
		ySpeed = e;
	}
	
	
	public double getX()
	{
		return xPos; 
	}
	
	public double getY()
	{
		return yPos;
	}
	
	public int getR()
	{
		return radius;
	}
	
	public void update()
	{
		xPos += xSpeed;
		yPos += ySpeed;
	}
	
	
	
}
