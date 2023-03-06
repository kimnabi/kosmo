package a.b.c.ch1;

public class StaticTest {
	
	public static final String BIZ_GUBUN_MEMBER = "M";
	
	
	int i;
	// static 변수(클래스 변수), 일반 변수, 자료형 정수 int
	static int ii;

	public static void main(String[] args) {
		System.out.println("main() 함수 시작 >>> : ");

		StaticTest st = new StaticTest();
		System.out.println("st 참조변수 >>> : " + st );
		System.out.println("st.i >>> : " + st.i);
		// static 변수 참조 사용하기
		// 패키지명 + 클래스이름 + 변수 이름 = a.b.c.ch1.StaticTest.ii
		System.out.println("a.b.c.ch1.StaticTest.ii >>> : " + a.b.c.ch1.StaticTest.ii);
		System.out.println("StaticTest.ii >>> : " + StaticTest.ii);
		System.out.println("ii >>> : " + ii);

		// 상수를 호출하는 방법 
		System.out.println("StaticTest.BIZ_GUBUN_MEMBER >>> : " 
								+ StaticTest.BIZ_GUBUN_MEMBER);
	}// end of main() function
} //end of StaticTest class
