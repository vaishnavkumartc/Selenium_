package week1.monday;

import java.util.Scanner;

public class CodingChallange {

	public static void main(String[] args) {

		// 1. get the input

		// get input from user to find the factorial for

		Scanner scan = new Scanner(System.in);

		int inputNumber = scan.nextInt();

		// 2. Initialize the required variables

		int iterator, factorial = 1;
		int number = inputNumber;

		// 3. logic

		for (iterator = inputNumber; iterator > 0; iterator--) {

			factorial = factorial * iterator;

		}
		System.out.println("factorial of number " + number + " " + factorial);

	}

}
