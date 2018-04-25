package week2.friday;

public class FindSecondBiggestNumber {

	public static void main(String[] args) {

		int[] arr = {12,21,-55,44,33};
		int second,first,i;
		first=second=Integer.MIN_VALUE;
		
		for(i=0;i<arr.length;i++) {
			
			if(arr[i]>first) {
				second = first;
				first = arr[i];
			}
			else if(arr[i]>second && arr[i]!=first) {
				second = arr[i];
			}
		}
		System.out.println(second);
	}
}
