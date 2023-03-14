package a.b.c.ch4;
/** 
 * 회원 정보를 입력 받아서 콘솔에 출력 하기
 * 회원 정보 : 이름, 이메일, 전화번호, 주소
 * name "홍한솔"
 * email "hhs@naver.com"
 * hp  "01098750000"
 * addr "경기도 김포시 양촌읍" 
 * */
public class TestMember1 {
	String name;       // 멤버변수 String 타입 참조변수 선언
	String email;
	String hp;
	String addr;
	// 기본 매개변수 없는 생성자
	public TestMember1() {
		
	} // end of TestMember2
	// 매개변수 있는 생성자 오버로딩 :인스턴스시 초기화
	public TestMember1(String name,String email,String hp,String addr) {
		System.out.println("	TestMember1.name >>> : " +name);
		System.out.println("	TestMember1.email >>> : " +email);
		System.out.println("	TestMember1.hp >>> : " +hp);
		System.out.println("	TestMember1.addr >>> : " +addr);
				
		this.name = name; 	// this 는 TestMember2 인스턴스 가르키는 참조변수 로서
		this.email = email; // 같은 패키지내의 TestMember2 멤버변수를 접근연산자를 통해 호출하여 
		this.hp = hp;       // 생성자의 매개변수로 바인딩한다
		this.addr = addr;
	} //end of TestMember2
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		// 이름 : 한글
	    // 이메일 : 영문
		// 전화번호 : 핸드폰 번호
		// 주소 : 시도, 동 이름만
		//String 타입 참조변수 s0 가  문자열 배열의길이 4개 할당하고 리터럴 문자열 4개로 초기화한다
		String s0[] = {"김정환","kij@naver.com","01100020000","서울시금천구 가산동"};
		//String 타입 참조변수 s1 가 문자열 배열의길이 4개 할당하고  리터럴 문자열 4개 로 초기화한다
		String s1[] = {"홍한솔","hhs@naver.com","01098750000","경기도 김포시 양촌읍"};
		// 사용자정의 TestMember2 클래스 참조변수 tm_0 가 생성자 TestMember2클래스  인스턴스 하고
		// 참조변수 s0 가르키는 객체 문자열 요소들의 값를 호출하여 TestMember2  생성자의 매개변수들에 바인딩 한다
		TestMember1 tm_0 = new TestMember1(s0[0],s0[1],s0[2],s0[3]);
		
		System.out.println("main() :: tm_0.name >>>" +tm_0.name);
		System.out.println("main() :: tm_0.email >>>" +tm_0.email);
		System.out.println("main() :: tm_0.hp >>>" +tm_0.hp);
		System.out.println("main() :: tm_0.addr >>>" +tm_0.addr);
		
		// 사용자정의 TestMember2 클래스 참조변수 tm_1 가 생성자 TestMember2클래스  인스턴스 하고
		// 참조변수 s1 가르키는 문자열의배열 공간의 값를 호출하여TestMember2  생성자의 매개변수들에 바인딩 한다
		TestMember1 tm_1 = new TestMember1(s1[0],s1[1],s1[2],s1[3]);

		System.out.println("main() :: tm_1.name >>>" +tm_1.name);
		System.out.println("main() :: tm_1.email >>>" +tm_1.email);
		System.out.println("main() :: tm_1.hp >>>" +tm_1.hp);
		System.out.println("main() :: tm_1.addr >>>" +tm_1.addr);
			
	}

}
