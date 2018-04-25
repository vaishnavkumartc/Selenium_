package week2.wednesday;

import java.util.Scanner;

public class FindLeapYear {

	public static void main(String[] args) {
		//1. get the input

		Scanner scan = new Scanner(System.in);

		int inputYear = scan.nextInt();

		//2. logic
		
		boolean result = ((inputYear%4 == 0) && (inputYear%100 != 0)) || ((inputYear%4 == 0) && (inputYear%100 == 0) && (inputYear%400 == 0));
		
		if(result) {
			System.out.println(inputYear + " is a leap year");
		}else {
			System.out.println(inputYear + " is not a leap year");
		}
	}
}
/*		divisibleBy4 = inputYear%4;
divisibleBy100 = inputYear%100;
divisibleBy400 = inputYear%400;
if(divisibleBy4 == 0)
{
	if(divisibleBy100 == 0)
	{
		if(divisibleBy400 == 0)
			System.out.println("leap year");
		else 
			System.out.println("not a leap year");
	}else 
		System.out.println("leap year");
}else
	System.out.println("not a leap year");*/