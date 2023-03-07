package a.b.c.ch3;
/**
 콘솔에서 직접 main 함수 인수 한개를 받아 출력하기
*/
public class IfTest_1 
{
	public static void main(String[] args) 
	{
		// 숫자 더하기 
		// String s = "54321";

		
		// c:\00.KOSMO129\10.JExam\ch3>java a.b.c.ch3.IfTest 54321 
		// main(String args[] = {"54321")

		boolean bool = args.length == 1 //명령어 행 인수 데이타 가 한개가 있을때 true 로 반환된다
		// Boolean Short Circuiting
		if (bool)
		{
			// if 문이 true 일때
			System.out.println("args[0] >>> : "+ arg[0]);
		
		} else {
			// if 문이 false 일때
			System.out.println("더하기할 데이타를 입력하시요");
		} //end of if else
	} //end of main
} // end of IfTest_1 class
