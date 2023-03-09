package a.b.c.ch3;

public class DoWhileTest {
	public static void main(String[] args) {
	System.out.println(">>>> main() 함수 시작 : ");
		int i = 1;
		int sum = 0;
		do 
		{
			sum += i; //누적 해서 sum 에 대입한다 
			System.out.println("	while i >>> " + i);
			System.out.println("	while sum >>>"+ sum);
			i++;
		} while (i<= 10); // end of Dowhile
		System.out.println("	>>>>>>> : "+ sum);
		System.out.println(">>>> main() 함수 끝 : ");
	}//end of main
} //end of whileTest
