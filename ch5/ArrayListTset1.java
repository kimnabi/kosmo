package a.b.c.ch5;

import java.util.ArrayList;

public class ArrayListTset1 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * <>:제네릭: Generic jdk 1.5지원
		 * T Type :클래스 타입
		 * E Element :Object
		 * K Key
		 * V Value
		 * N Number
		 */
		ArrayList<String> aList = new ArrayList<String>(3);
		// public boolean add(E e) : jdk 1.8
		// public boolean add(Object o) : jdk 1.4 
		aList.add("abc");
		aList.add('a');
		aList.add(3);
		aList.add("4번째 데이터");

		
	}//end of main
}// end of ArrayListTset2 class

