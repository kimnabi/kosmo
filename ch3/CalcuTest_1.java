package a.b.c.ch3;
import org.apache.log4j.*;
// 콘솔 어플리케이션으로 사칙연산 프로그램 만들기 
// 데이터는 정수 만 사용
// 결과는 메인함수에서 콘솔에 출력하기 
public class CalcuTest_1 {
	
	static Logger logger = Logger.getLogger(CalcuTest_1.class);
	// 사용자정의 클래스 CalcuTest_1의 인스턴스 하기위해 호출될때
	// 한번 호출되어지고 맴버변수 초기화 한다
	// 개발자가 명시적으로 생성자를 구현안될때 매개변수 없는 기본 생성자 만든다
	//
	public CalcuTest_1() {
		logger.trace("생성자 CalcuTest_1() 함수 시작 >>> : ");	
		logger.info("생성자 CalcuTest_1() 함수 끝 >>> : ");	
		
		//System.out.println(" 생성자 CalcuTest_1() 함수 시작 >>> : ");
		//System.out.println(" 생성자 CalcuTest_1() 함수 끝 >>> : ");
	}// end of constructor 
	// 더하기 함수
	public int addCalcu(int x, int y) {
		System.out.println(" addCalcu(x,y) 함수 시작 >>> : ");
		System.out.println(" addCalcu(x,y)  >>> : " +x +" : "+ y);
		System.out.println(" addCalcu(x,y) 함수 끝 >>> : " );
		return x + y;
	} // end of addCalcu function

	// 빼기 함수
	// 참조변수를 사용해야 하는 함수
	// 파라메터가 정수 int x, y
	// 리턴 형이 int 형
	public int subCalcu(int x, int y) {
		System.out.println(" subCalcu(x,y) 함수 시작 >>> : ");
		System.out.println(" subCalcu(x,y)  >>> : 파라메터" +x +" : "+ y);
		System.out.println(" subCalcu(x,y) 함수 끝 >>> : " );
		//빼기 연산 결과를 함수밖으로 리턴 한다
		return x - y;
	} // end of subCalcu function


	// 곱하기 함수
	// 참조변수를 사용해야 하는 함수
	// 파라메터가 정수 int x, y
	// 리턴 형이 int 형
	public int mulCalcu(int x, int y) {
		System.out.println(" mulCalcu(x,y) 함수 시작 >>> : ");
		System.out.println(" mulCalcu(x,y)  >>> : 파라메터" +x +" : "+ y);
		System.out.println(" mulCalcu(x,y) 함수 끝 >>> : " );
		//곱하기 연산 결과를 함수밖으로 리턴한다
		return x * y;
	} // end of mulCalcu function

	// 나누기 함수
	// 참조변수를 사용해야 하는 함수
	// 파라메터가 정수 int x, y
	// 리턴 형이 int 형
	public int divCalcu(int x, int y) {
		System.out.println(" divCalcu(x,y) 함수 시작 >>> : ");
		System.out.println(" divCalcu(x,y)  >>> : 파라메터" +x+" : "+ y);
		System.out.println(" divCalcu(x,y) 함수 끝 >>> : " );
		// 나누기 연산 결과를 함수밖으로 리턴한다
		return x / y;
	}// end of divCalcu function


	// main() 함수는 콘솔 어플의 시작점이자 끝점이다. 
	public static void main(String args[]) {
		System.out.println(" main() 함수 시작 >>> : ");
		// 지역 변수 int 자료형 a 선언
		// int 형 리터럴 10 대입된다
		int a = 10;
		// 지역 변수 int 자료형 b 선언
		// int 형 리터럴 20 대입된다
		int b = 20;
		//참조변수 ct 로 CalcuTest_1 인스턴스 
		CalcuTest_1 ct = new CalcuTest_1();
		// 위 라인에서 선언한 CalcuTest_1 클래스의 참조변수에 ct .(dot) 연산자로 링크해서 함수이름을 붙혀서 사용한다 
		// CalcuTest_1.addCalcu(a,b) 아규먼트 x,y의 합를 리턴한다
		// int 자료형 addResult 지역변수를 선언하고 리턴값를 대입하여 초기화한다 
		int addResult = ct.addCalcu(a,b);
		//CalcuTest_1.subCalcu(a,b) 아규먼트 x - y의 결과값 를 리턴한다
		// int 자료형 subResult 지역변수를 선언하고 리턴값를 대입하여 초기화한다 
		int subResult = ct.subCalcu(a,b);
		////CalcuTest_1.mulCalcu(a,b) 아규먼트 x * y의 결과값 를 리턴한다
		// int 자료형 mulResult 지역변수를 선언하고 리턴값를 대입하여 초기화한다
		int mulResult = ct.mulCalcu(a,b);
		//CalcuTest_1.divCalcu(a,b) 아규먼트 x / y의 결과값 를 리턴한다
		// int 자료형 divResult 지역변수를 선언하고 리턴값를 대입하여 초기화한다
		int divResult = ct.divCalcu(a,b);
		
		// 콘솔에 println() 함수를 이용해서 출력한다.
		System.out.println(" main() addResult 더하기 >>> : " + addResult);
		
		System.out.println(" main() subResult 빼기 >>> : " + subResult);
		
		System.out.println(" main() mulResult 곱하기 >>> : " + mulResult);
		
		System.out.println(" main() divResult 나누기 >>> : " + divResult);

		System.out.println(" main() 함수 끝 >>> : ");
	}// end of main() function
}// end of CalcuTest_1 class
	/*C:\00.KOSMO129\10.JExam\ch3>java a.b.c.ch3.CalcuTest_1
		 main() 함수 시작 >>> :
		 생성자 CalcuTest_1() 함수 시작 >>> :
		 생성자 CalcuTest_1() 함수 끝 >>> :
		 addCalcu(x,y) 함수 시작 >>> :
		 addCalcu(x,y)  >>> : 10 : 20
		 addCalcu(x,y) 함수 끝 >>> :
		 subCalcu(x,y) 함수 시작 >>> :
		 subCalcu(x,y)  >>> : 10 : 20
		 subCalcu(x,y) 함수 끝 >>> :
		 mulCalcu(x,y) 함수 시작 >>> :
		 mulCalcu(x,y)  >>> : 10 : 20
		 mulCalcu(x,y) 함수 끝 >>> :
		 divCalcu(x,y) 함수 시작 >>> :
		 divCalcu(x,y)  >>> : 10 : 20
		 divCalcu(x,y) 함수 끝 >>> :
		 main() addResult 더하기 >>> : 30
		 main() subResult 빼기 >>> : -10
		 main() mulResult 곱하기 >>> : 200
		 main() divResult 나누기 >>> : 0
		 main() 함수 끝 >>> : */