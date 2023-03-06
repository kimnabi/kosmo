package a.b.c.ch1;

public class ClassTest_1 {
	
	// 변수를 선언하는 영역
	
	// 상수 Constant 
	public static final String BIZ_GUBUN_M = "M"; // 회원 게시판 
	public static final String BIZ_GUBUN_B = "B"; // 일반 게시판 
	
	// 스태틱 변수 
	static int static_val = 120;
	
	// 멤버 변수 
	// 멤버 변수는 초기화 해서 사용하지 않는다. 값을 대입하지 않는다.
	// 이 클래스가 있는 패키지 안에서 누구나 불러서 사용할 수 있다.
	int member_val;

	// 전역 변수 
	// 누구나 불러서 사용이 가능하다.
	public int global_val;

	// 프라이빗 변수
	// 클래스 내부에서만 사용할 수 있는 변수 
	private int encapsulation_val; 	
	
	public static void main(String[] args) 
	{
		//1.상수
		System.out.println("상수 >>> : " + ClassTest_1.BIZ_GUBUN_M);
		//2. 스태틱 변수 
		System.out.println("스태틱 변수 >>> : " + ClassTest_1.static_val);
		// 3, 4, 5 변수는 클래스를 메모리에 올려서 변수는 메모리에 올린다.
		//해당 참조변수를 이용하여 출력한다
		ClassTest_1 ct = new ClassTest_1();
		System.out.println("맴버 변수 >>> : " + ct.menber_val);
		System.out.println("전역 변수 >>> : " + ct.global_val);
		System.out.println("프라이빗 변수 >>> : " + ct.encapsulation_val);
		
	} //end of main function
} //end of ClassTest_1
