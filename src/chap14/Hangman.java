package chap14;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Hangman {
	
	private static String chosen = "Aahan";
	private static ArrayList <String> choices = new ArrayList <String> ();
	private static Scanner input = new Scanner (System.in);
	
	public Hangman(String file) throws FileNotFoundException
	{
		Scanner scan = new Scanner (new File (file));
		ArrayList <String> words = new ArrayList <> ();
		while (scan.hasNext())
		{
			words.add(scan.next());
		}
		
		chosen = words.get((int) ((words.size()) * Math.random()) );
		scan.close();
	}
	
	private static void getLetter()
	{
		System.out.println("Enter a letter: ");
		choices.add(input.next());
	}
	
	private static void giveDisplay()
	{
		
		for (int i = 0; i < chosen.length(); i++){
		getLetter();
		giveString();
		System.out.println();
		}
	}
	
	private static void giveString()
	{
		String s = "";
		
		for (int i = 0; i < chosen.length(); i++)
		{
			boolean notThere = true;
			
			for (int j = 0; j < choices.size(); j++)
			if (chosen.substring(i,i+1).equals(choices.get(j)))
			{	s += choices.get(j);
				notThere = false;
				outer: break;
			}
			
			if (notThere)
				s += "*";
		}
		
		System.out.print(s);

	}
	
	public static void main (String[]args) throws FileNotFoundException	
	{

		Hangman body = new Hangman(args[0]);
		
		try{
		Hangman.giveDisplay();
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}
	

}
