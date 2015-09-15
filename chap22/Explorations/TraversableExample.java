package Explorations;
import java.util.*;
public class TraversableExample {

	public static void main(String[] args) {
		
		List <String> list = Arrays.asList("Hello","No","Go","A","S");
		java.util.ListIterator<String> it = list.listIterator(list.size());
		
		System.out.println(it.previousIndex());
		
		while (it.hasPrevious())
		{
			System.out.println("Test");
			System.out.print(it.previous() + " ");
		}
		
		System.out.println(Math.random());

	}

}
