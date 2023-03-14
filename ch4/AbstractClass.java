/**
 * 
 */
package a.b.c.ch4;

/**
 * 
 * 
 * @author 김정환
 *
 */
// class 키워드 앞에 abstract 키워드를 붙이면 추상 클래스라고 한다.
// 추상클래스에서는
// 추상함수, 일반함수를 같이 사용할 수 있다.
public abstract class AbstractClass extends java.lang.Object {

	// 상수 
	public static final String BIZ_GUBUN_MEMBER = "M"; // 회원번호 구분자
	public static final String BIZ_GUBUN_BORDER = "B"; // 게시판 구분자	
	

	/**
	 * 
	 * 생성자 
	 */
	public AbstractClass() {
		// TODO Auto-generated constructor stub
		System.out.println("AbstractClass() 생성자 >>> : ");
	}
		
	public abstract void abstractMethod();
		
		// 일반함수
	public static void aM() {
			System.out.println("추상 클래스에 있는 aM() 일반함수 ");
	} // end of aM
} //end of AbstractClass class


