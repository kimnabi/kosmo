public class CalcuTest_2 { 

	// 더하기 함수	
	// param int x,y
	// return int 타입
	public int addCalcu(int x, int y) {				
		int addSum = x + y;		
		return addSum;
	}

	// 빼기 함수
	// param int x,y
	// return int 타입
	public int subCalcu(int x, int y) {		
		return x - y;
	}

	// 곱하기 함수
	// param int x,y
	// return int 타입
	public static int mulCalcu(int x, int y) {	
		int mulSum = x * y;	
		return mulSum;
	}

	// 나누기 함수
	// param int x,y
	// return int 타입
	public static int divCalcu(int x, int y) {		
		return x / y;
	}

	// main() 함수는 콘솔 어플의 시작점이자 끝점이다. 
	public static void main(String[] args) {
		System.out.println("main() 1111 함수 시작 >>> : ");

		int x = 10;
		int y = 20;
		//
		CalcuTest_2 ct_2 = new CalcuTest_2();
		System.out.println("main() 2222 함수 참조변수 ct_2 >>> : " + ct_2);

		// public int addCalcu(int x, int y)
		int addSum = ct_2.addCalcu(x, y);
		System.out.println("main() 3333 함수 addSum >>> : " + addSum);
		
		// public int subCalcu(int x, int y) 
		int subSum = ct_2.subCalcu(x, y);
		System.out.println("main() 4444 함수 subSum >>> : " + subSum);
		
		// public static int mulCalcu(int x, int y)
		int mulSum = CalcuTest_2.mulCalcu(x, y);
		System.out.println("main() 5555 함수 mulSum >>> : " + mulSum);

		// public static int divCalcu(int x, int y)
		int divSum = CalcuTest_2.divCalcu(x, y);
		System.out.println("main() 6666 함수 divSum >>> : " + divSum);

		System.out.println("main() 7777 함수 끝 >>> : ");
	} //end of main() function
} //end of CalcuTest_2 class
