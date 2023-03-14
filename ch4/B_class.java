package a.b.c.ch4;

public class B_class implements B_interface, C_interface {

	@Override
	public void c1_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("c1_interfaceMethod() >>> : ");
	}//end of c1_interfaceMethod

	@Override
	public void b1_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("b1_interfaceMethod() >>> : ");

	} //end of b1_interfaceMethod

	@Override
	public void b2_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("b2_interfaceMethod() >>> : ");
	} //end of b2_interfaceMethod
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() >>> : ½ÃÀÛ :");
		B_class bc = new B_class();
		bc.b1_interfaceMethod();
		bc.c1_interfaceMethod();
		bc.b2_interfaceMethod();
		System.out.println("main() >>> : ³¡ :");
		
	} //end of main

	@Override
	public void c2_interfaceMethod() {
		// TODO Auto-generated method stub
		
	}


}//end of B_class
