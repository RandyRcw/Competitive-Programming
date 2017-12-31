package software;

import java.util.Scanner;
import java.util.Stack;

public class SaintAnselm4 {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter rectangle 1: ");
		int oneX = scan.nextInt();
		int oneY = scan.nextInt();
		int oneWidth = scan.nextInt();
		int oneHeight = scan.nextInt();
		
		System.out.println("Enter rectangle 2: ");
		int twoX = scan.nextInt();
		int twoY = scan.nextInt();
		int twoWidth = scan.nextInt();
		int twoHeight = scan.nextInt();
		
		int[] oneUL = {oneX, oneY};
		int[] oneUR = {oneX + oneWidth, oneY};
		int[] oneLL = {oneX, oneY - oneHeight};
		int[] oneLR = {oneX + oneWidth, oneY - oneHeight};
		
		int[] twoUL = {twoX, twoY};
		int[] twoUR = {twoX + twoWidth, twoY};
		int[] twoLL = {twoX, twoY - twoHeight};
		int[] twoLR = {twoX + twoWidth, twoY - twoHeight};
		
		
		boolean flag = false;
		
		if(twoLL[0] >= oneUL[0] && twoLL[0] <= oneUR[0] && twoLL[1] >= oneLL[1] && twoLL[1] <= oneUL[1])
		{
			flag = true;
		}
		if(twoLR[0] >= oneUL[0] && twoLR[0] <= oneUR[0] && twoLR[1] >= oneLL[1] && twoLR[1] <= oneUL[1])
		{
			flag = true;
		}
		if(twoUR[0] >= oneUL[0] && twoUR[0] <= oneUR[0] && twoUR[1] >= oneLL[1] && twoUR[1] <= oneUL[1])
		{
			flag = true;
		}
		if(twoUL[0] >= oneUL[0] && twoUL[0] <= oneUR[0] && twoUL[1] >= oneLL[1] && twoUL[1] <= oneUL[1])
		{
			flag = true;
		}
		
		if(flag)
		{
			System.out.println("Collision.");
		}
		else
		{
			System.out.println("No collision.");
		}
	}
}
