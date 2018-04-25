package week1.wednesday;

import java.util.Scanner;

public class ArithematicOperations {

	// 1. get the input

	// 2. intialize variables and methods

	public static void add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("addition result is " + result);
	}

	public static void substract(int num1, int num2) {
		int result = num1 - num2;
		System.out.println("substraction result is " + result);
	}

	public static void multiply(int num1, int num2) {
		int result = num1 * num2;
		System.out.println("multiplication result is " + result);
	}

	public static void division(int num1, int num2) {
		int result;
		result = num1 / num2;
		System.out.println("division result is " + result);
	}

	// 3. logic
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter first number");
		int firstNumber = scan.nextInt();
		System.out.println("enter second number");
		int secondNumber = scan.nextInt();
		System.out.println("enter the operation");
		String selectOperation = scan.next();

		switch (selectOperation) {
		case "add":
			add(firstNumber, secondNumber);
			break;
		case "substract":
			substract(firstNumber, secondNumber);
			break;
		case "multiply":
			multiply(firstNumber, secondNumber);
			break;
		case "divide":
			division(firstNumber, secondNumber);
			break;
		default:
			System.out.println("something went wrong");

		}
		scan.close();
	}
}
