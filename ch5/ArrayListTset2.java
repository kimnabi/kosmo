package a.b.c.ch5;

import java.util.ArrayList;

public class ArrayListTset2 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList aList = new ArrayList(3);
		// public boolean add(E e) : jdk 1.8
		// public boolean add(Object o) : jdk 1.4 
		aList.add("abc");
		aList.add('a');
		aList.add(3);
		aList.add("4번째 데이터");
		for (int i=0; i < aList.size(); i++) {
			System.out.println("aList.get(" + i + ") >>> : " + aList.get(i));
		}

		// public E get(int index) : jdk 1.8
		// public Object get(int index) : jdk 1.4
		//Object o = aList.get(0);
		String o = (String) aList.get(0); //컴파일 에러 : aList.get(0)의 리턴 데이타타입이 Object이다
		String s = (String)o;    //Object 클래스가 String 클래스의 부모클래스이자 상속관계로써  String 자식클래스로 다운캐스팅 해야한다
								 //강제 형변환을 해줘야한다  :: Sting 자료형 s에 대입하기위해 데이타형이 같아야 한다						
		System.out.println("s >>> : " + s); // 반면 자식클래스는 부모클래스로 업캐스팅 한다 (형변환 하지않아도 된다)
		String s1 = (String)aList.get(0);
		System.out.println("s1 >>> : " + s1);
		//========================================================================
//		에러가 나는 이유 
//		String s = aList.get(0);
//		0. java.lang.Object 와 java.lang.String 은 다른 데이터 형이다.
//		1. aList.add("abc") : 
//			"abc" 문자열 String 을 ArrayList 에 넣었다.	
//		   	"abc" 문자열 String 데이터가 Object 로 변경된다.?? 
//		2. aList.get(0) 이 가르키는 데이터는 "abc"  이다. 
//			리턴형이 Object  
//		 	get() 함수의 리턴형이 Object 이다. 
//		3. String 자료형에 Object 형을 대입 하려고 하는데 데이터형이 달라서 오류 가 난다.
//      4. 데이터를 같은 형 String 으로 동일하게 형변환 한다.		
//		String s = (String)aList.get(0);		
//========================================================================
		// 'a' 콘솔에 프린트 하기
//		char c = aList.get(1); // char 는 기초 자료형 데이타이므로 클래스 자료형이 아니다 그래서 char의 Wapper 클래스인 Character로 Boxing해서 변환한다
		Object aList1_Object = aList.get(1); // Object 클래스가 Character 클래스의 부모클래스이자 상속관계로써  Character 자식클래스로 다운캐스팅 해야한다
		Character aList1_Character = (Character)aList1_Object; // 강제 형변환을 해줘야한다  :: Character 자료형 aList1_Character 에 대입하기위해 데이타형이 같아야 한다
		//char c = (char)aList1_Character;                       // 그리고 컴파일러가 내부적으로 오토 upBoxing해서 char 기초자료형으로 형변환한다 
		char c1 =  aList1_Character;                       // 그리고 컴파일러가 내부적으로 오토 upBoxing해서 char 기초자료형으로 변환해서 
		System.out.println("c >>> : " + c1);				// char c1 에 대입한다		
		//public static String valueOf(Object obj) 
		String cV = String.valueOf(aList1_Object); //Character aList1_Character 클래스가 valueOf의  매개변수 Object 형 의 자식클래스이므로 자동 형변환 된다
		System.out.println("cV >>> : " + cV);
		
		// 3 콘솔에 프린트 하기
		// int i = aList.get(2); //int 는 기초 자료형 데이타이므로 클래스 자료형이 아니다 그래서 int의 Wapper 클래스인 Integer로 Boxing해서 변환한다
		Object aList2_Object = aList.get(2); // 리턴 Object 클래스가  클래스의 부모클래스이자 상속관계로써  Integer 자식클래스로 다운캐스팅 해야한다
		Integer aList2_Integer = (Integer)aList2_Object; // 강제 형변환을 해줘야한다  :: Sting 자료형 s에 대입하기위해 데이타형이 같아야 한다
		//int i = (int)aList2_Integer;
		int ii = aList2_Integer; // 그리고 컴파일러가 내부적으로 오토 upBoxing해서 int 기초자료형으로 변환해서 int ii에 대입한다 
		System.out.println("i >>> : " + ii);
		
		String iV = String.valueOf(aList2_Object);
		System.out.println("iV >>> : " + iV);
	//	valueOf
		// "4번째 데이터" 콘솔에 프린트 하기
//		String s1 = aList.get(3);
		Object aList3_Object = aList.get(3);
		String aList3_String = (String)aList3_Object;
		System.out.println("aList3_String >>> : " + aList3_String);
		
		String s1V = String.valueOf(aList3_Object);
		System.out.println("s1V >>> : " + s1V);		
	}//end of main
}// end of ArrayListTset1 class

