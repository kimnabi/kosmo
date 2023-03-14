package a.b.c.ch5;

import java.util.ArrayList;

public class ArrayListTset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 안의 요소들이 서로 다른 데이타 타입를  가질수 있어서 형변환 문제가 나올수있기  때문에
		//제네릭 타입을 써서 미리 데이타타입를 알려줘서 컴파일시 이나 런타임시 에러 발생 대비
		// 제네릭스를 사용하지 않은 경우 >
		// 모든타입을 "add(Object)" Object형으로 List에 Add를 
        // 시켜 주므로, List에서 자료를 꺼내올때는 각각에 맞는 형병환을
		// 꼭 해주어야 하기 때문에 번거 롭다.
		// 데이터타입 ArrayList 클래스  aList 참조변수가 ArrayList 클래스 인스턴스 선언
		// ArrayList 클래스 요소들의 데이타타입 으로 String 타입으로 설정한다 :제네릭 타입
		ArrayList<String> aList = new ArrayList<String>();
		System.out.println("aList >>> : " + aList); //디폴트값으로 주소값 대신 디폴트 배열값이 반환
		System.out.println("aList >>> : " + System.identityHashCode(aList)); //  ArrayList() 인스턴스의 주소값
		// public int size()
		System.out.println("aList.size() >>> : " + aList.size()); // aList 가 가르키는 ArrayList() 인스턴스 의 size() 접근하여 
																  // ArrayList() 의 요소들의 합을 반환
		
		// public boolean add(E e) : jdk 1.8
		// public boolean add(Object o) : jdk 1.4 
		boolean b_0 = aList.add("이승현");//  ArrayList() 의 한개 요소을  순차적으로 추가한다 aList.add("이승현") : 
//		boolean b_0 = aList.add("이승현");       // ArrayList() 안에 한개의 요소에"이승현" 문자열를 추가한다
		System.out.println("b_0 >>> : " + b_0);
		System.out.println("aList >>> : " + aList);		//  ArrayList() 인스턴스의 주소값
		System.out.println("aList.size() >>> : " + aList.size());  // ArrayList() 의 요소들의 합을 반환
		

//		boolean b_1 = aList.add(31); // ArrayList() 안에 한개의 요소에 리터럴 Int 형 31를 추가한다
//		System.out.println("b_1 >>> : " + b_1);
//		System.out.println("aList >>> : " + aList);		
//		System.out.println("aList.size() >>> : " + aList.size());
//		
//		boolean b_2 = aList.add('L');// ArrayList() 안에 한개의 요소에 리터럴 char 형 'L'를 추가한다
//		System.out.println("b_2 >>> : " + b_2);
//		System.out.println("aList >>> : " + aList);		
//		System.out.println("aList.size() >>> : " + aList.size());
//		
//		boolean b_3 = aList.add(3.2);
//		System.out.println("b_3 >>> : " + b_3);
//		System.out.println("aList >>> : " + aList);		
//		System.out.println("aList.size() >>> : " + aList.size());
//		
//		boolean b_4 = aList.add(new Integer(35000000));
//		System.out.println("b_4 >>> : " + b_4);
//		System.out.println("aList >>> : " + aList);		
//		System.out.println("aList.size() >>> : " + aList.size());
		
		boolean b_5 = aList.add(new String("서울시 용산구 원효로"));
		System.out.println("b_5 >>> : " + b_5);
		System.out.println("aList >>> : " + aList);		
		System.out.println("aList.size() >>> : " + aList.size());
		
		for (int i=0; i < aList.size(); i++) {
			// public E get(int index) : jdk 1.8
			// public Object get(int index) : jdk 1.4
			System.out.println(i + " >>> : " + aList.get(i));
		}
	}

}
