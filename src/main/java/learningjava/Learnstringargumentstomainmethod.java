package learningjava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Learnstringargumentstomainmethod {

	public static void main(String[] args) {
		
		for (String i : args)
			System.out.println("main method arguments are " + i);

		for (int i = 0; i < args.length; i++) {
			System.out.println("main method arguments are " + args[i]);
		}
		int i = 0;
		while(i<args.length) {
			System.out.println("main method arguments are " + args[i]);
			i++;
			
			int arr[] = null;
			
			Scanner objscan = new Scanner(System.in);
			
			for (int j =0;j<10;j++) {
				arr[j ]= objscan.nextInt();
			}
			
			
		

	}
}}


