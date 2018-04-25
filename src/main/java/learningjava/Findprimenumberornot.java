package learningjava;

import java.util.Scanner;

public class Findprimenumberornot {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();
		int number = inputNumber;
		int remainder = 0;
		int c = 0;
		int i;

		
		for (i=1;i<=inputNumber;i++) {
			remainder = inputNumber % i;
			if(remainder == 0) {
				c++;
			}
		}
		if (c == 2) {
			System.out.println("The given number " + number + " is a prime number");
		} else {
			System.out.println("The given number " + number + " is not a prime number");
		}

	}

}
/*
 * 1. get the input from the user to find the prime number
 * 2. declare and
 * initialize variables required int inputNumber = scan.nextInt(); 
 * int remainder;c 
 * 3. solve the problem 
 * remainder = inputNumber%2
 * for (int i=1;i<=inputNumber;i++){
 * if(remainder == 0){
 * c++;
 * }
 * }
 *  if(c == 2)
 * { System.out.println("The given number " + number + " is a prime number");
 * }else{ System.out.println("The given number " + number +
 * " is not a prime number");
 * 
 */