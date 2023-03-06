package a.b.c.ch2;

public class VarTest {

	public static void main(String[] args) {

		// 2147483647
		// 지역변수 일반변수 literal
		// public static final MAX_VALUE : 상수 
		int i = Integer.MAX_VALUE;

		System.out.println("int 최대값 >>> : " + i);

		// public static final byte MAX_VALUE = 127 
		byte b = Byte.MAX_VALUE;

		System.out.println("byte 최대값 >>> : " + b);
		// public static final short MAX_VALUE = 32767
		short s = Short.MAX_VALUE;

		System.out.println("short 최대값 >>> : " + s);		
		// public static final long MAX_VALUE = 9223372036854775807L
		long l = Long.MAX_VALUE;

		System.out.println("long 최대값 >>> : " + l);
		
		/*long l_1 = 9223372036854775807;

		System.out.println("long 최대값 >>> : " + l_1);
		C:\00.KOSMO129\10.JExam\ch2>javac -d . VarTest.java
		VarTest.java:26: error: integer number too large: 9223372036854775807
                long l_1 = 9223372036854775807;
                           ^
		1 error */
		// public static final float MAX_VALUE = 3.4028234663852886E38f
		float f = Float.MAX_VALUE;

		System.out.println("float 최대값 >>> : " + f);
		/* float f_1 = 3.4028234663852886E38;

		System.out.println("float 최대값 >>> : " + f_1);
		C:\00.KOSMO129\10.JExam\ch2>javac -d . VarTest.java
		VarTest.java:39: error: incompatible types: possible lossy conversion from double to float
                float f_1 = 3.4028234663852886E38;
                            ^
		1 error */
		// public static final char MAX_VALUE = 65535
		// public static final char MAX_VALUE = '\uFFFF'
		// public static final char MIN_VALUE = 0
		// public static final char MIN_VALUE = '\u0000'
		
		//char c = Character.MAX_VALUE;
		char c = 126;
		char c_1 = Character.MIN_VALUE;

		System.out.println("Character 최대값 >>> : " + c);
		System.out.println("Character 최소값 >>> : " + c_1);

	}// end of main() function
} // end of VarTest
