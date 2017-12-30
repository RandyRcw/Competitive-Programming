import java.util.Scanner;
import java.util.ArrayList;

// Randy Wang
// Nashua High School North
// Senior-3

public class ACSL_2016_4 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String input1 = scan.next();
		skyscraper(input1);
		String input2 = scan.next();
		skyscraper(input2);
		String input3 = scan.next();
		skyscraper(input3);
		String input4 = scan.next();
		skyscraper(input4);
		String input5 = scan.next();
		skyscraper(input5);
	}
	
	public static void skyscraper(String input)
	{
		String[] cluesArray = input.split(",");	
		String clues = "";
		for(int i = 0; i < cluesArray.length; i++)
		{
			clues += cluesArray[i];
		}
		int n;
		String[] columnClues;
		String[] rowClues;
		
		if(clues.length() == 16)
		{
			n = 4;
			columnClues = new String[8];
			rowClues = new String[8];
			int k = 4, l = 0;
			
			for(int i = 0; i < 16; i++)
			{
				if(i < 4)
				{
					columnClues[i] = clues.substring(i, i+1);
				}
				else if(i > 11)
				{

					columnClues[k] = clues.substring(i, i+1);
					k++;
				}
				else
				{
					rowClues[l] = clues.substring(i, i+1);
					l++;
				}
			}
		}
		else
		{
			n = 5;
			columnClues = new String[10];
			rowClues = new String[10];
			int k = 5, l = 0;
			
			for(int i = 0; i < 20; i++)
			{
				if(i < 5)
				{
					columnClues[i] = clues.substring(i, i+1);
				}
				else if(i > 14)
				{
					columnClues[k] = clues.substring(i, i+1);
					k++;
				}
				else
				{
					rowClues[l] = clues.substring(i, i+1);
					l++;
				}
			}
		}
		
		int[][] grid;
		if(clues.length() == 16)
		{
			grid = new int[4][4];
		}
		else
		{
			grid = new int[5][5];
		}
		
		for(int i = 0; i < columnClues.length; i++)  //fill in values from column clues that are known(1 and n)
		{
			if(columnClues[i].equals("1"))
			{
				if(i < columnClues.length / 2)
				{
					grid[0][i] = n;
				}
				else
				{
					grid[grid.length-1][i%n] = n;
				}
			}
			else if(columnClues[i].equals(Integer.toString(n)))
			{
				if(i < columnClues.length / 2)
				{
					for(int j = 0; j < grid.length; j++)
					{
						grid[j][i] = j+1;
					}
				}
				else
				{
					int k = 1;
					for(int j = grid.length; j > 0; j--)
					{
						grid[j-1][i%n] = k;
						k++;
					}
				} 
			}
		}
		
		for(int i = 0; i < rowClues.length; i++)
		{
			if(rowClues[i].equals("1"))
			{
				if(i % 2 == 0)
				{
					grid[i/2][0] = n;
				}
				else
				{
					grid[i/2][grid.length-1] = n;
				}
			}
			else if(rowClues[i].equals(Integer.toString(n)))
			{
				if(i % 2 == 0)
				{
					for(int j = 0; j < grid.length; j++)
					{
						grid[i/2][j] = j+1;
					}
				}
				else
				{
					int k = 1;
					for(int j = grid.length; j > 0; j--)
					{
						grid[i/2][j-1] = k;
						k++;
					}
				} 
			}
		}
		
		boolean flag = true;
		int count = 0;
		
		while(flag && count < 50)
		{
			flag = false;
			
			for(int i = 0; i < grid.length; i++)
			{
				for(int j = 0; j < grid[i].length; j++)
				{
					if(grid[i][j] == 0)
					{
						int[] usedValues = new int[n*2];
						for(int k = 0; k < n; k++)
						{
							usedValues[k] = grid[i][k];
							usedValues[k+n] = grid[k][j];
						}
						
						int total;
						if(n == 4)
							total = 10;
						else
							total = 15;
						
						ArrayList<Integer> uniqueValues = new ArrayList<Integer>();
						
						for(int l = 0; l < usedValues.length; l++)
						{
							boolean unique = true;
							if(usedValues[l] != 0)
							{
								for(int s : uniqueValues)
								{
									if(usedValues[l] == s)
									{
										unique = false;
									}
								}
								
								if(unique)
								{
									uniqueValues.add(usedValues[l]);
								}
							}
						}
						
						for(int s : uniqueValues)
						{
							total -= s;
						}
						
						if(total <= n && uniqueValues.size()+1 == n)
						{
							grid[i][j] = total;
						}
						
//						for(int p = 0; p < uniqueValues.size(); p++)
//						{
//							System.out.print(uniqueValues.get(p));
//						}
//						System.out.println();
					}
				}
			}
			
//			for(int i = 0; i < grid.length; i++)
//			{
//				for(int j = 0; j < grid[i].length; j++)
//				{
//					System.out.print(grid[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			for(int i = 0; i < grid.length; i++)
			{
				for(int j = 0; j < grid[i].length; j++)
				{
					if(grid[i][j] == 0)
					{
						flag = true;
					}
				}
			}
			
			count++;
		}
		
//		for(int i = 0; i < grid.length; i++)
//		{
//			for(int j = 0; j < grid[i].length; j++)
//			{
//				System.out.print(grid[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		String[] values = new String[n];
		int initial = 1;
		for(int i = 0; i < values.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if(initial == 1)
					values[i] = Integer.toString(grid[i][j]);
				else
					values[i] += Integer.toString(grid[i][j]);
				initial = 2;
			}
			initial = 1; 
		}
		
		for(int i = 0; i < values.length; i++)
		{
			if(i != values.length-1)
				System.out.print(values[i] + ", ");
			else
				System.out.print(values[i]);
		}
		System.out.println();
	}
}
