package a.b.c.ch4;

public class E_interfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 부모 클래스인 인터페이스 클래스 선언
		// 2. 참조 변수 선언
		// 3. = 대입 연산자
		// 4. new 인스턴스 키워드(연산자) 선언
		// 5. 부모 인터페이스를 상속한 자식 클래스 생성자 선언 
		E_interface ei = new E_interfaceImpl();
		 ei.e_interfaceMethod();
		// 부모클래스 참조변수 형변환해서 자식클래스 자원 사용하기
		E_interfaceImpl eii = (E_interfaceImpl)ei;
			eii.eM();
			
			// 자식클래스 인스턴스해서 자식클래스 자원사용하기 
			E_interfaceImpl ei_1 = new E_interfaceImpl();
			ei_1.eM();
	}

}
