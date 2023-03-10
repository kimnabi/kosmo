package a.b.c.ch3;

public class WhileTest {

	public static void main(String args[]) {
		System.out.println(">>>> main() 함수 시작 : ");
		int i = 1;
		int sum = 0;
		while (i<= 10)
		{
			sum += i; //누적 해서 sum 에 대입한다 
			System.out.println("	while i >>> " + i);
			System.out.println("	while sum >>>"+ sum);
			i++;
		} //end of while
		System.out.println("	>>>>>>>"+ sum);
		System.out.println(">>>> main() 함수 끝 : ");

	}//end of main
} //end of whileTest


/**
에러 코드: main 메서드 못찾을때 컴파일은 성공하지만 런타임 에러가 나온다
메서드 이름 철자를 잘못칠때 :man
C:\kosmo\ch3>java a.b.c.ch3.WhileTest
오류: a.b.c.ch3.WhileTest 클래스에서 기본 메소드를 찾을 수 없습니다. 다음 형식으로 기본 메소드를 정의하십시오.
   public static void main(String[] args)
또는 JavaFX 애플리케이션 클래스는 javafx.application.Application을(를) 확장해야 합니다.


*/