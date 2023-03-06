package a.b.c.ch2;

public class StringTest_1 {
	public static void main(String[] args) {
		//지역변수 String s 은 리터럴 빈문자열
		//인스턴스 하는 참조변수 아님
		String s = "";
		
		System.out.println("s >>> "+ s ); // 빈문자 그대로 콘솔에 출력
		System.out.println("s.length() >>>" + s.length());//빈 문자열의길이는 0 이다
		//인스턴스를 하는 참조변수가 없다는 말이다
		// NullPointer
		String s1 = null;
		
		//System.out.println("s1 >>> "+ s1); 
		//System.out.println("s1.length() >>>" + s1.length()); //참조 변수가 없으므로 s1문자열의 길이는 알수없으며 런타임 에러가 난다

		/*C:\00.KOSMO129\10.JExam\ch2>java a.b.c.ch2.StringTest_1
		s >>>
		s.length() >>>0
		s1 >>> null
		Exception in thread "main" java.lang.NullPointerException
        at a.b.c.ch2.StringTest_1.main(StringTest_1.java:14) */
		
		String s2 = null;
		//String s2 = "asd";
		//String 자료형 s2  참조변수 가 인스턴스 있거나 문자열의 길이도 0 이상
		if(s2 != null && s2.length() > 0) {
			System.out.println("s2 >>> "+ s2); 
		} // end of if  -->


	} // end of main function
} //end of StringTest_1 class
