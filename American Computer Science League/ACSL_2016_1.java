import java.util.Scanner;

// Randy Wang
// Nashua High School North
// Senior-3

public class ACSL_2016_1 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter opponent's lead card and the 5 cards held by the dealer, separated by commas. The output will follow each input.");
		
		String input1 = scan.next();  //collect inputs and print outputs
		cardPlayed(input1);
		String input2 = scan.next(); 
		cardPlayed(input2);
		String input3 = scan.next(); 
		cardPlayed(input3);
		String input4 = scan.next(); 
		cardPlayed(input4);
		String input5 = scan.next(); 
		cardPlayed(input5);
		
	}
	
	public static void cardPlayed(String input)
	{
		String[] cards = input.split(",");  //converts input into array of strings
		String[] letterCards = {"A", "T", "J", "Q", "K"};  //array of special suits
		int[] letterValues = {1, 10, 11, 12, 13};    //array of special ranks
		int[] cardValues = new int[6];  //array of card values
		String[] cardSuits = new String[6];  //array of card suits
		int k = 0;
		
		for(int i = 0; i < 6; i++)  //fill array of card values and suit values
		{
			cardSuits[i] = cards[i].substring(1,2);  //array of just suit values
			
			for(int j = 0; j < 5; j++)
			{
				if(cards[i].substring(0, 1).equals(letterCards[j]))
				{
					cardValues[i] = (letterValues[j]);  //converts a letter value(king, queen etc.) into a number
					k = 1;
				}
			}
			if(k != 1)
			{
				cardValues[i] = Integer.parseInt(cards[i].substring(0,1));  //converts string number into int number
			}
			k = 0;
		}
		
		int[] sameSuit = new int[6];  //array of card values with same suit
		
		for(int i = 0; i < 6; i++)
		{
			if(cardSuits[0].equals(cardSuits[i]))
			{
				sameSuit[i] = cardValues[i];
				k++;
			}
		}
		
		int[] newSuit = new int[5];
		boolean flag = true;
		int scenario = 0;
		
		if(k > 1)
		{
			for(int i = 0; i < 6; i++)
			{
				if(sameSuit[0] < sameSuit[i])  
				{
					newSuit[i-1] = sameSuit[i];  //fills in array of card values that are of higher rank 
					flag = false;
					scenario = 1;
				}
				
			}
			if(flag)
			{
				for(int i = 1; i < 6; i++)
				{
					newSuit[i-1] = sameSuit[i];  //fills in array of card values that are of lower rank
				}
				scenario = 1;
			}
		}
		else
		{
			for(int i = 0; i < 5; i++)
			{
				newSuit[i] = cardValues[i+1];  //fills in array of card values, excluding the opponent value
			}
			scenario = 2;
		}

		int location = 0;
		
		switch(scenario)
		{
			case 1:  //dealer has card(s) of same suit
			{
				int low = 13;
				for(int i = 0; i < 5; i++)
				{
					if(newSuit[i] != 0 && newSuit[i] <= low)
					{
						low = newSuit[i];
						location = i + 1; //correspond lowest value with card
					}
				}
				break;
			}
			case 2:  //dealer does not have cards of same suit
			{
				int low = 14;
				for(int i = 0; i < 5; i++)
				{
					if(newSuit[i] < low)
					{
						low = newSuit[i];
						location = i + 1; //correspond lowest value with card
					}
					if(newSuit[i] == low) //event of tie
					{
						if(cardSuits[i+1].compareTo(cardSuits[location]) < 0) //order of suit precedence ascending
						{
							low = newSuit[i];
							location = i + 1; //correspond lowest value with card
						}
					}
				}
				break;
			}
		}
		
		System.out.println(cards[location]);  //print card played
	}

}
