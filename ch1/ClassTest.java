package a.b.c.ch1;
public class ClassTest {

	// i : 맴버변수
	// ClassTest 블럭 안에서 모두 사용할수있다

	static int i = 10;
	
	public static int aMethod() {
		// i : 지역변수
		// 함수안에서 선언한 변수 를 지역변수라 부른다
		// 지역변수는 함수안에서 태어나서 함수 안에서 죽는다
		// 지역변수는 함수밖으로 나갈수 없다
		// 지역변수가 함수 밖으로 나갈려면 return 키워드를 이용해야 한다
		int i = 100;
		return i;
	} //end of aMethod function

	public static void main(String[] args) {

		// i : 지역변수
		// i 는 main() 함수 밖으로 나갈 수가 없다.
		// void 키워드는 리턴값이 없다는 뜻이다. 
		int i = 1;
		System.out.println(i);
		System.out.println(ClassTest.i);
		System.out.println(ClassTest.aMethod());
	} // end of main function
} //end of ClassTest
