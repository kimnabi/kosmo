package a.b.c.ch4;
/** 
 * 회원 정보를 명령어행 인수로 입력 받아서 콘솔에 출력 하기
 * 회원 정보 : 이름, 이메일, 전화번호, 주소 
 * */
public class TestMember3 {
	
	// 기본생성자
		public TestMember3() {
			
		}
		
		public int memInsert(MemberVO mvo) {
			System.out.println("TestMember_2.memInsert mvo.getName() >>> : " 	+ mvo.getName());
			System.out.println("TestMember_2.memInsert mvo.getEmail() >>> : " 	+ mvo.getEmail());
			System.out.println("TestMember_2.memInsert mvo.getHp() >>> : "	 	+ mvo.getHp());
			System.out.println("TestMember_2.memInsert mvo.getAddr() >>> : " 	+ mvo.getAddr());
			
			MemberDAO mdao = new MemberDAOImpl();//
			mdao.memInsert(mvo);
			
			return 0;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("main() :: args[0] >>> : " + args[0]);
		// 이름 : 한글
		// 이메일 : 영문
		// 전화번호 : 핸드폰 번호
		// 주소 : 시도, 동 이름만 
		// String 타입 참조변수 s0 가  문자열 배열의길이 4개 할당하고 리터럴 문자열 4개로 초기화한다
	//	String s0[] = {"김정환","kij@naver.com","01100020000","서울시금천구 가산동"};
		// String 타입 참조변수 s1 가 문자열 배열의길이 4개 할당하고  리터럴 문자열 4개 로 초기화한다
	//	String s1[] = {"홍한솔","hhs@naver.com","01098750000","경기도 김포시 양촌읍"};
		// 사용자정의 TestMember2 클래스 참조변수 tm_0 가 생성자 TestMember2클래스  인스턴스 하고
		// 참조변수 s0 가르키는 객체 문자열 요소들의 값를 호출하여 TestMember2  생성자의 매개변수들에 바인딩 한다
//		TestMember3 tm_2 = new TestMember3();
//		MemberVO mvo = null; // GC 무분별한 리소스 문제 대비하기위한 코드 
//		// 문자열를 담기위한 객체 생성 
//		mvo = new MemberVO(); // MemberVO mvo = new MemberVO();
//		mvo.setName(s0[0]); // 참조변수s0 가르키는 문자열 요소들 중 index가 0번째 요소의 값를으로 초기화  
//		mvo.setEmail(s0[1]);// 참조변수s0 가르키는 문자열 요소들 중 index가 1번째 요소의 값를으로 초기화  
//		mvo.setHp(s0[2]);
//		mvo.setAddr(s0[3]);
//		tm_2.memInsert(mvo);
//		//MemberVO mvo1 = new MemberVO();
//		//TestMember2 tm1_2 = new TestMember2();
//		mvo.setName(s1[0]);
//		mvo.setEmail(s1[1]);
//		mvo.setHp(s1[2]);
//		mvo.setAddr(s1[3]);
//		tm_2.memInsert(mvo);
		//분기 플래그 
		String isudFlag = args[0];               //명령어행인수 한개 받아 초기화 한다	
		// public String toUpperCase()
		isudFlag = isudFlag.toUpperCase(); // 받은 문자
		System.out.println("isudFlag >>> : " + isudFlag);
		
		if ("I".equals(isudFlag)) {
			System.out.println("입력 isudFlag >>> : " + isudFlag);
			
			String s0[] = {"홍한솔", "hhs@naver.com", "01098750000", "경기도 김포시 양촌읍"};
//			String s1[] = {"이민호", "lmh@gmail.com", "01096980000", "서울시 금천구 독산동"};
		
			MemberVO mvo = null;
			mvo = new MemberVO();	
			mvo.setName(s0[0]);
			mvo.setEmail(s0[1]);
			mvo.setHp(s0[2]);
			mvo.setAddr(s0[3]);
			
			TestMember3 tm_3 = new TestMember3();
			tm_3.memInsert(mvo);
		}
		if ("S".equals(isudFlag)) {
			System.out.println("조회 isudFlag >>> : " + isudFlag);
		}
		if ("U".equals(isudFlag)) {
			System.out.println("수정 isudFlag >>> : " + isudFlag);
		}
		if ("D".equals(isudFlag)) {
			System.out.println("삭제 isudFlag >>> : " + isudFlag);
		}
	}

}
