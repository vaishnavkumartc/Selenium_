package codingchallenges;

public class StringFunctions {
	
	public static void main(String[] args) {
		
		String input="AB92h";
		
		char[] ch = input.toCharArray();
		
		for (char c : ch) {
			int d;
//			System.out.println((int)c);
			d = (int)c+1;
			System.out.print((char)d);
			
		}
		
	}

}
