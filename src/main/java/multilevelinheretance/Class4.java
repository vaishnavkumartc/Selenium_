package multilevelinheretance;

public class Class4 {
	
	public static void main(String[] args) {
		Class1 obj1 = new Class1();
		Class2 obj2 = new Class2();
		Class3 obj3 = new Class3();
		obj3.varClass1=10;
		obj3.varClass2 = "vaishnav";
		//int varClass2 =2 ;
		obj3.method1();
		method2();
		
	}
	static void method2(){
		
		System.out.println("test overriding");
		
	}

}
