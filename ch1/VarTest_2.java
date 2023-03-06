package a.b.c.ch1;

public class VarTest_2 {

	//매개변수 int 형 x 와 y 를 받아 int 형 을 반환하는 함수이다
	public static int add(int x, int y) {
		// int 자료형에 변수명 i 선언하고 파라미터 변수 x 로 초기화 한다.
		int i = x;
		// int 자료형에 변수명 ii 선언하고 파라미터 변수 y 로 초기화 한다.
		int ii = y;
		// int 자료형에 변수명 sum 선언한다 i와 ii (변수)을 더하기 연산하여 초기화 한다
		int sum = i + ii;
		//return 키워드를 사용하여 sum 에 함수의 결과 값 를 대입하여 반환한다 
		return sum;
	} //end of add() function

	public static void main(String[] args) {
		// int 자료형에 변수명 a 선언하고 리터럴 값 1 로 초기화 한다.
		int a = 1;
		// int 자료형에 변수명 b 선언하고 리터럴 값 2 로 초기화 한다
		int b = 2;
		// VarTest_2 클래스 내부에 있는 add(int x, int y) 
		// 함수를 호출(invoke, call, 불러서)해서 초기화 했다.
        // add 함수에서 리터럴 1, 2를 인자로 받아 int 형 x,y에 대입하여 반환된 int 리턴값을 int 형 sum에 초기화한다
		int sum = add(1, 2);
		// int sum 에 저장된 값을 호출해서 콘솔에 출력한다.
		System.out.println("sum >>> : " + sum);
		// add (int x, int y)함수에서 아규먼트로 지역변수 a,b 값 를 전달하여 
		// int 자료형 sum_1에 add(a, b) 호출 된 함수의 값으로 초기화 한다
		int sum_1 = add(a, b);
		System.out.println("sum_1 >>> : " + sum_1);
		
	} //end of main() function
} //end of VarTest_2
