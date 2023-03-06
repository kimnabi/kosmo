package a.b.c.ch1;

public class VarTest_3 
{
	//int 자료형 맴버변수 i를 선언한다
	int i; 
	
	public static void main(String[] args) 
	{
		//오브젝트형 변수 : 참조변수 : reference variable
		// s : 참조변수
		String s = "ABC"; //String 형 s 에"ABC" 문자열 인스턴스 를 가르키는 변수로 초기화 한다 
		
		System.out.println(s);
		System.out.println(System.identityHashCode(s));
		
		// vt : 참조변수
		//new 키워드를 이용하여 사용자정의 VarTest_3 형 인스턴스를 가르키는 변수로 초기화 한다
		VarTest_3 vt = new VarTest_3();
		
		System.out.println(vt);
		System.out.println(System.identityHashCode(vt));
		System.out.println(vt.i);
	}// end of main function

}// end od VarTest_3
