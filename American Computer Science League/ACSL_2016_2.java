import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// Randy Wang
// Nashua High School North
// Senior-3

public class ACSL_2016_2 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 5 lines of input, each line containing a string of digits at least 1 but no more than 32 in length.");
		
		String input1 = scan.next();  //collect inputs and print outputs
		ascendingString(input1);
		String input2 = scan.next();
		ascendingString(input2);
		String input3 = scan.next();
		ascendingString(input3);
		String input4 = scan.next();
		ascendingString(input4);
		String input5 = scan.next();
		ascendingString(input5);

	}
	
	public static void ascendingString(String input)
	{
		String[] numbers = input.split("");  //convert string input into array
		ArrayList<String> digits = new ArrayList<String>(numbers.length);  //create arraylist of strings
		int previous = -10, current, i, j;
		String sequence = "";  //sequence of numbers
		
		for(i = 0; i < numbers.length; i++)  //fill arraylist
		{
			digits.add(numbers[i]);
		}
		
		String number = "";   //string representation of number
		boolean flag = true;
				
		do
		{
			i = 0;
			number = digits.get(0);   //set number equal to first element
			current = Integer.parseInt(number);  //integer representation of number
			
			if(current > previous)  //number is greater than the previous number
			{
				if(current != 0)  //check to make sure first number is not zero
				{
					sequence += number + " ";
				}
				
			}
			else
			{
				while(current <= previous)  //if the number is not greater than the previous
				{
					i++;
					if(i < digits.size())  //remaining digits can form number
					{
						number += digits.get(i);  //combine number
						current = Integer.parseInt(number);
					}
					else  //remaining digits cannot form larger number
					{
						current = previous + 1;  //exit loop
						flag = false;  
						
					}
				}
				if(flag)  //does not add to sequence if the remaining digits cannot form larger number
				{
					if(number.charAt(0) == '0')  //number starting with zero does not show leading zero
					{
						j = 0;
						while(number.charAt(j) == '0')
							{
								j++;
							}
						sequence += number.substring(j) + " ";
					}
					else
					{
						sequence += number + " ";
					}
				}
			}
			
			digits.subList(0, number.length()).clear();  //remove digit(s) used in sequence from arraylist
			previous = current;
			Collections.reverse(digits);  //reverse arraylist of digits

		}
		while(digits.size() > 0);  //finished when arraylist is empty
		
		System.out.println(sequence); 
	}

}
