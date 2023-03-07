package a.b.c.ch3;
/* 
요구조건  문자열 54321의 합 를 구하시요

*/
public class ForTest_3 {
	public static void main(String[] args) 
	{
		/* 
			"54321"
		    5 53  char '5'의 아스키코드
		    4 52  char '4'
			3 51  char '3'
			2 50
			1 49
		*/
		
		String s = "54321";
		int res = 0;
		for (int ii =0;ii< s.length; ii++ )
		{
			res += s.charAt(ii) - '0'; //아스키코드 48
		}//end of for

		char c[] = s.toCharArray(); // char 배열로 변환
		int sum =0 ; //누적 합 지역변수 선언
		for (int i =0 ;i< c.length ; i++ )
		{
			System.out.println("c[i] >>> : "+ c[i]);
			//Integer.parseInt 이용한 형변환
			/*String tem = Character.toString(c[i]);//char --> String 형변환
			//System.out.println(tem);
			//int ii = Integer.parseInt(tem); //String --> int 형변환*/
			sum+= Integer.parseInt(c[i].toString()); // String --> int 형변환
			

			//Character.getNumericValue(c[i]); //char --> int 형변환하는 함수
			//sum += Character.getNumericValue(c[i]);//sum = sum + Character.getNumericValue(c[i]); //char --> int 형변환하는 함수
		} // end of for
		System.out.println("sum >>> : "+ sum);
	} //end of main
} //end of ForTest_3 class
