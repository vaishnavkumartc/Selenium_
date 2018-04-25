package learningjava;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		// 1. get the input
		int multiplicationNumber = 4;
		int numberOfIteration = 20;

		//2. Initialize variable
		int multiplicationResult = 0;

		//3. logic
		for(int i =1; i<=numberOfIteration; i++){
		multiplicationResult = i* multiplicationNumber;
		System.out.println(i + " * " + multiplicationNumber + " = " + multiplicationResult);
		}
		
		Scanner input = new Scanner(System.in);
		
		int j=input.nextInt();
		input.close();
		while(j!=0) {
			
			System.out.println(j + " * " + "2 = " + j*2);
			j-=1;
		}

	}

}
