package pack1;

public class ClassD extends ClassA{
	
	public static void main(String[] args) {
		//ClassA.method4();// this is overridden method of ClassA
		
		ClassA objA = new ClassA();
		objA.method3();//this original method of ClassA
		//method4();
		
		ClassB objB = new ClassB();
	}
	
	public void method4() {
		System.out.println("test overriding");
	}
	
	

	
	

}
