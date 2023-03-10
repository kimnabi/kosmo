package a.b.c.ch3;
	//명령행 인수 
	//String args[] ={"54321","111","222"}
	//런타임시 인자를 없을때 java.lang.ArrayIndexOutOfBoundsException: 0 예외처리가 발생된다
	// 프로그래머가 직접 예측하여 막을 수 있는 처리가능한 오류 VS 에러
	/*c:\kosmo\ch3>java a.b.c.ch3.IfTest_4
	main() 함수 시작 >>> :
	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        at a.b.c.ch3.IfTest_4.main(IfTest_4.java:8) */
public class IfTest_4 {
	public static void main(String[] args) {
		System.out.println("main() 함수 시작 >>> : ");
		
		/*c:\kosmo\ch3>java a.b.c.ch3.IfTest_4 32 12 123
		main() 함수 시작 >>> :
		main() 함수 >>> : 32
		main() 함수 >>> : 12
		main() 함수 >>> : 123 */
		System.out.println("main() 함수 >>> : " + args[0]);
		System.out.println("main() 함수 >>> : " + args[1]);
		System.out.println("main() 함수 >>> : " + args[2]);

		String s0 = args[0];
		String s1 = args[1];
		String s2 = args[2];

		System.out.println("s0 >>> : " + s0);
		System.out.println("s1 >>> : " + s1);
		System.out.println("s2 >>> : " + s2);
		
		char s0C = s0.charAt(0); // char charAt(0) 문자열에서 char 형 (한개의문자)로 리턴한다
		System.out.println("s0 charAt(0) >>> : " + s0C);
		System.out.println("s0 charAt(0) >>> : " + (int)s0C);
				
		System.out.println("s1 >>> : " + (int) s1.charAt(0)); //아스키코드
		System.out.println(String.valueOf(s1));
	} //end of main
} //end of IfTest_4 class
