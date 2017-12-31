package software;
import java.util.Scanner;

public class SaintAnselm5 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number:");
		int num = scan.nextInt();
		
		
	}
	
	public static int factors(int num)
	{
		int count = 0;
		
		for(int i = 1; i < num; i++)
		{
			
			if(num % i == 0)
			{
				count++;
			}
		}
	}
}
