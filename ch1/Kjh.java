package a.b.c.ch1;

public class Kjh {
	// 사용자 정의 class kjh의 맴버변수 지정
	byte b;
	char c;
	short s;
	int i;
	long l;
	float f;
	double d;
	boolean bool;

	String str;

	public static void main(String[] args) {

		int i = 1;
		// 사용자 정의 클래스 Kjh 지역변수이면서 참조변수 kj은  
		// new 키워드를 이용하여 왼쪽에 선언한 사용자 정의 클래스 Kjh를 메모리에 올린다고 요청 한다
		// 생성자 Kjh() 를 찾아서 인스턴스(객체 생성) 한다
		// 객체 생성시 멤버변수를 default 값으로 초기화 한다
		Kjh kj = new Kjh();	
		// kj 의 위치값를 출력 한다
		System.out.println("kj >>> :" + kj);
		// kj의 맴버변수인 byte 자료형 b를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.b >>> :" + kj.b);
		// kj의 맴버변수인 char 자료형 c를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.c >>> :" + kj.c);
		// kj의 맴버변수인 short 자료형 s를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.s >>> :" + kj.s);
		// kj의 맴버변수인 int 자료형 i를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.i >>> :" + kj.i);
		// kj의 맴버변수인 long 자료형 l를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.l >>> :" + kj.l);
		// kj의 맴버변수인 float 자료형 f를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.f >>> :" + kj.f);
		// kj의 맴버변수인 double 자료형 d를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.d >>> :" + kj.d);
		// kj의 맴버변수인 boolean 자료형 bool를 호출해서 값을 콘솔에 출력한다.
		System.out.println("kj.bool >>> :" + kj.bool);
		
		Kjh kj_1 = new Kjh();
		// 선언된 사용자 정의 kjh 클래스 의 인스턴스 한 참조 변수 kj_1을 호출해서 콘솔에 출력 한다
		System.out.println("kj_1 참조변수의 주소값 >>> : " + kj_1);
	} //end of main function
} // end of Kjh class
