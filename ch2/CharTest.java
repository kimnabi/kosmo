public class CharTest {

	char cc = 'A';
	static char ccc = 'A';

	public static void main(String[] args) {
		char c = 'A';
		System.out.println(c);
		System.out.println((int)c);
		// 16Áø¼ö
		// public static String toHexString(int i)
		String hexStr = Integer.toHexString(c);
		System.out.println("hexStr >>> " + hexStr);
		// public static String toOctalString(int i);
		String octalStr = Integer.toOctalString(c);
		System.out.println("octalStr >>> " + octalStr);
		// public static String toBinaryString(int i)
		String binaryStr = Integer.toBinaryString(c);
		System.out.println("binaryStr >>> " + binaryStr);
	}// end of main function
}// end of CharTest class
