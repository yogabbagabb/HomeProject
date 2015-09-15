package chap14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerDetecter {
	
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[]args)
	{
		try{
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			System.out.println("The sumw as possible and is " + (x+y));
		}
		
		catch (InputMismatchException ex)
		{
			System.out.println("InputMismatch detected. Go to hell");
		}
	}
	
	
}
