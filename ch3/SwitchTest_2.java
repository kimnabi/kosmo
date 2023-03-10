package a.b.c.ch3;
/**
  Scanner 클래스이용하여 입력받아 출력하세요
*/
import java.util.Scanner;

public class SwitchTest_2 {

	public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
 
	public static void main(String[] args) {
		System.out.println(">>>> main() 함수 시작 : ");
		// java.util.Scanner 패키지에 Scanner 클래스 이용해서
		// 외부로 부터 데이타를 입력받기 위해 
		Scanner sc = new Scanner(System.in);
		System.out.print(">>>> 숫자 한개를 입력하세요 : ");
		String input = sc.nextLine(); //문자열 숫자입력받아 공백문자, 숫자인지 아닌지 
		boolean bool = !"".equals(input) && isNumeric(input) && input.length() == 1;
		if(bool)
		{
			System.out.println("	>>>> bool : "+ bool);
			int rank = Integer.parseInt(input);
			switch (rank)
			{
				case 1:		System.out.println("	>>>> rank : " + rank); break;
				case 2: 	System.out.println("	>>>> rank : " + rank); break;
				case 3: 	System.out.println("	>>>> rank : " + rank); break;
				case 4: 	System.out.println("	>>>> rank : " + rank); break;
				default :   System.out.println("	>>>> default : ");

			} //end of switch
		} // end of if
		sc.close();
		System.out.println(">>>> main() 함수 끝 : ");
	} //end of main
} // end of SwitchTest_2 class
/**
C:\kosmo\ch3>java a.b.c.ch3.SwitchTest_2
	>>>> main() 함수 시작 :
	>>>> 숫자 한개를 입력하세요 : 3
                >>>> rank : 3
	>>>> main() 함수 끝 : */