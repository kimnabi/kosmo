package a.b.c.ch3;
	/** 
	int 형 데이터 타입이 들어갈 공간 3개를 만들어주세요 
	*/
public class ArrayTest {
	public static void main(String[] args) {
		// int 형 배열 선언 및 인스턴스 
		int[] i = new int[3];
		//int[] i = new int[]; //배열의크기를 지정하지않으면  에러 발생
		/*C:\00.KOSMO129\10.JExam\ch3>javac -d . ArrayTest.java
		ArrayTest.java:8: error: array dimension missing
                int[] i = new int[];
                                   ^
		1 error */
		System.out.println("i 참조변수 >>> : "+ i);
		/*C:\00.KOSMO129\10.JExam\ch3>java a.b.c.ch3.ArrayTest
		i 참조변수 >>> : [I@15db9742 */
		//일반변수 int 형 i_0 선언
		// int 형 데이타 를 가르키는 참조 변수 i 
		int i_0 = i[0];
		System.out.println("i_0 >>> : " + i_0);
		int i_1 = i[1];
		System.out.println("i_1 >>> : " + i_1);
		int i_2 = i[2];
		System.out.println("i_2 >>> : " + i_2);
	} // end of main function
} //end of ArrayTest class
