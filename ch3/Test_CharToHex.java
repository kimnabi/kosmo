package a.b.c.ch3;

import java.util.Scanner;

/*

알파벳 대문자 26개
알파벳 소문자 26개
숫자 0 1 2 3 4 5 6 7 8 9 
사칙 연산자 + - * /
특수기호 ! @ # $ % ^ & * ( ) ~

각각 함수로 만들어서 콘솔에 문자 및 16진수를 출력 하시오 

*/
public class Test_CharToHex {
	
	// 사용: 영문자 대문자들 의 문자열 를 각각의 char문자로 16진수 형태로 출력하는  함수
	public static void alMethod(String aL) {
		System.out.println("  Test_CharToHex_1.alMethod() 함수 시작 >>> : ");
		System.out.println("  aL >>> : " + aL);
		// 들어오는 문자열 배열 빈문자와 al 가 null 아닐때 if 절이 수행한다
		if (aL !=null && aL.length() > 0) {
			// 문자열을 한 char문자들로 바꿔서 순회하여 한개씩 16진수형태로 출력한다
			Test_CharToHex.toHex(aL);	
		}
		
		System.out.println("  Test_CharToHex_1.alMethod() 함수 끝 >>> : ");
	}

	// 사용: 영문자 소문자들 의 문자열 를  각각의 char문자로 16진수 형태로 출력하는  함수
	public static void aSMethod(String aS) {		
		System.out.println("  Test_CharToHex_1.aSMethod() 함수 시작 >>> : ");
		System.out.println("  aS >>> : " + aS);
		// 들어오는 문자열 배열 빈문자와 aS가 null 아닐때 if 절이 수행한다
		if (aS !=null && aS.length() > 0) {
			// 문자열을 한 char문자들로 바꿔서 순회하여 한개씩 16진수형태로 출력한다
			Test_CharToHex.toHex(aS);	
		}
		
		System.out.println("  Test_CharToHex_1.aSMethod() 함수 끝 >>> : ");		
	}
	
	// 사용: 숫자 의 문자열배열 를  각각의 char문자로 16진수 형태로 출력하는  함수숫자
	public static void numMethod(String num) {		
		System.out.println("  Test_CharToHex_1.numMethod() 함수 시작 >>> : ");
		System.out.println("  num >>> : " + num);
		// 들어오는 문자열 배열 빈문자와 num가 null 아닐때 if 절이 수행한다
		if (num !=null && num.length() > 0) {
			// 문자열을 한 char문자들로 바꿔서 순회하여 한개씩 16진수형태로 출력한다
			Test_CharToHex.toHex(num);	
		}
		
		System.out.println("  Test_CharToHex_1.numMethod() 함수 끝 >>> : ");				
	}
	
	// 사용: 사칙연산의 문자열배열 를  각각의 char문자로 16진수 형태로 출력하는  함수숫자
	public static void operMethod(String oper) {
		System.out.println("  Test_CharToHex_1.operMethod() 함수 시작 >>> : ");
		System.out.println("  oper >>> : " + oper);
		// 들어오는 문자열 배열 빈문자와 num가 null 아닐때 if 절이 수행한다
		if (oper !=null && oper.length() > 0) {
			// 문자열을 한 char문자들로 바꿔서 순회하여 한개씩 16진수형태로 출력한다
			Test_CharToHex.toHex(oper);	
		}
		
		System.out.println("  Test_CharToHex_1.operMethod() 함수 끝 >>> : ");				
	}
	
	//사용: 특수기호 의 문자열배열 를  각각의 char문자로 16진수 형태로 출력하는  함수숫자
	public static void ksxMethod(String ksx) {
		System.out.println("  Test_CharToHex_1.ksxMethod() 함수 시작 >>> : ");
		System.out.println("  ksx >>> : " + ksx);
		// 들어오는 문자열 배열 ksx가 빈문자와 ksx가 null 아닐때 if 절이 수행한다
		if (ksx !=null && ksx.length() > 0) {
			// 문자열을 한 char문자들로 바꿔서 순회하여 한개씩 16진수형태로 출력한다
			Test_CharToHex.toHex(ksx);	
		}
		
		System.out.println("  Test_CharToHex_1.ksxMethod() 함수 끝 >>> : ");			
	}
	
	// 문자열를 16진수 형태(예:0x2b)로 출력한다
	public static void toHex(String h) {
		
		for (int i=0; i < h.length(); i++) {
			char hHex = h.charAt(i);
			System.out.print("  " + hHex + " : ");
			System.out.println("0x" + Integer.toHexString(hHex));
		}					
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Test_CharToHex_1.main() 함수 시작 >>> : ");
		
		// 변수 선언 
		String aL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String aS = aL.toLowerCase();
		String num = "0123456789";
		String oper = "+-*/";
		String ksx = "!@#$%^&*()~";
		
		System.out.println("ASCII CODE 보기 >>> : ");
		System.out.println("1 : 영문자 대문자");
		System.out.println("2 : 영문자 소문자");
		System.out.println("3 : 숫자");
		System.out.println("4 : 사칙연산자");
		System.out.println("5 : 특수기호 !@#$%^&*()~ ");
		
		Scanner sc = new Scanner(System.in);
		int sNum = 0;
		
		while (true) {
			
			sNum = sc.nextInt();
			
			switch (sNum) {
				case 1: Test_CharToHex.alMethod(aL);
					break;
				case 2: Test_CharToHex.aSMethod(aS);
					break;
				case 3: Test_CharToHex.numMethod(num);
					break;
				case 4: Test_CharToHex.operMethod(oper);
					break;
				case 5: Test_CharToHex.ksxMethod(ksx);
					break;			
			}
			if (sNum == 9) {
				sc.close();
				System.out.println("Test_CharToHex_1.main() 함수 끝 >>> : ");
				System.out.println("프로그램을 종료 합니다 >>> : ");
				System.exit(0);
			} // end of if
		} //end of while	
	} // end of main

} // end of Test_CharToHex
