package a.b.c.ch3;

import java.util.Scanner;

public class IfTest_5_1 {
		// 상수
	public static final String FEE_0 = "취학전 아동";
	public static final String FEE_1 = "초등학생";
	public static final String FEE_2 = "중, 고등학생";
	public static final String FEE_3 = "일반인";
	
	// 기본 매개변수가 없는 생성자
	public IfTest_5_1() {
	System.out.println(">>>> 생성자 IfTest_5_1() >>>");
	} //end of IfTest_5_1()

	// 함수 
	public void feeMethod(int age) {
		System.out.println("	$$$$ IfTest_5_1.feeMethod() 시작  >>> : \n");
		System.out.println("	$$$$ age >>> : " + age);
		
		String div = "";
		int ageV = age;		
		int charge = 0;
		
		if (ageV < 8) {
			div = FEE_0;
			charge = 1000;
			
		}else if (ageV < 14) {
			div = FEE_1;
			charge = 2000;
			
		}else if (ageV < 20) {
			div = FEE_2;
			charge = 2500;
			
		}else {
			div = FEE_3;
			charge = 3000;
		}
		
		System.out.println("	$$$$ "+ div + "입니다.");
		System.out.println("	$$$$ 입장료는 " + charge + "원 입니다.");
		System.out.println("	$$$$ IfTest_5_1.feeMethod() 끝  >>> : \n");
	}


	public static void main(String[] args) 
	{
		System.out.println("IfTest_5_1.main() 시작  >>> : \n");
		// 사용자의 입력를 통해 int 형 데이타를 받아
		// feeMethod 을 통해 나이에따라 입장료 값를 출력한다
		System.out.print("	나이를 입력 하세요 >>> : ");
		
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		IfTest_5_1 if5 = new IfTest_5_1();
		System.out.println("	인자 >>> : "+ age+"\n");
		if5.feeMethod(age);
		System.out.println("IfTest_5_1.main() 끝  >>> : ");
		sc.close();
	} //end of main
} //end of IfTest_5_1 class
