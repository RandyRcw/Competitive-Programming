package software;

import java.util.Scanner;
import java.util.Stack;

public class SaintAnselm2 {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter string:");
		String str = scan.nextLine();
		
		System.out.println(parantheses(str));
		
//		Stack<Character> stack = new Stack<Character>();
//		
//		if(str.isEmpty())
//			System.out.println("true");
//		
//		for(int i = 0; i < str.length(); i++) 
//		{
//			System.out.println("Initial stack: " + stack);
//			char current  = str.charAt(i);
//			
//			if(current == '{' || current == '(' || current == '[')
//			{
//				stack.push(current);
//			}
//			
//			if(current == '}' || current == ')' || current == ']')
//			{
//				if(stack.isEmpty())
//					System.out.println("false");
//				
//				char last = stack.peek();
//				if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
//				{
//					stack.pop();
//				}
//				else
//				{
//					System.out.println("false");
//				}
//			}
//			System.out.println("Final stack: " + stack);
//		}
//		System.out.println(stack.isEmpty()); 	
	}
	
	public static boolean parantheses(String str) 
	{
		Stack<Character> stack = new Stack<Character>();
		
		if(str.isEmpty())
			return true;
		
		for(int i = 0; i < str.length(); i++) 
		{
			char current  = str.charAt(i);
			
			if(current == '{' || current == '(' || current == '[')
			{
				stack.push(current);
			}
			
			if(current == '}' || current == ')' || current == ']')
			{
				if(stack.isEmpty())
					return false;
				
				char last = stack.peek();
				if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
				{
					stack.pop();
				}
				else
				{
					return false;
				}
			}
		}
		return stack.isEmpty();	
	}
}
