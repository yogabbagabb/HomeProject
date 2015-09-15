package calculator;

import java.util.Stack;

public class RevisedCalculator {

	public static void calculate(String[] args, Stack<String> operators, Stack<String> operands)
	{

		String arg = RevisedCalculator.convertStringArrayToString(args);
		args = RevisedCalculator.individualizePar(arg);
		arg = RevisedCalculator.convertStringArrayToString(args);
		args = arg.split(" ");
		
		
		
		
		for (int i = 0; i < args.length; i++)
		{
			
			if(args[i].equals(" ") || args[i].equals(""))
				continue;
			
			if(args[i].equals("("))
			{
				operators.push(args[i]);
			}
			
			
			else if (args[i].equals("*") || args[i].equals("/"))
			{
				String nextOperand = RevisedCalculator.returnNextOperator(args, i+1);
				if(nextOperand.equals("("))
				{
					operators.push(args[i]);
					continue;
				}
				
				String prevOperand = operands.pop();
				String operator = args[i];
				
				operands.push("" + RevisedCalculator.evaluateExpression(prevOperand,nextOperand,operator));
				i = RevisedCalculator.returnNextOperatorIndex(args, i + 1);
			}
			
			
			
			
			else if (args[i].equals("+") || args[i].equals("-"))
			{
				operators.push(args[i]);
			}
			
			else if (args[i].equals(")"))
			{
				String firstOperand;
				String operator;
				String secondOperand;
				
				operator = operators.pop();
				while (!operator.equals("("))
				{
					firstOperand = operands.pop();
					secondOperand = operands.pop();
					operands.push("" + RevisedCalculator.evaluateExpression(secondOperand,firstOperand,operator));
					operator = operators.pop();
				}
				
				// check for / or *
				
				if (!operators.isEmpty()){
					operator = operators.pop();
					if (operator.equals("*") || operator.equals("/"))
					{
						firstOperand = operands.pop();
						secondOperand = operands.pop();
						operands.push("" + RevisedCalculator.evaluateExpression(secondOperand,firstOperand,operator));
					}
					
					else
					{
						operators.push(operator);
					}
				}
					
			}
			
			else
			{
				operands.push(args[i]);
			}
				
			
		}
		
		 evaluateStack(operators, operands); 
		
	}
	
	public static double evaluateExpression(String a, String b, String operator)
	{
		Double first = Double.parseDouble(a);
		Double second = Double.parseDouble(b);
		
		if (operator.equals("+"))
			return first + second;
		if (operator.equals("-"))
			return first - second;
		if (operator.equals("*"))
			return first * second;
		else
			return first/second; 
	}
	
	
	public static void evaluateStack(Stack<String> operators, Stack<String> operands)
	{
	
		while(operands.size() != 1)
		{
			String firstOperand = operands.pop();
			String operator = operators.pop();
			String secondOperand = operands.pop();
			operands.push("" + RevisedCalculator.evaluateExpression(secondOperand,firstOperand,operator));
		}
		
		System.out.println(operands.pop());
	}
	
	private static String convertStringArrayToString(String[] strArr)
	{
        StringBuilder sb = new StringBuilder();
        for(String str : strArr) sb.append(str);
        return sb.toString();
    }
	
	private static String returnNextOperator(String[] array, int index)
	{
		for (int i = index; i < array.length; i++)
		{
			if (!array[i].equals("") && !array[i].equals(""))
			{
				return array[i];
				             
			}
		}
		
		return null;
	}
	
	private static int returnNextOperatorIndex(String[] array, int index)
	{
		for (int i = index; i < array.length; i++)
		{
			if (!array[i].equals("") && !array[i].equals(""))
			{
				return i;
				             
			}
		}
		
		return -1;
	}
	
	private static String[] individualizePar(String string)
	{
		java.util.List <String> list = new java.util.ArrayList <> ();
		
		for (int i = 0; i < string.length(); i++)
		{
			if (string.substring(i,i+1).equals("*")||
					string.substring(i,i+1).equals("+")||
					string.substring(i,i+1).equals("-")||
					string.substring(i,i+1).equals("/")||
					string.substring(i,i+1).equals("(")||
					string.substring(i,i+1).equals(")"))
			{
				list.add(" ");
				list.add(string.substring(i, i+1));
				list.add(" ");
			}
			
			else
			{
				list.add(string.substring(i,i+1));
			}
		
		}
		
		return list.toArray(new String[0]);
	}
	
	public static void main (String[]args)
	{
		Stack<String> operators = new Stack <> ();
		Stack<String> operands = new Stack <> ();
		
		RevisedCalculator.calculate(new String[]{"(2*4)-0.5+2-(2+(2/(2*2)))"}, operators, operands);
	}
	
}
