package a.b.c.ch3;

public class ShortCircuitTest1 {

	public static void main(String args[]) {
	
		int num1 = 10;
		int i = 2;
		
		System.out.println("######################\n");
		boolean b_1 = (num1 = num1 + 10) < 10;
		System.out.println("b_1 >>> : " + b_1);
		boolean b_2 = (i = i + 2) < 10;
		System.out.println("b_2 >>> : " + b_2);
		boolean b = b_1 && b_2;
		System.out.println("b >>> : " + b);

		boolean value = ((num1 = num1 + 10) < 10) && ((i = i + 2) < 10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		System.out.println("\n######################\n");

		System.out.println("######################\n");
		boolean b_3 = (num1 = num1 + 10) > 10;
		System.out.println("b_3 >>> : " + b_3);
		boolean b_4 = (i = i + 2) < 10;
		System.out.println("b_4 >>> : " + b_4);
		boolean b1 = b_3 && b_4;
		System.out.println("b1 >>> : " + b1);

		value = ((num1 = num1 + 10) > 10) || ((i = i + 2) < 10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		System.out.println("\n######################\n");
	}
}
