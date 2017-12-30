import java.util.Scanner;

// Randy Wang
// Nashua High School North
// Senior-3

public class ACSL_2016_3 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the initial board configuration in hexadecimal, followed by 5 more board configurations after a tile has been pressed on each.");
		
		String input1 = scan.nextLine();			//collect inputs and print outputs
		String input2 = scan.nextLine();
		tilePressed(createBoard(input1), createBoard(input2));
		String input3 = scan.nextLine();
		tilePressed(createBoard(input2), createBoard(input3));
		String input4 = scan.nextLine();
		tilePressed(createBoard(input3), createBoard(input4));
		String input5 = scan.nextLine();
		tilePressed(createBoard(input4), createBoard(input5));
		String input6 = scan.nextLine();
		tilePressed(createBoard(input5), createBoard(input6));
	}
	
	public static String binaryConvert(String hex)  //takes in a single hex digit and converts it to a 4 bit binary string
	{
		int hexNumber = Integer.parseInt(hex, 16);
		String binary = Integer.toBinaryString(hexNumber);
		
		if(binary.length() < 4)  //leading zeros
		{
			if(binary.length() == 3)
			{
				binary = "0" + binary;
			}
			if(binary.length() == 2)
			{
				binary = "00" + binary;
			}
			if(binary.length() == 1)
			{
				binary = "000" + binary;
			}
			if(binary.length() == 0)
			{
				binary = "0000" + binary;
			}
		}
		return binary;
	}
	
	public static int[][] createBoard(String input)	  //create a 2-D array of ints (the board) given hexadecimal coordinates
	{
		String[] hexCoordinates = input.split(" ");
		int[][] board = new int[8][8];
		int hexArray = 0, hexGroup = 0, hexDigit = 0;
		
		for(int i = board.length - 1; i >= 0; i--)	//fill board with values based on hex coordinates
		{
			for(int j = 0; j < board[i].length; j++)  //columns
			{
				board[i][j] = Integer.parseInt(binaryConvert(hexCoordinates[hexArray].substring(hexGroup, hexGroup+1)).substring(hexDigit, hexDigit+1));
				
				hexDigit++;
				if(hexDigit == 4)  //move to next hex group
				{
					hexDigit = 0;
					hexGroup++;
				}
				if(hexGroup == 4)  //move to next hex array
				{
					hexGroup = 0;
					hexArray++;
				}
			}
		}
		return board;
	}
	
	public static void tilePressed(int[][] board1, int[][] board2)  //finds the tile pressed given two boards
	{
		String tilePressed = "";
		int invertedTiles = 0, row = 0, column = 0;
		
		for(int i = 0; i < board1.length; i++)		//loop through board
		{
			for(int j = 0; j < board2.length; j++)
			{
				if(board2[i][j] != board1[i][j])  //change in value
				{
					invertedTiles++;  //number of tiles in a row which are inverted
					row = i;   //row of the last inverted tile in that row
					column = j;  //column of the last inverted tile in that row
				}
			}
			if(invertedTiles == 1)  //top tile of diamond
			{
				row = Math.abs(row - 8) - 2;
				column += 1;
				i = 8;
			}
			else if(invertedTiles == 2)  //second row of diamond smushed to the left or right
			{
				row = Math.abs(row - 8) - 1;
				if(column >= 4)
				{
					column += 1;
				}
				i = 8;
			}
			else if(invertedTiles == 3)  //second row of diamond or third row of smushed diamond
			{
				if(row == 0  && (board1[row + 2][column-1] == board2[row + 2][column-1]))  //smushed diamond
				{
					row = Math.abs(row - 8);
					if(column <= 4)
					{
						column -= 1;
					}
					else
					{
						column += 1;
					}
				}
				else
				{
					row = Math.abs(row - 8) - 1;
				}
				i = 8;
			}
			else if(invertedTiles == 4)  //third of smushed diamond
			{
				row = Math.abs(row - 8);
				if(column <= 4)  //left side
				{
					column -= 1;
				}
				else   //right side
				{
					column -= 0;
				}
				i = 8;
			}
			else if(invertedTiles == 5)  //third row of full diamond
			{
				row = Math.abs(row - 8);
				column -= 1;
				i = 8;
			}
		}	
		tilePressed += Integer.toString(row) + Integer.toString(column);  //convert the tile pressed to string
		System.out.println(tilePressed);
	}
}
