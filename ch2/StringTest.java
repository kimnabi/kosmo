package a.b.c.ch2;

public class StringTest {
	public static void main(String[] args) {
		// String : 빌트인 클래스 java.lang.String
		// s 은 지역변수 이며 참조변수 이다
		String s = "abc";
		// 위 라인에서 선언한 String 클래스의 지역변수 s 를 호출해서 
		// 콘솔에 println() 함수를 이용해서 출력한다. 
		System.out.println(s);
		// 위 라인에서 선언한 String 클래스의 지역변수 s 를 호출해서 
		// 콘솔에 printf() 함수에 %s 문자 서식을 이용해서 출력한다.
		System.out.printf("%s", s);

		int sLen = s.length();
		System.out.println("s.length() >>> : " + sLen);
		//문자열에서 index 값으로 문자를 리턴하는 함수 charAt(int index)
		char s_0 = s.charAt(0); // "abc"에서 'a' 반환 한다
		char s_1 = s.charAt(1); // "abc"에서 'b' 반환 한다
		char s_2 = s.charAt(2); // "abc"에서 'c' 반환 한다

		System.out.println("char s_0 >>> : " + s_0);
		System.out.println("char s_1 >>> : " + s_1);
		System.out.println("char s_2 >>> : " + s_2);

		String ss = "  abc      ";
		System.out.println("s >>> : "+ ss);
		int ssLen = ss.length();
		System.out.println("slen >>> " + ssLen);
		
		String s1 = "abc";
		System.out.println("s1 >>> : " + s1);
		int s1Len = s1.length();
		System.out.println("s1Len >>> : " + s1Len);
		//c_0 c_1 c_2 를 16진수로 콘솔에 출력하시요
		char c_0 = s1.charAt(0); // 문자열 "abc" 에서  index 0 위치인 'a'가 반환 된다
		// public static String toHexString(int i)
		// return String toHexString(int i) 매개변수를 int 자료형 i 를 받아 Int 값를 16진수 문자가 변환되어 리턴 된다
		System.out.println("16진수 c_0 >>> : 0x" + Integer.toHexString(c_0));
		char c_1 = s1.charAt(1);  // 문자열 "abc" 에서  index 1 위치인 'b'가 반환 된다
		System.out.println("16진수 c_1 >>> : 0x" + Integer.toHexString(c_1));
		char c_2 = s1.charAt(2);  // 문자열 "abc" 에서  index 2 위치인 'c'가 반환 된다
		System.out.println("16진수 c_2 >>> : 0x" + Integer.toHexString(c_2));
	}// end of main function
}// end of StringTest class

