package calculator;

import java.util.*;

public class Calculator {
	

	
	public static void calculate(String[] args, Stack<String> operators, Stack<String> operands)
	{
		
		String arg = convertStringArrayToString(args);
		args = arg.split("");
		
		final String[] parentheses = new String[] {"(",")"};
		final String[] primaryOperands = new String[] {"*","/"};
		final String[] secondaryOperands = new String[] {"+","-"};
		
		java.util.ArrayList <Integer> leftPar = new java.util.ArrayList <> ();
		java.util.ArrayList <Integer> rightPar = new java.util.ArrayList <> ();
		
		for (int i = 0 ; i < args.length; i++)
		{
			if (args[i].equals("("))
				leftPar.add(i);
			
			if (args[i].equals(")"))
				rightPar.add(i);
		}
		
		
		int outerLeft, outerRight;
		
		for (int i = 0; i < leftPar.size(); i++)
		{
			
			try
			{
				outerLeft = leftPar.get(i);
			}
			
			catch(IndexOutOfBoundsException e)
			{
				outerLeft = args.length;
			}
			
			while(outerLeft < args.length)
			{
				int[] output = Calculator.findMatch(outerLeft, args, leftPar, rightPar);
				outerRight = output[0];
				
				if (outerRight != outerLeft)
				{
					String[] newArgs = new String [outerRight - outerLeft - 1];
					int n = 0;
					for (int j = outerLeft + 1; j < outerRight; j++)
					{
						newArgs[n] = args[j];
						++n;
					}	
					
					System.out.println(Arrays.toString(newArgs));
					Calculator.calculate(newArgs, operators, operands);
					outerLeft = output[1];
				}
			}
		}
		
	}
	
	private static String convertStringArrayToString(String[] strArr)
	{
        StringBuilder sb = new StringBuilder();
        for(String str : strArr) sb.append(str);
        return sb.toString();
    }
	
//	public static String[] findOperators(String[] args, int index)
//	{
//		
//	}
//	
	public static int[] findMatch(int leftPar, String[] args, java.util.List<Integer> left, java.util.List <Integer> right)
	{
		
		int[] keys = new int[] {leftPar, args.length};
		
		int firstRight;
		
		for (int value: right)
		{
			if (value > leftPar)
			{
				firstRight = value;
				
				int numLeft = 0;
				int numRight = 0;
				
				for (int leftValue: left)
				{
					if (leftValue > leftPar && leftValue < firstRight)
						++numLeft;
				}
				
				for (int rightValue: right)
				{
					if (rightValue > leftPar && rightValue < firstRight)
						++numRight;
				}
				
				if (numLeft == numRight)
				{
					keys[0] = firstRight;
					
					for (int leftValue: left)
					{
						if (leftValue > firstRight)
						{	keys[1] = leftValue;
							break;
						}
					}
						
				}
				
			}
		}
		
		return keys;
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Stack<String> operators = new Stack<>();
		Stack <String> operands = new Stack<>();
		calculate(args,operators,operands);
		
	}

}
