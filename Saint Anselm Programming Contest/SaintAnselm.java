package software;

import java.util.Scanner;
import java.util.Arrays;

public class SaintAnselm {

		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	System.out.println("Enter two words? ");
		String word1 = scan.nextLine();
		String word2 = scan.nextLine();
		
		System.out.println(isAnagram(word1, word2));
		}
		
		public static boolean isAnagram(String word1, String word2) {
			
			if(word1.length() != word2.length()) {
				return false;
			}
			char[] charWord1 = word1.toCharArray();
			char[] charWord2 = word2.toCharArray();
			sortArray(charWord1);
			sortArray(charWord2);
			String word3 = String.valueOf(charWord1);
			String word4 = String.copyValueOf(charWord2);
			
			if(word3.equalsIgnoreCase(word4)) {
				return true;
			}
			return false;
		}
			
			public static void sortArray(char[] charWord) {
			     int i, j;  //be sure that the temp variable is the same "type" as the array
			     char temp;
			     for ( i = 0; i < charWord.length - 1; i ++ )  
			     {
			          for ( j = i + 1; j < charWord.length; j ++ )
			          {
			               if(charWord[ i ] < charWord[ j ] )         //sorting into descending order
			               {
			                       temp = charWord[ i ];   //swapping
			                       charWord[ i ] = charWord[ j ];
			                       charWord[ j ] = temp; 
			                }           
			          }
			     }
			}
}
		
		
//		public static boolean isAnagram(String str1, String str2) {
//			 
//	        // If string lengths are not same, the strings are not anagrams.
//	        if (str1.length() != str2.length()) {
//	            return false;
//	        }
//	 
//	        // Sort characters of both the strings.
//	        str1 = sortCharacters(str1);
//	        str2 = sortCharacters(str2);
//	 
//	        // After sorting if strings are equal then they are anagrams.
//	        return str1.equals(str2);
//	    }
//	 
//	    private static String sortCharacters(String str) {
//	        char[] charArray = str.toLowerCase().toCharArray();
//	        Arrays.sort(charArray);
//	        return String.valueOf(charArray);
//	    }
//	 
//	    public static void main(String[] args) {
//	    	
//	    	Scanner scan = new Scanner(System.in);
//	    	
//	    	System.out.println("Enter two words:");
//	        String str1 = scan.nextLine();
//	        String str2 = scan.nextLine();
//	        if (isAnagram(str1, str2)) {
//	            System.out.println(true);
//	        } else {
//	            System.out.println(false);
//	        }
//	    }
	

