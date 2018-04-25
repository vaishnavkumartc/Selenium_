package week1.friday;

import java.util.Scanner;

public class Swapnumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("get a");
		int a=scan.nextInt();
		System.out.println(a);
		System.out.println("get b");
		int b=scan.nextInt();
		System.out.println(b);
		swap(a,b);
		
	}
	public static void swap(int a, int b) {
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);
			
		}

}
