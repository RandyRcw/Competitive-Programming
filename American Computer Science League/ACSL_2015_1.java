import java.util.Scanner;

public class ACSL_2015_1 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String octalDigits = scan.next();
		String octalDigits2 = scan.next();
		String octalDigits3 = scan.next();
		String octalDigits4 = scan.next();
		String octalDigits5 = scan.next();
		
		String binaryNumbers = (octalConvert(octalDigits));
		String binaryNumbers2 = (octalConvert(octalDigits2));
		String binaryNumbers3 = (octalConvert(octalDigits3));
		String binaryNumbers4 = (octalConvert(octalDigits4));
		String binaryNumbers5 = (octalConvert(octalDigits5));
		
		String permission = (permissions(binaryNumbers, octalDigits));
		String permission2 = (permissions(binaryNumbers2, octalDigits2));
		String permission3 = (permissions(binaryNumbers3, octalDigits3));
		String permission4 = (permissions(binaryNumbers4, octalDigits4));
		String permission5 = (permissions(binaryNumbers5, octalDigits5));
		
		System.out.print(binaryNumbers.substring(0, 3) + " " + binaryNumbers.substring(3, 6) + " " + binaryNumbers.substring(6,  9));
		System.out.println(" and " + permission.substring(0, 3) + " " + permission.substring(3, 6) + " " + permission.substring(6, 9));
		System.out.print(binaryNumbers2.substring(0, 3) + " " + binaryNumbers2.substring(3, 6) + " " + binaryNumbers2.substring(6,  9));
		System.out.println(" and " + permission2.substring(0, 3) + " " + permission2.substring(3, 6) + " " + permission2.substring(6, 9));
		System.out.print(binaryNumbers3.substring(0, 3) + " " + binaryNumbers3.substring(3, 6) + " " + binaryNumbers3.substring(6,  9));
		System.out.println(" and " + permission3.substring(0, 3) + " " + permission3.substring(3, 6) + " " + permission3.substring(6, 9));
		System.out.print(binaryNumbers4.substring(0, 3) + " " + binaryNumbers4.substring(3, 6) + " " + binaryNumbers4.substring(6,  9));
		System.out.println(" and " + permission4.substring(0, 3) + " " + permission4.substring(3, 6) + " " + permission4.substring(6, 9));
		System.out.print(binaryNumbers5.substring(0, 3) + " " + binaryNumbers5.substring(3, 6) + " " + binaryNumbers5.substring(6,  9));
		System.out.println(" and " + permission5.substring(0, 3) + " " + permission5.substring(3, 6) + " " + permission5.substring(6, 9));
	}
	public static String octalConvert(String octalDigits)
	{
		String octal1 = octalDigits.substring(1, 2);
		String octal2 = octalDigits.substring(2, 3);
		String octal3 = octalDigits.substring(3, 4);
		int oct1 = Integer.parseInt(octal1);
		int oct2 = Integer.parseInt(octal2);
		int oct3 = Integer.parseInt(octal3);
		
		oct3 = oct3 * (int)(Math.pow(8, 0));
		oct2 = oct2 * (int)(Math.pow(8, 1));
		oct1 = oct1 * (int)(Math.pow(8, 2));
		
		int octal = oct3 + oct2 + oct1;
		String binary = "";
		
		while(octal > 0)
		{
			int num = octal % 2;
			String remainder = Integer.toString(num);
			binary += remainder;
			
			octal = octal / 2;
		}
		
		while(binary.length() < 9)
		{
			binary += "0";
		}
		
		String realBinary = "";
		for(int i = binary.length(); i > 0; i--)
		{
			realBinary += binary.substring(i - 1, i);
		}
		
		return realBinary;
	}
	
	public static String permissions(String binaryNumbers, String octalDigits)
	{
		String r = "r";
		String w = "w";
		String x = "x";
		String permissions = "";
		
		for(int i = 0; i < binaryNumbers.length(); i++) 
		{
			if(binaryNumbers.substring(i, i+1).equalsIgnoreCase("1"))
			{
				switch(i % 3)
				{
				case(0):
				{
					permissions += r;
					break;
				}
				case(1):
				{
					permissions += w;
					break;
				}
				case(2):
				{
					permissions += x;
					break;
				}
				}
			}
			else
			{
				permissions += "-";
			}
		}
		
		switch(octalDigits.charAt(0))
		{
		case'1':
		{
			if(!(permissions.substring(2, 3).equalsIgnoreCase("-")))
			{
				char[] specialPermissions = permissions.toCharArray();
				specialPermissions[2] = 's';
				permissions = String.valueOf(specialPermissions);
			}
			break;
		}
		case'2':
		{
			if(!(permissions.substring(5, 6).equalsIgnoreCase("-")))
			{
				char[] specialPermissions = permissions.toCharArray();
				specialPermissions[5] = 's';
				permissions = String.valueOf(specialPermissions);
			}
			break;
		}
		case'4':
		{
			if(!(permissions.substring(8, 9).equalsIgnoreCase("-")))
			{
				char[] specialPermissions = permissions.toCharArray();
				specialPermissions[8] = 't';
				permissions = String.valueOf(specialPermissions);
			}
			break;
		}
		
		}
		return permissions;
	}
}
