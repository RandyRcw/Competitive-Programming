import java.util.Scanner;
import java.text.DecimalFormat;

public class ACSL_2014_1 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		String input1 = scan.next();
		String input2 = scan.next();
		String input3 = scan.next();
		String input4 = scan.next();
		String input5 = scan.next();
		
		navigate(input1);
		navigate(input2);
		navigate(input3);
		navigate(input4);
		navigate(input5);
	}
			
	public static void navigate(String input)
	{
			String[] inputs = input.split(",");
			
			String location1 = inputs[0];
			String location2 = inputs[1];
			double time1 = Double.parseDouble((inputs[2]));
			String period1 = inputs[3];
			double time2 = Double.parseDouble(inputs[4]);
			String period2 = inputs[5];
			double speed1 = Double.parseDouble(inputs[6]);
			double speed2 = Double.parseDouble(inputs[7]);
			
			//System.out.println(location1 + location2 + time1 + period1 + time2 + period2 + speed1 + speed2);
		
			String[] cities = {"AB", "BC", "CD", "DE", "EF", "FG", "GH", "HJ", "JK"};
			double[] distances = {450, 140, 125, 365, 250, 160, 380, 235, 320};
			int distance1 = 0, distance2 = 0;
			
			for(int i = 0; i < cities.length; i++)
			{
				if(location1.equals(cities[i].substring(0, 1)))
				{
					distance1 = i;
				}
				if(location2.equals(cities[i].substring(1, 2)))
				{
					distance2 = i;
				}
			}
			
			double distance = 0;
			
			for(int j = distance1; j <= distance2; j++)
			{
				distance += distances[j];
			}

			if(period1.equals("PM") && time1 != 12)
			{
				time1 += 12;
			}
			if(period2.equals("PM") && time2 != 12)
			{
				time2 += 12;
			}
			if(period1.equals("AM") && time1 == 12)
			{
				time1 = 0;
			}
			if(period2.equals("AM") && time2 == 12)
			{
				time2 = 0;
			}
			
			int first = 0;
			double shortestTime = 0;
			if(Math.abs(time1- time2) < 24 - Math.abs(time1 - time2))
			{
				shortestTime = Math.abs(time1- time2);
			}
			else
			{
				shortestTime = 24 - Math.abs(time1- time2);
				first = 1;
			}
			
			double initialDistance = 0;
			int firstToGo = 0;
			
			switch(first)
			{
				case(0):
				{
					if(time1 <= time2)
					{
						initialDistance = speed1 * shortestTime;
					}
					else
					{
						initialDistance = speed2 * shortestTime;
						firstToGo = 1;
					}
					break;
				}
				case(1):
				{
					if(time1 >= time2)
					{
						initialDistance = speed1 * shortestTime;
					}
					else
					{
						initialDistance = speed2 * shortestTime;
						firstToGo = 1;
					}
					break;
				}
			}
			
			double combinedSpeed = speed1 + speed2;
			distance -= initialDistance;
			double time = distance / combinedSpeed;
			int hour = 0;
			double minute = 0;
			if(firstToGo == 0)
			{
				time += shortestTime;
				hour = (int)Math.floor(time);
				minute = (time % 1) * 60;
			}
			else
			{
				hour = (int)Math.floor(time);
				minute = (time % 1) * 60; 
			}
			
			DecimalFormat decimal = new DecimalFormat("0");
			String hourTime = Integer.toString(hour);
			String minuteTime = decimal.format(minute);
			
			if(minuteTime.length() < 2)
			{
				minuteTime = "0" + minuteTime;
			}
			System.out.println(hourTime + ":" + minuteTime);

	
	}

}
