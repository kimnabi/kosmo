package a.b.c.ch1;

public class VarTest_5 {

	int i;
	String str;

	public static void main(String[] args) 
	{
		VarTest_5 vt5_1 = new VarTest_5();

		System.out.println("vt5_1 참조변수의 주소값 >>> : " + vt5_1);
		System.out.println("vt5_1.i >>> : " + vt5_1.i);
		System.out.println("vt5_1.str >>> : " + vt5_1.str);

		vt5_1.i = 28;
		vt5_1.str = "정수민";	
		System.out.println("vt5_1.i >>> : " + vt5_1.i);
		System.out.println("vt5_1.str >>> : " + vt5_1.str);
		
		VarTest_5 vt5_2 = new VarTest_5();

		System.out.println("vt5_2 참조변수의 주소값 >>> : " + vt5_2);
		System.out.println("vt5_2.i >>> : " + vt5_2.i);              
		System.out.println("vt5_2.str >>> : " + vt5_2.str);          
		
		vt5_2.i = 34;                                      
		vt5_2.str = "홍한솔";	                           
		System.out.println("vt5_2.i >>> : " + vt5_2.i);    
		System.out.println("vt5_2.str >>> : " + vt5_2.str);
	} // end of main function
} //end of VarTest_5 class
