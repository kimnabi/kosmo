package a.b.c.ch3;

public class IfTest_3 {

	

	public static void main(String args[]) {

		// java.lang.String equals() 함수 문자열을 비교하는 함수 
		
		// == : 상등연산자, 등가연산자 
		//	  : 숫자를 비교하는 연산자 
		//		결과는 true false 리턴 		
		System.out.println("+ 16진수 >>> : 0x" + Integer.toHexString('+'));
		System.out.println("- 16진수 >>> : 0x" + Integer.toHexString('-'));
		System.out.println("* 16진수 >>> : 0x" + Integer.toHexString('*'));
		System.out.println("/ 16진수 >>> : 0x" + Integer.toHexString('/'));

		boolean b1 = '+' == 0x2b;
		System.out.println("b1 >>> : " + b1);
		// if (b1)
		if ('+' == 0x2b)
		{
			System.out.println( 1 + 2 );
		}
		
		char c = '+';
		boolean b2 = c == 0x2b;
		System.out.println("b2 >>> : " + b2);
		if (c == 0x2B)
		{
			System.out.println( 1 + 2 );
		}
		
		String s = "+";
		// public char charAt(int index)
		char cS = s.charAt(0); // 문자열s 에서 '+'
		boolean b3 = cS == 0x2b;
		System.out.println("b3 >>> : " + b3);
		if (cS == 0x2b)
		{
			//System.out.println( 1 + 2 );
			System.out.printf("1 + 2 = %d 입니다.%n",1 + 2);
		} //end of if
		
		//빼기
		String s1 = "-";
		// public char charAt(int index)
		char cS_1 = s1.charAt(0); // 문자열배열 "-"를 0번째 index의 문자를 반환한다 
		//char 문자 '-' 의 아스키코드 16진수 0x2d(0x2B)
		//char cS_1 ('-') 와 16진수 0x2d 같다는 논리식
		// 지역변수 boolean 형 b4 에 cS_1 == 0x2d 논리식의 결과값를 대입한다
		boolean b4 = cS_1 == 0x2d; 
		// 콘솔에 b4를 호출하여 출력한다
		System.out.println("b4 >>> : " + b4);
		if (b4)
		{
			// 콘솔에 리터럴 연산 1 - 2 를 호출하여 출력한다
			//System.out.println(1 - 2);
			System.out.printf("1 - 2 = %d 입니다.%n",1 - 2);
		} //end of if
		//곱하기
		String s2 = "*";
		// public char charAt(int index)
		char cS_2 = s2.charAt(0); // 문자열배열 "-"를 0번째 index의 문자를 반환한다 
		//char 문자 '*' 의 아스키코드 16진수 0x2a(0x2A)
		//char cS_2 ('*') 와 16진수 0x2d 같다는 논리식
		// 지역변수 boolean 형 b5 에 cS_2 == 0x2a 논리식의 결과값를 대입한다
		boolean b5 = cS_2 == 0x2a; 
		if(b5)
		{
			// 콘솔에 리터럴 연산 1 * 2를 호출하여 출력한다
			//System.out.println(1 * 2);
			System.out.printf("1 * 2 = %d 입니다.%n",1 * 2);
		}// end if
		//나누기
		String s3 = "/";
		// public char charAt(int index)
		char cS_3 = s3.charAt(0); // 문자열배열 "-"를 0번째 index의 문자를 반환한다 
		//char 문자 '/' 의 아스키코드 16진수 0x2f(0x2F)
		//char cS_3 ('/') 와 16진수 0x2d 같다는 논리식
		// 지역변수 boolean 형 b6 에 cS_3 == 0x2f 논리식의 결과값를 대입한다
		boolean b6 = cS_3 == 0x2f; 
		// 
		if(b6)
		{
			// 콘솔에 리터럴 연산 1 / 2를 호출하여 출력한다
			//System.out.println(1 / 2);
			System.out.printf("1 / 2 = %d 입니다.%n",1 / 2);
		}// end if 
	
	} //end of main
} //end of IfTest_3 class