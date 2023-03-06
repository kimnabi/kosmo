package a.b.c.ch1;

public class ConstTest_3 {
	// ConstTest_3 의 맴버 변수 
	// 인스턴스 할때 int 자료형의 디폴트값을 세팅 한다
	// 인스턴스 할때 String 자료형의 디폴트값을 세팅 한다
	int i;
	String s;

	// 기본 생성자 
	// 개발자가 코드를 기술한 것 
	// 생성자 오버로딩
	public ConstTest_3() {
		System.out.println("ConstTest_3() 생성자 시작 >>> : ");
		//생성자가 인스턴스 할때 ConstTest_3 의 멤버변수 i 와 s 은 디폴트값으로 세팅한다
	}

	public ConstTest_3(int i) {
		System.out.println("ConstTest_3(int i) 생성자 시작 >>> ");
		// 매개변수 int 자료형 i 선언하고 아규먼트 리터럴 i를 받는 생성자 함수 이다
		// 생성자가 인스턴스 할때 ConstTest_3 의 아규먼트 i를 맴버 변수 int i에 초기화 할수 있다
		 this.i  =  i ;
		// 맴버변수 String 자료형 s은 바인딩되는 아규먼트가 없으므로 디폴트 값으로 세팅한다
		System.out.println("ConstTest_3(int i) 매개변수 >>> : " + i);
	}

	public ConstTest_3(String s) {
		System.out.println("ConstTest_3(String s) 생성자 시작 >>> : ");
		//매개변수 String 자료형 s 선언하고 아규먼트 문자열 s를 받는 생성자 함수 이다
		System.out.println("ConstTest_3(String s) 생성자 매개변수 >>> : " + s);
	}

	public ConstTest_3(int i, String s) {
		System.out.println("ConstTest_3(int i, String s) 생성자 시작 >>> : ");
		//매개변수 int 자료형 i, String 자료형 s을 선언하고 아규먼트 리터럴 i , 문자열 s를 받는 생성자 함수 이다
		System.out.println("ConstTest_3(int i, String s) 생성자 매개변수 >>> : " + i);
		System.out.println("ConstTest_3(int i, String s) 생성자 매개변수 >>> : " + s);
	}

	public ConstTest_3(String s, int i) {
		System.out.println("ConstTest_3(String s, int i) 생성자 시작 >>> : ");
		System.out.println("ConstTest_3(String s, int i) 생성자 매개변수>>> : " + i);
		System.out.println("ConstTest_3(String s, int i) 생성자 매개변수 >>> : " + s);
	}


	public static void main(String args[]) {

		System.out.println("main() 함수 시작 >>> : ");
		
		ConstTest_3 ct_3 = new ConstTest_3();
		System.out.println("ct_3 참조변수 >>> : " + ct_3);
		System.out.println("ct_3.i >>> : " + ct_3.i);
		System.out.println("ct_3.s >>> : " + ct_3.s);

		ConstTest_3 ct_3_1 = new ConstTest_3(25);
		System.out.println("ct_3_1 참조변수 >>> : " + ct_3_1);
		System.out.println("ct_3_1.i >>> : " + ct_3_1.i);
		System.out.println("ct_3_1.s >>> : " + ct_3_1.s);
		ConstTest_3 ct_3_2 = new ConstTest_3("조수연");
		ConstTest_3 ct_3_3 = new ConstTest_3(28, "심은섭");
		ConstTest_3 ct_3_4 = new ConstTest_3("백연수", 28);

	} // end of main() function

} // end of ConstTest_3 class