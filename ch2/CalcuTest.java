package a.b.c.ch3;

public class CalcuTest {

	public int addSum(int x, int y) {
		System.out.println(" addSum(x,y) 함수 시작 >>> : ");
		System.out.println(" addSum(x,y)  >>> : " +(x+y));
		System.out.println(" addSum(x,y) 함수 끝 >>> : " );
		return x+y; 
	} //end of addSum

	// main() 함수는 콘솔 어플의 시작점이자 끝점이다. 
	public static void main(String[] args) {
		 // main 함수 실행시 불러오는 아규먼트의 숫자가 2개 이상이 안되면
		 // 아큐먼트를 받지 못할때 java.lang.ArrayIndexOutOfBoundsException 에러구문을 난다
		 // main 함수가 아무 분기없이 종료된다

		if (args.length == 2) {
		
			System.out.println("main() 1111 main() 함수 시작 >>> : ");
			int i = Integer.parseInt(args[0]);
			int ii = Integer.parseInt(args[1]);
			
			// 지역변수 초기화 선언 int 자료형 
			int a = 10;
			int b = 16;
		   /*
			C:\00.KOSMO129\10.JExam\ch2>java a.b.c.ch3.CalcuTest
			main() 1111 main() 함수 시작 >>> :
			Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
			at a.b.c.ch3.CalcuTest.main(CalcuTest.java:13) */
			//int ii = args[1];

			// CalcuTest 클래스에 있는 자원을 사용하려고 CalcuTest 클래스를
			// 참조변수 ct 로 인스턴스 
			CalcuTest ct = new CalcuTest();
			// ct 참조변수로 addSum 함수 호출 
			System.out.println("main() 3333 ct 참조변수 로 addSum() 함수 호출  >>> : ");
			//int sum = ct.addSum(i ,ii);
			int sum = ct.addSum(a,b);
			System.out.println("main() 4444 sum >>> : "+ sum);
			System.out.println("main() 5555 main() 함수 끝 >>> : ");
		}// end of if
	} //end of main() function
} //end of CalcuTest class

