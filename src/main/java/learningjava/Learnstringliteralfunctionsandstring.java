package learningjava;

public class Learnstringliteralfunctionsandstring {

	public static void main(String[] args) {
		String str1, str2, str3, str4, str5;

		str1 = "TestLeaf Java";
		str2 = "TestLeaf Java";
		str3 = new String("TestLeaf Java");
		str4 = new String("testleaf Java");
		str5 = new String("java");
		
		strMethod(str1,str2,str3,str4,str5);

	}

	public static void strMethod(String arg1, String arg2, String arg3, String arg4, String arg5) {

		if (arg1 == arg2) {
			System.out.println("str1 " + arg1 + " and str2 " + arg2 + " are same");
			System.out.println(arg1==arg2);}
		else{
			System.out.println("str1 and str2 are not same");
			System.out.println(arg1==arg2);
			}
		if (arg1.equals(arg2)) {
			System.out.println("str1 and str2 are same");
			System.out.println(arg1.equals(arg2));
			}
		else {
			System.out.println("str1 and str2 are not same");
			System.out.println(arg1==arg3);
			}
		if(arg1==arg3) {
			System.out.println("str1 and str3 are same");
			System.out.println(arg1==arg3);
			}
		else {
			System.out.println("str1 and str3 are not same");
			System.out.println(arg1==arg3);
			}
		if(arg1.equals(arg3)) {
			System.out.println("str1 and str2 are same");
			System.out.println(arg1.equals(arg3));
			}
		else {
			System.out.println("str1 and str are not same");
			System.out.println(arg1.equals(arg3));
			}
		if(arg1.equalsIgnoreCase(arg4)) {
			System.out.println("str1 and str2 are same");
			System.out.println(arg1.equalsIgnoreCase(arg4));
		}
		else {
			System.out.println("str1 and str are not same");
			System.out.println(arg1.equalsIgnoreCase(arg4));
		}
		if(arg3.contains(arg5)) {
			System.out.println("str3 contains string java");
			System.out.println(arg3.contains(arg5));
		}
		else {
			System.out.println("str3 does not contain string java");
			System.out.println(arg3.contains(arg5));
		}
	}

}
