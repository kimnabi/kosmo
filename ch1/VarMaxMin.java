package a.b.c.ch1;

public class VarMaxMin {
	/*  1. int : 기초자료형 인트 정수 크기가 4byte(32bit) default value 0
			     int의 Wrapper class java.lang.Integer
			     java.lang.Intger MAX_VALUE 상수(constant value)에 
				 인트 맥스값이 저장되어 있다.
				 상수는 변수명은 꼭 대문자를 사용하고 합성어를 사용하려면 
			     언더스코어를 사용한다.
				 public static final 자료형 변수명 = 값;
		2. int_max : 변수명 identifier : 변수명 첫 번째 글자는 소문자 이다.
		3. = : 대입 연산자
		4. Integer.MAX_VALUE : java.lang 패키지에 있는 Integer Wrapper class 이다.
							   MAX_VALUE : 인티저 클래스에 있는 상수이다. 
			                   기초 자료형 int의 MAX 값을 저장하고 있다. 
			                   MAX_VALUE 를 사용할 때는 
							   클래스이름.상수(Integer.MAXVALUE) 로 사용한다. 
			                   이렇게 사용하면 상수 값 2147483647 이 
			                   대입된다, 리턴한다, 불러온다.... 
							   int int_max = Integer.MAX_VALUE;
							   int int_max = 2147483647;
							   위 두 문장은 같은 의미이다. */
	public static void main(String[] args) 
	{
		int int_max = Integer.MAX_VALUE;
		System.out.println(int_max);
		
		// 2147483647
		int i = 2147483647;
		System.out.println(i);
		// java.lang 패키지에 있는 Integer Wrapper class 이다.
		// MIN_VALUE : 인티저 클래스에 있는 상수값 -2147483647 
		// 기초 자료형 int의 MIN 값을 대입된다
		int int_min = Integer.MIN_VALUE;
		//java.lang 패키지에 있는 System 클래스에 있는 println 함수에서 int_min를 호출한다
		System.out.println(int_min);

		// -2147483647
		int ii = -2147483647;
		//java.lang 패키지에 있는 System 클래스에 있는 println 함수에서 ii를 호출한다 
		System.out.println(ii);
	}// end of main function
} // end of VarMaxMin class 
