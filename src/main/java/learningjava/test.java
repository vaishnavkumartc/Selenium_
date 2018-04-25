package learningjava;

import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		
		/*String str ="madam";
		StringBuilder reverse;
		StringBuilder sb = new StringBuilder(str);
		reverse = sb.reverse();
		String rev = reverse.toString();
		if(rev.equals(str)) {
			System.out.println("pass");
		}*/
		
		//1. get the input from the user
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String revStr="";
		int strln;
		//logic
		strln = str.length();
		for(int i=strln-1;i>=0;i--){

		revStr = revStr + str.charAt(i);
		
		}

		if(revStr.equals(str)){
		System.out.println(str + " is a palindrome");
		}else{
		System.out.println(str + " is not a palindrome");
		}

}
}
