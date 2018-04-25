package learningjava;

public class Palindrome {

	public static void main(String[] args) {
		//1. get the input
		int InputNumber = 676;
		int number = InputNumber;

		//2.Initialise variables
		int ReversedNumber=0;
		int Quotient;
		int Remainder;

		/*3.get single digits
		Remainder = InputNumber%10;
		Quotient = InputNumber/10;
		ReversedNumber = ReversedNumber * 10 + Remainder;
		InputNumber = Quotient;*/

		//4. find palindrome

		while(InputNumber != 0){
		Remainder = InputNumber%10;
		Quotient = InputNumber/10;
		ReversedNumber = ReversedNumber * 10 + Remainder;
		InputNumber = Quotient;
		}

		if(number == ReversedNumber){
		System.out.println("The given number " + number + " is palindrome");
		}
		else {
		System.out.println("The given number " + number + " is not a palindrome");
		
		}


	}

}
