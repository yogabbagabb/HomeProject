package exercise24_7;

public class YComparator implements java.util.Comparator <Point>{

	final int SCALE = 100;
	
	@Override
	public int compare(Point o1, Point o2) {	
		return (int)(SCALE*(o1.getY() - o2.getY()));
	}
	

}
