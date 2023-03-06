package a.b.c.ch1;

public class ConstTest_2 {
	
	// 맴버변수 지정
	int i; // int 자료형 i 가 인스턴스 시  0 디폴트 값으로 세팅함
	String s; // String 자료형이 인스턴스 시 null 디포트값으로 세팅
	// 개발자가 기본 생성자의 코드를 기술
	
	public ConstTest_2() {
		System.out.println("ConstTest_2() 생성자 시작 >>> : ");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("main() 함수 시작 >>> : ");

		ConstTest_2 ct_2 = new ConstTest_2(); // 기본생성자 ConstTest_2() 찾아서 인스턴스를 만들어 준다
		System.out.println("cj_2 참조변수 >>> : " + ct_2);
		System.out.println("cj_2.i >>> : " + ct_2.i);
		System.out.println("cj_2.s >>> : " + ct_2.s);
	} //end of main() function
} // end of ConstTest_2 class
/*
C:\00.KOSMO129\10.JExam\ch1>javap a.b.c.ch1.ConstTest_2
Compiled from "ConstTest_2.java"
public class a.b.c.ch1.ConstTest_2 {
  int i;
  java.lang.String s;
  public a.b.c.ch1.ConstTest_2();
  public static void main(java.lang.String[]);
}

C:\00.KOSMO129\10.JExam\ch1>
*/