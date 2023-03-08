package a.b.c.ch3;

import java.util.Scanner;

public class IfTest_4_3 {

	public int arithmeticOper(char c, int x, int y){
		System.out.println("	arithmeticOper() 함수 시작 >>> : ");			
		int sum = 0;
		
		// + : 더하기 
		if (c == 0x2b){	
			sum = x + y;
		}
		
		// - : 빼기 
		if (c == 0x2d){
			sum = x - y;
		}

		// * : 곱하기 
		if (c == 0x2a){
			sum = x * y;
		}

		// / : 나누기 
		if (c == 0x2f){
			sum = x / y;
		}
		System.out.println("	arithmeticOper() 함수 끝 >>> : ");			

		return sum;
	} //end of arithmeticOper

	public static void main(String[] args) {
		System.out.println("main() 함수 시작 >>> : ");

		Scanner sc = new Scanner(System.in);

		System.out.print("	사칙연산을 하기위해 연산자를 입력 하시오 + - * / >>> : ");
		
		String s = sc.next(); // 연산자 
		char c = s.charAt(0);
		System.out.print("		첫번째 변수를 입력 하시오 >>> : ");
		int x = sc.nextInt(); // 첫번째 변수			
		System.out.print("		두번째 변수를 입력 하시오 >>> : ");
		int y = sc.nextInt(); // 두번째 변수 	
		sc.close();
		// IfTest_4_3 클래스에 int arithmeticOper(int x, int y)를 이용하기 위해
		// if 절 라인을 읽어 실행될때 new 키워드를 통해 메모리에 올린다
		// 지역변수이자 참조 변수 it43 에 IfTest_4_3() 클래스의 위치값을 대입하여 초기화한다
		IfTest_4_3 it43 = new IfTest_4_3();
		int sum = it43.arithmeticOper(c,x,y);
		System.out.println(x + " "+ c+" "+ y +" = "+sum);
		System.out.println("main() 함수 끝 >>> : ");
	} //end of main
} // end of IfTest_4_3 class
