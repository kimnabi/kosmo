package a.b.c.ch4;
/**
 * 
 * 짝수 홀수 의 갯수를 출력하시오
 * @author 김정환
 *
 */
public class Test_EvenOdd {
	
	public static void main(String[] args) {
		
		int evenCnt = 0; // 짝수 갯수 담을 int 타입 변수 선언
		int oddCnt = 0;  // 홀수 갯수 담을 int 타입 변수 선언
		// int 형 타입 참조변수 num 은 int 형 자료형 배열의 주소를 가르키는 한개의 주소 값를 담는다
		int[] num = /*new int[]*/ {3, 4, 5, 6, 7, 10, 15, 16}; // int 형 배열 인스턴스하고 
		//객체 배열  안의 각각 공간에 만들어지고 각 index 별로 하나씩 리터럴 정수값 대입하여 초기화 한다
		
		// 콘솔에 짝수 even, 홀수 odd 의 갯수를 출력 하시오 
		for (int i=0; i < num.length; i++) {
			//배열의 길이 만큼 각각의공간에 index을 i 지역변수 을  순차적으로 누적된 i 값을 할당하여
            //각각의 값를 호출하여 콘솔에 출력 한다
			System.out.println("num["+i+"] >>> : " + num[i]);
			// 나머지연산 : 짝수일때 num[i]%2 == 0 
			// 짝수 일때 if 절 이 실행된다 
            if (num[i]%2 == 0) {
             
                //콘솔에 num 참조변수가 가르키는 int 타입 배열에 인덱스 i 번째 int 타입 값를 출력한다
				System.out.println("num["+i+"] <<<>>> : " + num[i]);
                //배열의 길이 만큼 반복하면 짝수의갯수를 누적하여 
                //evenCnt의 변수에 하나씩 누적해서 대입한다
				evenCnt++; // evenCnt = evenCnt +1;
			}else {
                //홀수일때
                //콘솔에 num 참조변수가 가르키는 int 타입 배열에 인덱스 i 번째 int 타입값를 출력한다
				System.out.println("num["+i+"] >>><<< : " + num[i]);
				//배열의 길이 만큼 반복하면 홀수의갯수를 누적하여 
                //oddCnt의 변수에 하나씩 누적해서 대입한다
                oddCnt++; // oddCnt = oddCnt +1;
			}
		}
    //for 문이 종료되고 evenCnt 변수와 oddCnt 변수을 콘솔에 출력한다
		System.out.println("짝수는 >>> : " + evenCnt + "개 입니다.");
		System.out.println("홀수는 >>> : " + oddCnt + "개 입니다.");
	} // end of main function

} //end of Test_EvenOdd class
