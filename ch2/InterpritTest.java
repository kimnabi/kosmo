package a.b.c.ch2;

public class InterpritTest {

	int i;
	String s;
	
	// 기본 생성자 : 생성자에 매개변수가 없는 생성자 
	public InterpritTest() {
		System.out.println("1111 InterpritTest() 생성자 시작 >>> : ");

		System.out.println("2222 InterpritTest() 생성자 끝 >>> : ");
	} 
	
	
	public int aM() {
		System.out.println("1111 aM() 함수 시작 >>> : ");

		System.out.println("2222 aM() 함수 끝 >>> : ");
		return 0;
	}
	public static void main(String[] args) {
		System.out.println("1111 main() 함수 시작 >>> : ");

		InterpritTest it = new InterpritTest();
		System.out.println("2222 main() 함수 :: it >>> : "+ it);

		int sum = it.aM();
		System.out.println("3333 main() 함수 :: sum >>> : " + sum);

		System.out.println("4444 main() 함수 끝 >>> : ");
	} //end of main function
} //end of InterpritTest class
