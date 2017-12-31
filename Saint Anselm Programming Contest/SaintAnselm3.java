package software;
import java.util.Scanner;
public class SaintAnselm3 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number:");
		int num = scan.nextInt();
	
//		long param = convertFactorial(num);
//		long result = (numberZeros(param));
		System.out.println(findTrailingZeros(num));
	}
	
	public static int numberZeros(long factorial) {
		
		String factorialWord = Long.toString(factorial);
		char[] arrayFactorial = factorialWord.toCharArray();
		
		int counter = 0;
		for(long i = arrayFactorial.length - 1; i > 0; i--) 
		{
			if(arrayFactorial[(int) i] == '0')
			{
				counter++;
			}
			else 
			{
				
			}
		}
		return counter;
	}
	public static long convertFactorial(int num) {
		
		long factorial = 1;
		
		for(long i = num; i > 0; i--)
		{
			factorial *= i;
		}
		return factorial;
	}
	
	public static int findTrailingZeros(int n) {
		
		int count = 0;
		
		for(int i = 5; n / i >= 1; i *= 5) 
		{
			count += n / i;
		}
		
		return count;
	}
	
	public static int trailingZeros(long num) {
		
		int count = 0;
		
		while(num % 10 == 0)
		{
			num /= 10;
			count++;
		}
		return count;
	}
	 
}

