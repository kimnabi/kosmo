package a.b.c.ch3;

public class ForTest_1 {
	public static void main(String[] args) {
		// 지역변수 int 형 i 에 리터럴 0을 대입하여 선언
		// i 변수 6이상일때까지 i = i + 1 만큼 증가 할때마다
		// i 변수 + " " 빈문자열 를 호출하여 콘솔에 출력한다 
		for (int i= 0; i <= 6; i++ )
		{
			System.out.print(i + " ");
		} //end for	
		System.out.println();
		
		// 지역변수 int 형 i 에 리터럴 6을 대입하여 선언
		// i 변수 0이하일때까지 i = i - 1 만큼 증감 할때마다
		// i 변수 + " " 빈문자열 를 호출하여 콘솔에 출력한다 
		for (int i=6; i >= 0; i-- )
		{
			System.out.print(i + " ");
		} //end for	
		System.out.println();
		for (int i=2; i <= 10; i += 2 )
		{
			System.out.print(i + " ");
		} //end for
	} // end of main function
} //end of ForTest_1 class
