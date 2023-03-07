package a.b.c.ch3;

public class IfTest_3_1 {
	


	public int add(int a, int b) {
        return a+b;
    }// end add
    public int substract(int a, int b) {
        return a-b;
    }
    public int multiple(int a, int b) {
        return a*b;
    }
    public int division(int a, int b) {
	return a/b;
    }
	//
	//
	//
	//return void
	public void operend ( char c ,int x ,int y ) {
		System.out.println("+ operend >>> : 시작" );
		//int ii = Integer.parseInt("+",16);
		String str = Integer.toHexString(c);
		//String str1 = "0x"+Integer.toHexString(c);
		byte decimal = (byte)Integer.parseInt(str,16); //10진수
		// 16진수에서는 모든 수 앞에 0x 를 붙인다.
		// 이건 아무런 의미가 없고 그냥 16진수라는 뜻으로 붙인다

		
		System.out.println("+ byte >>> : "+ decimal );
		/*Exception in thread "main" java.lang.NumberFormatException: For input string: "0x52"
        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.lang.Integer.parseInt(Integer.java:580)
        at a.b.c.ch3.IfTest_3.operend(IfTest_3.java:10)
        at a.b.c.ch3.IfTest_3.main(IfTest_3.java:109 */
		
		//byte b1 = 0x2b;
		boolean bool = (byte)c == decimal; //라인
		if (bool)
		{
			System.out.println("if >>> : "+ bool );
			//int res = add(1,2);	
			//System.out.println("if >>> : "+ res );
			//System.out.println( 1 + 2 );
			
			System.out.printf("%d %c %d = %d 입니다.%n",x,c,y, res);
		}
		System.out.println("+ operend >>> : 끝" );
	} // end of operend

	public static void main(String[] args) 
	{
		System.out.println("+ main >>> : 시작" );
		// 인스턴스 참조함수 if.3 선언
		IfTest_3_1 if_3 = new IfTest_3_1();
		//
		if_3.operend('+',1,2);
		if_3.operend('-',1,2);
		if_3.operend('*',1,2);
		if_3.operend('/',1,2);
		System.out.println("+ main >>> : 끝" );
	}
}
