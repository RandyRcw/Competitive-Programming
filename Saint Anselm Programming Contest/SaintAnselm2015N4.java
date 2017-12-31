package software;
import java.util.Scanner;

public class SaintAnselm2015N4 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter first string:");
		String word1 = scan.nextLine();
		System.out.println("Enter second string:");
		String word2 = scan.nextLine();
		
		String commonSubstring = longestCommonSubstring(word1, word2);
		System.out.println(commonSubstring + "\t" + commonSubstring.length());
	}

	public static String longestCommonSubstring(String word1, String word2)
	    {
			word1 = word1.toLowerCase();
			word2 = word2.toLowerCase();
			
	        int length1 = word1.length();
	        int length2 = word2.length();
	 
	        int[][] substring = new int[length1 + 1][length2 + 1];
	        int length = 0, position = -1;
	 
	        for (int i = 1; i < length1 + 1; i++)
	        {
	            for (int j = 1; j < length2 + 1; j++)
	            {
	                if (word1.charAt(i - 1) == word2.charAt(j - 1))
	                {
	                        substring[i][j] = substring[i - 1][j - 1] + 1;
	                        if (substring[i][j] > length)
	                        {
	                            length = substring[i][j];
	                            position = i;
	                        }               
	                }
	                else
	                    substring[i][j] = 0;
	            }
	        }        
	 
	        return word1.substring(position - length, position);
	    }
}
