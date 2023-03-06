package a.b.c.ch3;
	/** 
	int 형 데이터 타입이 들어갈 공간 3개를 만들어주세요 
	*/
public class ArrayTest_1 {
	public static void main(String[] args) {
		// int 형 배열 선언 및 인스턴스 
		int[] i = new int[3];
	
		System.out.println("i 참조변수 >>> : "+ i);
		/*C:\00.KOSMO129\10.JExam\ch3>java a.b.c.ch3.ArrayTest
		i 참조변수 >>> : [I@15db9742 */
		//일반변수 int 형 i_0 선언
		// int 형 데이타 를 가르키는 참조 변수 i 
		int []i = i[0];
		System.out.println("i[0] >>> : " + i[0]);
		i[0] = 100;
		System.out.println("i[0] >>> : " + i[0]);
		i[0] = 1000;
		System.out.println("i[0] >>> : " + i[0]);
		
		System.out.println("i[1] >>> : " + i[1]);
		i[1] = 200;
		System.out.println("i[1] >>> : " + i[1]);
		i[1] = 2000;
		System.out.println("i[1] >>> : " + i[1]);

		System.out.println("i[2] >>> : " + i[2]);
		i[2] = 300;
		System.out.println("i[2] >>> : " + i[2]);
		i[2] = 3000;
		System.out.println("i[2] >>> : " + i[2]);
	
	} // end of main function
} //end of ArrayTest class