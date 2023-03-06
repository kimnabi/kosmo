package a.b.c.ch3;
public class ForTest {
	public static void main(String[] args) 
	{
	/*
			1. for 문 기본적으로 루프가 돌게 설계되어 있다.
			2. 조건식이 true 일 때 만 for 문이 수행 된다.
		for ( 초기화; 조건식; 증감식 )
		{
			System.out.println(">>> : ");
			
		}
		*/

		/*
		for (; ; )
		{
			System.out.println(">>> : ");
			
		}
		*/

		/*
		for (; true; )
		{
			System.out.println(">>> : ");
		}
		*/
		//무한루프
		/*for (; false; ) {
			System.out.println(">>> : ");
		} */
		for (int i = 0; i< 10; i++){
			System.out.println(">>> : " + i); 
		}// end for int i
	}
} //end of ForTest class
