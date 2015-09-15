package calculator;

import java.util.Arrays;

public class FindSolution {
	
	private int[] array;
	private static String[] operations = new String[] {"*","-","+","/"};
	private static String[] operationCombinations;
	private static int[] orderCombinationsKey = new int [] {2,1};
	
	public FindSolution(int[] array)
	{
		this.array = array;
	}
	private void testCombinations()
	{
		java.util.List <String> list = new java.util.ArrayList <String> ();
		generateCombinations(list, 1, 3);
		findSolution();
	}
	
	private void findSolution()
	{
		for (int i = 0; i < operationCombinations.length; i++)
		{
			String operators = operationCombinations[i];
			for (int j = 0; j <= orderCombinationsKey[0]; j++)
			{
				for (int m = 0; m <= orderCombinationsKey[1]; m++)
				{
					 passValues(operators,j,m, array);	
				}
			}
		}
	}
	
	private void passValues(String operators, int first, int last, int [] values)
	{
		String firstOperation = operators.substring(first, first + 1);
		double firstOperand = values[first];
		double secondOperand = values[first + 1];
		
		java.util.List <Integer> list = new java.util.ArrayList <> ();
		for (int i = 0; i < values.length; i++)
		{
			if (i != first && i != first + 1)
			list.add(values[i]);
		}
		
		list.add(first, (int) FindSolution.evaluateExpression(firstOperand, secondOperand, firstOperation));
		Integer[] secondArray = list.toArray(new Integer [list.size()]);
		String secondOperators = "";
		for (int i = 0; i < operators.length(); i++)
		{
			if (i != first)
			{
				secondOperators += operators.substring(i, i+1);
			}
		}
		
		String secondOperation = secondOperators.substring(last, last + 1);
		double thirdOperand = secondArray[last];
		double fourthOperand = secondArray[last + 1];
		
		java.util.List <Integer> secondList = new java.util.ArrayList <> ();
		for (int i = 0; i < secondArray.length; i++)
		{
			if (i != last && i != last + 1)
			secondList.add(secondArray[i]);
		}
		
		secondList.add(last, (int) FindSolution.evaluateExpression(thirdOperand, fourthOperand, secondOperation));
		Integer[] thirdArray = secondList.toArray(new Integer [secondList.size()]);
		String thirdOperators = "";
		for (int i = 0; i < secondOperators.length(); i++)
		{
			if (i != last)
			{
				thirdOperators += secondOperators.substring(i, i+1);
			}
		}
		
		
	
		String thirdOperation = thirdOperators;
		double fifthOperand = thirdArray[0];
		double sixthOperand = thirdArray[1];
		
		if (FindSolution.evaluateExpression(fifthOperand, sixthOperand, thirdOperation) == 24)
			System.out.println(operators + " " + first + " " + last);
		 
		
//		String potential = "((" + firstOperand + " " + firstOperation + " " + secondOperand +")"
//							+ thirdOperand + " " + secondOperation +  " " + fourthOperand +
//							+ fifthOperand + " " + thirdOperation + " " + sixthOperand;
	}
	
	private void generateCombinations(java.util.List <String> list, int order, int finalOrder)
	{
		java.util.List <String> combinations = list;
		int size = list.size();
		for (int i = 0; i < Math.pow(operations.length, order); i++)
		{
			String pattern = "";
			if (order != 1)
				pattern = combinations.get(i%size);
			if (i < size)
				combinations.set(i, pattern + operations[(int)(i/Math.pow(operations.length, order-1))]);
			else
				combinations.add(i, pattern + operations[(int)(i/Math.pow(operations.length, order-1))]);
		}
		
		size = list.size();
		if (order < finalOrder)
		{
			
			for (int i = 0; i < Math.pow(operations.length,order + 1) - Math.pow(operations.length,order); i++)
			{
				list.add(list.get(i%size));
			}
			
			generateCombinations(list,order + 1, finalOrder);
		}
		
		operationCombinations = list.toArray(new String [0]);
		System.out.println(Arrays.toString(operationCombinations));
		System.out.println(Arrays.toString(operationCombinations).length());
	}
	
	
	
	public static double evaluateExpression(Double a, Double b, String operator)
	{
		Double first = a;
		Double second = b;
		
		if (operator.equals("+"))
			return first + second;
		if (operator.equals("-"))
			return first - second;
		if (operator.equals("*"))
			return first * second;
		else
			return first/second; 
	}
	
	public static void main (String[]args)
	{
		FindSolution solution = new FindSolution (new int [] {4,15,4,7});
		solution.testCombinations();
	}
	
}
