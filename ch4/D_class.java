package a.b.c.ch4;

public class D_class implements D_interface {

	@Override
	public void c1_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("    c1_interfaceMethod()");
	}

	@Override
	public void c2_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("    c2_interfaceMethod()");
	}

	@Override
	public void d_1_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("    d1_interfaceMethod()");

	}
	public static void main(String[] args) {
		
		D_class dc = new D_class();
		dc.c1_interfaceMethod();
		dc.c2_interfaceMethod();
		dc.d_1_interfaceMethod();
	} //end of main



}
