package a.b.c.ch3;

public class ForTest_4 
{
	public static void main(String[] args) 
	{
		for (int i =0; i<= 3; i++ )
		{
			for (int j =0; j<=3;j++ )
			{
				System.out.print("(" +i+","+j+")");
			} // end for int j 
			System.out.println();
		} //end for int i

		for (int i =0; i<= 3; i++ )
		{
			for (int j =0; j<= i;j++ )
			{
				System.out.print("(" +i+","+j+")");
			} // end for int j 
			System.out.println();
		} //end for int i
		
	} //end of main
} //end of forTest_4
