package week1.friday;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		fizzbuzz(15);
		fizzbuzz(55);
	}

	public static void fizzbuzz(int getNumber) {

		if (getNumber % 3 == 0 && getNumber % 5 == 0) {
			System.out.print(" FizzBuzz ");
		} else if (getNumber % 3 == 0) {
			System.out.println(" Fizz ");
		} else if (getNumber % 5 == 0) {
			System.out.println(" Buzz ");
		} else if (getNumber % 5 != 0 && getNumber % 3 != 0) {
			System.out.print(getNumber);
		}

	}
}
