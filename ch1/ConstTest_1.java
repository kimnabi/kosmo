package a.b.c.ch1;

public class ConstTest_1 {
	
	// 맴버변수 지정
	int i; // int 자료형 i 가 인스턴스 시  0 디폴트 값으로 세팅함
	String s; // String 자료형이 인스턴스 시 null 디포트값으로 세팅
	// 기본 생성자의 코드가 기술되지 않았다
	/*
	public ConstTest_1() {
		System.out.println("ConstTest_1() 생성자 시작 >>> : ");
	}
	*/
	// 자바 버철머신이 기본 생성자를 만들어 준다
	public static void main(String[] args) 
	{
		System.out.println("main() 함수 시작 >>> : ");

		ConstTest_1 ct_1 = new ConstTest_1(); // 기본생성자 ConstTest_1() 찾아서 인스턴스를 만들어 준다
		System.out.println("cj_1 참조변수 >>> : " + ct_1);
		System.out.println("cj_1.i >>> : " + ct_1.i);
		System.out.println("cj_1.s >>> : " + ct_1.s);
	} //end of main() function
} // end of ConstTest_1 class
