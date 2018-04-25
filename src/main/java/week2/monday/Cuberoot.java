package week2.monday;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Cuberoot {

	public static void main(String[] args) {

		for(int j = 1;j<=1000;j++) {
			int number = j;
			int answer=0;
			int quotient,remainder;
			int finalans=0;
			while(number!=0) {
				quotient=number/10;
				remainder=number%10;
				number=quotient;
				answer = findCubeRoot(remainder);
				finalans = answer + finalans;
			}
			if(j==finalans)
				System.out.println(j + " The input number is an armstrong number");
		}
	}

	public static int findCubeRoot(int remaind) {
		int ans=1;
		for(int i=1;i<=3;i++) {
			ans=ans*remaind;
			//System.out.println(ans);
		}
		return ans;

	}
}
