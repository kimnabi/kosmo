package a.b.c.ch1;

public class StaticTest_1 {
	
	public static int aM(int x,int y) {
	//aM 함수는 매개변수 x,y 선언하고 int 자료형 x+y 합를 반환한다 
	return x + y;
	}
	public static void bM(int x,int y) {
	//bM 함수는 매개변수 x,y 선언하고 x+y 합를 호출하여 콘솔에 출력한다 
		System.out.println(x + y);
	}
	public static void main(String[] args) {
		System.out.println("main() 함수 시작 >>> :");
		int am = StaticTest_1.aM(1, 2);
		System.out.println("am 함수 시작 >>> :" + am);
		//StaticTest_1.aM 함수는 아규먼트 1,2를 받아 int 자료형 리턴값를 호출하여 콘솔에 출력한다 
		System.out.println("StaticTest_1.aM(1, 2) 함수 시작 >>> : " + StaticTest_1.aM(1, 2));
		StaticTest_1.aM(11, 22);
	} // end of main() function	
} // end of StaticTest_1 class
