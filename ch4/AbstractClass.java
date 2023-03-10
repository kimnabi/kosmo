package a.b.c.ch4;

// class 키워드 앞에 abstract 키워드를 붙이면 추상 클래스라고 한다.
// 추상클래스에서는
// 추상함수, 일반함수를 같이 사용할 수 있다.
public abstract class AbstractClass {
	
	// 상수 
	public static final String BIZ_GUBUN_MEMBER = "M"; // 회원번호 구분자
	public static final String BIZ_GUBUN_BORDER = "B"; // 게시판 구분자	
	
	// 함수에 abstract 키워드가 붙으면 추상함수 라고 한다.
	// 추상함수는 {} 브레이스 블럭 을 가지고 있지 않는다.
	public abstract void abstractMethod();
	
	public static void aM() {
		System.out.println("추상 클래스에 있는 aM() 일반함수 ");
	}
}
