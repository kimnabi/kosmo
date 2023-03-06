package a.b.c.ch3;

public class Logicaloper
{
	public static void main(String[] args) 
	{
		int n1 = 10;
		int n2 = 20;
		boolean bool_n1 = n1 > 0;
		System.out.println("bool_n1 >>> : "+ bool_n1);
		boolean bool_n2 = n2 > 0;                     
		System.out.println("bool_n2 >>> : "+ bool_n2);
		boolean bool_n = bool_n1 && bool_n2;                     
		System.out.println("bool_n >>> : "+ bool_n);

		boolean bool = (n1 > 0) && (n2 > 0); // true && true  = true true && false = false
		System.out.println("bool >>> : "+ bool);
	// -----------------------------------------------------------------
		
		boolean b_n1 = n1 < 0;
		System.out.println("b_n1 >>> : " + b_n1);
		boolean b_n2 = n2 > 0;
		System.out.println("b_n2 >>> : " + b_n2);
		boolean b_n = b_n1 && b_n2;
		System.out.println("b_n >>> : " + b_n);

		boolean bool_1 = (n1 < 0) && (n2 > 0);
		System.out.println("bool_1 >>> : " + bool_1);
	//---------------------------------------------------------------------

		boolean b2_n1 = n1 < 0;
		System.out.println("b2_n1 >>> : " + b2_n1);
		boolean b2_n2 = n2 > 0;
		System.out.println("b2_n2 >>> : " + b2_n2);
		boolean b2_n = b2_n1 || b2_n2;
		System.out.println("b2_n >>> : " + b2_n);

		boolean bool_2 = (n1 < 0) || (n2 > 0); 
		System.out.println("bool_2 >>> : " + bool_2); //true || true  = true true || false = true 
//----------------------------------------------------------------------

	} //end of main function
}// end of Logicaloper
