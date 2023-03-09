package a.b.c.common;

public class MonthDay {

	private MonthDay(){
		System.out.println("	MonthDay() 생성자>>> 시작 :");
		System.out.println("	MonthDay() 생성자>>> 끝 :");
	} //  end of Monday() 기본생성자 
	// 달 중 평달 윤달 구분하여 알려주는 함수
	// parm : int
	// return :int
	public static int month_day(int month) {
		System.out.println("	month_day(int month) >>> 시작 :");
		int day = 0; 
		switch (month)
		{
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: day = 31;
					break;
			case 4: case 6: case 9: case 11: day = 30;
					break;
			case 2: day = 28;
					break;
		}//end of switch
		System.out.println("	month_day(int month) >>> 끝 :");
		return day;
	} //end of static month_day
} // end of Monthday class
