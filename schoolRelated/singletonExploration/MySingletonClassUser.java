package singletonExploration;

public class MySingletonClassUser {

	public static void main(String[]args)
	{

		MySingletonClass.doMath();
		MySingletonClass instance = MySingletonClass.getSingleton();
		System.out.println(instance.getID());
		
	}
}
