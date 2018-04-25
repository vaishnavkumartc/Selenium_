package multilevelinheretance;

import java.util.Scanner;

public class Scanarray {

	public static void main(String[] args) {
		int arr[] = new int[10];
		
		Scanner objscan = new Scanner(System.in);
		
		for (int j =0;j<arr.length;j++) {
			System.out.println("array" + "[" + j + "]");
			arr[j]= objscan.nextInt();
		}
		
		String strarr[][]= new String[10][2];
		
		for (int row =0;row<strarr.length;row++) {
			for(int col=0;col<2;col++) {
				System.out.println("strarr[" + row + "]" + "[" + col + "]");
				strarr[row][col] = objscan.next();
			}
		}
		

	}

}
