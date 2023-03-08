package a.b.c.ch3;

public class IfTest_5 {

	public static void main(String[] args) {

		// java.lang.String 
		// public boolean equals(Object anObject)
		// 문자열 비교하는 함수

		String s0 =  /*new String(*/"abc"/*)*/; // => 상수풀에 저장해
		String s1 = "abc";
		String s2 = new String("abc"); //명시적으로 new 키워드를 통해 String("abc") 인스턴스 생성 하고 
		//s2 참조변수에 그 인스턴스의 주소값 대입하여 선언 한다
		String s3 = new String("abc"); //명시적으로 new 키워드를 통해 또다른 String("abc") 인스턴스 생성 하고 
		//s2 참조변수에 그 인스턴스의 주소값 대입하여 선언 한다
		// s0 참조변수를 호출하여 콘솔에 출력한다 -- s0은 상수풀에 있는 해쉬 주소값를 가진다 
		System.out.println("s0 >>>: " + s0 + " :: " + System.identityHashCode(s0));
		// s1 참조변수를 호출하여 콘솔에 출력한다 -- s1은 상수풀에 있는 해쉬 주소값를 공유한다 
		System.out.println("s1 >>>: " + s1 + " :: " + System.identityHashCode(s1));
		// s2 참조변수를 호출하여 콘솔에 출력한다 -- s2은 메모리에 올라온 인스턴스 해쉬 주소값를 가진다 
		System.out.println("s2 >>> : " + s2 + " :: " + System.identityHashCode(s2));
		// s3 참조변수를 호출하여 콘솔에 출력한다 -- s3은 메모리에 올라온 또다른 인스턴스 해쉬 주소값를 가진다 
		System.out.println("s3 >>> : " + s3 + " :: " + System.identityHashCode(s3));
		
		boolean b0 = s0 == s1; //s0 참조변수와 s1 참조변수의 주소값을 비교
		System.out.println("b0 >>> : " + b0); // true

		boolean b1 = s0.equals(s1); //s0 의 문자열 와 s1 문자열 을 비교
		System.out.println("b1 >>> : " + b1); // true

		boolean b2 = s2 == s3; //s2 참조변수와 s3 참조변수의 주소값을 비교
		System.out.println("b2 >>> : " + b2); // false

		boolean b3 = s2.equals(s3);  //s2 의 문자열 와 s3 문자열 을 비교
		System.out.println("b3 >>> : " + b3); // true
		
		boolean b4 = s0 == s3; //s0 참조변수와 s3 참조변수의 주소값을 비교
		System.out.println("b3 >>> : " + b4); // false
		
		boolean b5 = s0.equals(s3);  //s0 의 문자열 와 s3 문자열 을 비교
		System.out.println("b3 >>> : " + b5); // true
		
	}// end of main
}//end of IfTest_5 class
