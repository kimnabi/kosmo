package a.b.c.ch4;

import a.b.c.common.MonthDay;
/**
명령행 인수 를 입력받아 출력하세요
*/
public class SwitchTest_4_1 {
	
	public static void main(String[]args) {
		System.out.println(">>>> main() 함수 시작 : ");
		boolean bool = args.length == 1;
		
		if(bool)
		{
			System.out.println("	>>>> bool : "+ bool);
			int month = Integer.parseInt(args[0]);
			//int month = 1;
			if(0 < month && month < 13){
				int day =MonthDay.month_day(month);
				System.out.println(month + "월 날짜 수는  " + day + "입니다.");
			} //end of if 

			System.out.println("	>>>> 입력하신 데이타은 잘못되었습니다");
		} // end of if
			System.out.println(">>>> main() 함수 끝 : ");
	}//end of main
} //end of SwitchTest_4_1
