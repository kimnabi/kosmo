package a.b.c.ch4;
/**
 * 
 * 짝수 홀수 의 갯수를 출력하시오
 * @author kasmo
 *
 */
public class Test_EvenOdd {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int evenCnt = 0; // 짝수 담을 int 형 타입 변수 선언
		int oddCnt = 0;  // 홀수 담을 int 형 타입 변수 선언
		// int 형 타입 참조변수 num 은 int 형 자료형 배열의 주소를 가르키는 한개의 주소 값를 담는다
		int[] num = /*new int[]*/ {3, 4, 5, 6, 7, 10, 15, 16}; // int 형 배열 인스턴스하고
		//객체 배열  안의 각각 공간에 만들어지고 각 index 별로 하나씩   리터럴 정수값 대입하여 선언한다 
		
		// 콘솔에 짝수 even, 홀수 odd 의 갯수를 출력 하시오 
		for (int i=0; i < num.length; i++) {
			//
			System.out.println("num["+i+"] >>> : " + num[i]);
			// 나머지연산
			if (num[i]%2 == 0) {
				System.out.println("num["+i+"] <<<>>> : " + num[i]);
				evenCnt++;
			}else {
				System.out.println("num["+i+"] >>><<< : " + num[i]);
				oddCnt++;
			}
		}
		System.out.println("짝수는 >>> : " + evenCnt + "개 입니다.");
		System.out.println("홀수는 >>> : " + oddCnt + "개 입니다.");
	} // end of main function

} //end of Test_EvenOdd class
