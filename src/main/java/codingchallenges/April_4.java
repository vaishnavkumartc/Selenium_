package codingchallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class April_4 {

	public static void main(String[] args) {

		//1. get the input from the user

		Scanner scan = new Scanner(System.in);
		int quotient,remainder;
		//int count=0;
		int inputNumber = scan.nextInt();
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		while(inputNumber!=0) {
			quotient = inputNumber/10;
			remainder = inputNumber%10;
			inputNumber = quotient;
			//count++;
			integerList.add(remainder);
		}
		Collections.sort(integerList);
		System.out.println(integerList);
		Set<Integer> set = new HashSet<Integer>(integerList);
		System.out.println(set);
		System.out.println(set.size());
		String last = "";
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			Integer next = itr.next();
			String str = next.toString();
			last=last+str;
		}
		
		System.out.println(last);
		
	}

}
