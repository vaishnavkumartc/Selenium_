package week1.tuesday;

import java.util.Scanner;

public class CodingChallange {

	public static void main(String[] args) {

		// 1. get the input from the user
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Hi, enter a number to find whether it is a palindrome");
		int findPalindromeFor = scan.nextInt();
		int number = findPalindromeFor;

		// 2. intialize the required variables
		int i, reverse = 0;
		int quotient, remainder;

		// 3. logic

		while (findPalindromeFor != 0) {
			quotient = findPalindromeFor / 10;
			remainder = findPalindromeFor % 10;
			reverse = reverse * 10 + remainder;
			findPalindromeFor = quotient;
		}

		if (reverse == number) {
			System.out.println("The given number " + number + " is palindrome");
		} else {
			System.out.println("The given number" + number + " is not a palindrome");
		}

	}

}
