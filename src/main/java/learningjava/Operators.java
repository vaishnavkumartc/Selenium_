package learningjava;

public class Operators {

	public static void main(String[] args) {
		int sum = add(3,6);
		int mul= multiply(3,6);
		divide(9,6);
		substract(4,6);
		//findtrueorfalse(6);
	}
	
	public static int add(int a,int b) {
		System.out.println(a+b);
		return(a+b);
	}
	
	public static int multiply(int a, int b) {
		System.out.println(a*b);
		return(a*b);
		
	}
	
	public static void divide(int a, int b) {
		System.out.println(a/b);
	}
	
	public static void substract(int a, int b) {
		System.out.println(a-b);
	}
	
	

}
