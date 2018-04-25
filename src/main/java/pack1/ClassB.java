package pack1;

public class ClassB {
	public static void main(String[] args) {
		ClassA aobj =new ClassA();
		
		//i can only access public, default and protected variables and methods of ClassA
		aobj.boo = true; //protected
		aobj.number1=21; //default
		aobj.str1="test";//public
		
		aobj.method1();//public
		aobj.method3();//protected
		aobj.method4();//default
		
		ClassA.method3();//method3() is accessed without object because this method is declared as static
		//ClassA.method4();//method4() is accessed without object because this methos is declared as static
	}
	


}
