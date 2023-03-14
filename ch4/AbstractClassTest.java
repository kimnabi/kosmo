/**
 * 
 */
package a.b.c.ch4;

import java.text.SimpleDateFormat;
import java.util.Date;

import a.b.c.common.DateFormatUtil;

/**
 * @author kasmo
 *
 */
public class AbstractClassTest extends AbstractClass {

	public AbstractClassTest() {
		System.out.println("AbstractClassTest() 생성자 >>> : ");
	}
	// 추상 클래스의 추상함수는 
	// 추상클래스를 extends 키워드로 상속해서 
	// 추상함수를 override 해서 사용한다. 
	
	// @ : 어노테이이션 : 자바에서 사용하는 기술 이름 
	// 1. 주석 : 해당 기능을 설명하는 역활 
	// 2. 기능을 구현 : 실제로 클래스 및 인터페이스를 이용해서 기능이 구현 된다.
	@Override // 오버라이드 어노테이션 Annotation : 부모(상위)클래스에서 가져온 함수이다.
	public void abstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("abstractMethod() >>> : 부모 클래스 재정의 ");
	} //end of abstractMethod
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 추상클래스는 new 연산자로 사용할 수 없다.
		// 추상클래스는 new 연산자로 인스턴스를 할 수 없다.
		// AbstractClass ab = new AbstractClass();
		// AbstractClassTest 클래스 인스턴스 생성 하고 
		// AbstractClassTest 사용자 정의 타입 act 참조 변수에  주소값 할당
		AbstractClassTest act = new AbstractClassTest();
		// 참조변수 act에 접근연산자 로 abstractMethod() 호출한다 
		act.abstractMethod();
		// 회원번호 만들기 
		//Date 인스턴스 생성하고 참조변수 d에 new 키워드를 통해 메모리에 새로운 저장공간을 할당하고 주소
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		String ymd = sdf.format(d);
		System.out.println("ymd >>> : " + ymd);
		String mnum = AbstractClass.BIZ_GUBUN_MEMBER + ymd + "0001";
		System.out.println("mnum >>> : " + mnum);
//			String mnum = AbstractClass.BIZ_GUBUN_MEMBER + "20230310" + "0001";
		// 게시판 번호 만들기 
				String bnum = AbstractClass.BIZ_GUBUN_BORDER 
								+ DateFormatUtil.ymdFormat()
								+ "0001";
				System.out.println("bnum >>> : " + bnum);
	} //end of main
} //end of AbstractClassTest class
		

			
			
		

