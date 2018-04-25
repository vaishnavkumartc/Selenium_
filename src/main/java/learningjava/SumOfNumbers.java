package learningjava;

public class SumOfNumbers {

	public static void main(String[] args) {
		
		//get input number
		int InputNumber = 56887;
		int number= InputNumber;
		
		// Initialize SumOfObjects
		int SumOfNumbers=0;
		
		while(InputNumber!=0) {
			int quotient = InputNumber/10;
			int remainder = InputNumber%10;
			SumOfNumbers=SumOfNumbers+remainder;
			InputNumber=quotient;
			
		}
		System.out.println("The Sum of the Number " + number  + " is " + SumOfNumbers );

	}

}
