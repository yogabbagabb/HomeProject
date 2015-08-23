package ex23_1;

public class SetOperations {
	
	public static void main (String[]args)
	{
		java.util.Set <String> set = new java.util.HashSet <> ();
		set.add("George");
		set.add("Jim");
		set.add("J");
		
		java.util.Set <String> setTwo = new java.util.HashSet <> ();
		setTwo.add("Gj");
		setTwo.add("Jim");
		setTwo.add("J");
		
		set.retainAll(setTwo);
		System.out.println(set);
		set.addAll(setTwo);
		System.out.println(set);
		set.clear();
		System.out.println(set);
	}

}
