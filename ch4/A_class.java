package a.b.c.ch4;

/**
 * @author kasmo
 *
 */
public class A_class implements A_interface {
	// @ : 어노테이이션 : 자바에서 사용하는 기술 이름 
	// 1. 주석 : 해당 기능을 설명하는 역활 
	// 2. 기능을 구현 : 실제로 클래스 및 인터페이스를 이용해서 기능이 구현 된다.
	@Override // 오버라이드 어노테이션 Annotation : 부모(상위)클래스에서 가져온 함수이다.
	public void b_interfaceMethod() {
		// TODO Auto-generated method stub
          System.out.println("b_interfaceMethod() >>> : ");
	}

	@Override
	public void ba_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("ba_interfaceMethod() >>> : ");
		
	}

	@Override
	public void bb_interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("bb_interfaceMethod() >>> : ");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	A_class ac = new A_class();
	ac.b_interfaceMethod();
	ac.ba_interfaceMethod();
	ac.bb_interfaceMethod();
	
	}//end of main

} //end of A_class

