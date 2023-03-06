package a.b.c.ch2;

public class CastTest {
	public static void main(String[] args) 
	{
		byte b = 10;
		System.out.println(b + " b : " + System.identityHashCode(b));
		// 묵시적 형변환 implicit type conversion
		// 변수 b 자료형이 int 형으로 형이 변경되서 i 에 대입 된다. 
		int i = b;
		System.out.println(b + " b : " + System.identityHashCode(b));
		System.out.println(i + " i : " + System.identityHashCode(i));
		
		//int iN = 10;
		//byte bN = iN;
		/*C:\00.KOSMO129\10.JExam\ch2>javac -d . CastTest.java
		CastTest.java:15: error: incompatible types: possible lossy conversion from int to byte
                byte bN = iN;
                          ^
		1 error */
		byte bb = 10;
		int ii = (int)bb;
		System.out.println(bb);
		System.out.println(ii);
	}
} // end of CastTest class
