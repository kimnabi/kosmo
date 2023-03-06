package a.b.c.ch3;
public class ShortCircuitTest {
	public static void main(String[] args) 
	{
		int num = 10;
		int i = 2;
		//boolean b1 = (num = num + 10) < 10;
		//System.out.println("boolean b1 >>> " + b1);
		//boolean b2 = (i = i + 2) < 10;
		//System.out.println("boolean b2 >>> " + b2);
		//boolean bool = b1 && b2; 
		//System.out.println("boolean bool >>> " + bool);
		boolean bool_1 = (num = num + 10) < 10 && (i = i + 2) < 10;
		System.out.println("boolean bool_1 >>> " + bool_1);
		System.out.println("num >>> "+ num);
		System.out.println("i >>> "+ i);

		//---------------------------------------------------------
		boolean bool_2 = ((num = num + 10) > 10 || (i = i + 2) < 10);
		System.out.println("boolean bool_2 >>> " + bool_2);
		System.out.println("num >>> "+ num);
		System.out.println("i >>> "+ i);

		/*C:\00.KOSMO129\10.JExam\ch3>java a.b.c.ch3.ShortCircuitTest
		boolean bool_1 >>> false
		num >>> 20
		i >>> 2
		boolean bool_2 >>> true
		num >>> 30
		i >>> 2 */
	} // end of main function
} // end of ShortCircuitTest
