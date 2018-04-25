package learningjava;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		//Get Input 
		String report[][] = {{"vaishnav","A+"},{"ram","A+"},{"uma","A+"},{"jayant","O+"}};
		int a = report.length;
		
		//print the array
		
		for (int r=0;r<a;r++) {
			System.out.println(report[r][0] + "  " + report[r][1]);
		}
		
		//using double for loop
		
		for(int row =0;row<a;row++) {
			for(int col =0;col<2;) {
				System.out.print(report[row][col] + "  ");
				System.out.println(report[row][col+1]);
				break;
			}
		}
				
		
	}

}
