package a.b.c.ch3;
/**
  명령행 인수 를 입력받아 출력하세요
*/
public class SwitchTest_1 {

	public static void main(String[] args) {
		System.out.println(">>>> main() 함수 시작 : ");
		boolean bool = args.length == 1;
		if(bool)
		{
			System.out.println("	>>>> bool : "+ bool);
			int rank = Integer.parseInt(args[0]);
			switch (rank)
			{
			case 1:		System.out.println("		>>>> rank : " + rank); break;
			case 2: 	System.out.println("		>>>> rank : " + rank); break;
			case 3: 	System.out.println("		>>>> rank : " + rank); break;
			default :   System.out.println("		>>>> rank : " + rank); break;

			} //end of switch
		} // end of if
		
		System.out.println(">>>> main() 함수 끝 : ");
	} //end of main
}//end of SwitchTest_1
/*C:\kosmo\ch3>java a.b.c.ch3.SwitchTest_1 3
	>>>> main() 함수 시작 :
	>>>> rank : 3
	>>>> main() 함수 끝 : */
