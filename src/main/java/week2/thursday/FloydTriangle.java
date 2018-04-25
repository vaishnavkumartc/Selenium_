package week2.thursday;

import java.util.Scanner;

public class FloydTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNumber = scan.nextInt();
		int num=1;
		for(int i=1;i<=inputNumber;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
		scan.close();
	}
}
