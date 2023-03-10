package a.b.c.ch3;
/**
콘솔에서 인자 입력받아 사칙연산하세요

*/
public class IfTest_4_1 {
	// 두 수을 받아 더하기 연산 하는 함수
	// param : int x ,int y
	// return : int 
	public int addSum_3(int x, int y) {
		System.out.println("	addSum_3 함수 시작 >>> : ");
		int sum = x + y;		
		System.out.println("	addSum_3 함수 끝 >>> : ");
		return sum;
	}

	// 두 수을 받아 빼기 연산 하는 함수
	// param : int x ,int y
	// return : int 
	public int subSum_3(int x, int y) {
		System.out.println("	subSum_3 함수 시작 >>> : ");
		int sum = x - y;
		System.out.println("	subSum_3 함수 시작 >>> : ");
		return sum;
	}
	// 두 수을 받아 곱하기 연산 하는 함수
	// param : int x ,int y
	// return : int 
	public int mulSum_3(int x, int y) {
		System.out.println("	mulSum_3 함수 시작 >>> : ");
		int sum = x * y;
		System.out.println("	mulSum_3 함수 시작 >>> : ");
		return sum;
	}
	// 두 수을 받아 나누기 연산 하는 함수
	// param : int x ,int y
	// return : int 
	public int divSum_3(int x, int y) {
		System.out.println("	divSum_3 함수 시작 >>> : ");
		int sum = x / y;
		System.out.println("	divSum_3 함수 시작 >>> : ");
		return sum;
	}
	public static void main(String[] args) 
	{
		System.out.println("main() 함수 시작 >>> : ");
		System.out.println("args[0] 함수 >>> : " + args[0]);
		System.out.println("args[1] 함수 >>> : " + args[1]);
		System.out.println("args[2] 함수 >>> : " + args[2]);

		if (args.length == 3)
		{
			String s0 = args[0]; // 연산자 
			String s1 = args[1]; // 첫번째 변수			
			String s2 = args[2]; // 두번째 변수 

			System.out.println("s0 >>> : " + s0);
			System.out.println("s1 >>> : " + s1);
			System.out.println("s2 >>> : " + s2);

			// 연산자 
			char s0C = s0.charAt(0);
			// 숫자
			int x = Integer.parseInt(s1); 
			int y = Integer.parseInt(s2);
			
			// 더하기 연산일 결우 아래의 if 절이 실행한다
			if (s0C == 0x2b){
				// IfTest_4_1 클래스에 int addSum_3(int x, int y)를 이용하기 위해
				// if 절 라인이 읽어 실행될때 new 키워드를 통해 메모리에 올린다
				// 지역변수이자 참조 변수 it2 에 IfTest_4_1() 클래스의 위치값을 대입하여 초기화한다
				IfTest_4_1 it2 = new IfTest_4_1();
				
				int sum = it2.addSum_3(x, y);
				System.out.println(x + " + " + y + " = " + sum);
			} //end of if

			// 빼기 연산일 결우 if 절이 실행한다
			if (s0C == 0x2d){
				// IfTest_4_1 클래스에 int subSum_3(int x, int y)를 이용하기 위해
				// if 절 라인이 읽어 실행될때 new 키워드를 통해 메모리에 올린다
				// 지역변수이자 참조 변수 it2 에 IfTest_4_1() 클래스의 위치값을 대입하여 초기화한다
				IfTest_4_1 it2 = new IfTest_4_1();
				int sum = it2.subSum_3(x, y);
				System.out.println(x + " - " + y + " = " + sum);
			}//end of if
			
			// 곱하기 연산일 결우 if 절이 실행한다
			if (s0C == 0x2a){
				// IfTest_4_1 클래스에 int mulSum_3(int x, int y)를 이용하기 위해
				// if 절 라인이 읽어 실행될때 new 키워드를 통해 메모리에 올린다
				// 지역변수이자 참조 변수 it2 에 IfTest_4_1() 클래스의 위치값을 대입하여 초기화한다		
				IfTest_4_1 it2 = new IfTest_4_1();
				int sum = it2.mulSum_3(x, y);
				System.out.println(x + " * " + y + " = " + sum);
			}//end of if
			
			// 나누기 연산일 결우 if 절이 실행한다
			if (s0C == 0x2f){
				System.out.println("if  >>> : " );
				// IfTest_4_1 클래스에 int mulSum_3(int x, int y)를 이용하기 위해
				// if 절 라인이 읽어 실행될때 new 키워드를 통해 메모리에 올린다
				// 지역변수이자 참조 변수 it2 에 IfTest_4_1() 클래스의 위치값을 대입하여 초기화한다
				IfTest_4_1 it2 = new IfTest_4_1();
				int sum = it2.divSum_3(x, y);
				System.out.println(x + " / " + y + " = " + sum);
			} //end of if
		}//end of if
		System.out.println("main() 함수 끝 >>> : ");
	} // end of main
} //end of IfTest_4_1 class
