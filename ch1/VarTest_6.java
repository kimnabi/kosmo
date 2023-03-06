package a.b.c.ch1;
import a.b.c.ch1.aa.*;

public class VarTest_6 {

	int i;
	String str;

	public static void main(String[] args) {
		
		VarClass vc = new VarClass();
		System.out.println("vc 참조변수 주소값 >>> : " + vc);
		System.out.println("vc.i >>> : " + vc.i);
		System.out.println("vc.str >>> : " + vc.str);
		vc.i = 32;
		vc.str = "이민호";
		System.out.println("vc.i >>> : " + vc.i);
		System.out.println("vc.str >>> : " + vc.str);
		
		//같은 패키지내에 있는 클래스 VarClass_1
		// VarTest6 과 VarClass_2 사용할려면 *.class 파일로 컴파일하여 가져온다
		VarClass_1 vc_1 = new VarClass_1(); 
		vc_1.i = 10;
		vc_1.str = "카플치";
		System.out.println("vc_1 참조변수 주소값 >>> : " + vc_1);
		System.out.println("vc_1.i >>> : " + vc_1.i);
		System.out.println("vc_1.str >>> : " + vc_1.str);
		//다른 패키지에 있는 클래스 VarClass_2
		//컴파일할때 import 해서 자바파일을 가져오거나 
		// 명시적으로 a.b.c.ch1.aa.VarClass_2 vc_2 = new a.b.c.ch1.aa.VarClass_2(); 기입해야 한다
		VarClass_2 vc_2 = new VarClass_2();
		vc_2.i = 40;
		vc_2.str = "공플치";
		System.out.println("vc_2 참조변수 주소값 >>> : " + vc_2);
		System.out.println("vc_2.i >>> : " + vc_2.i);
		System.out.println("vc_2.str >>> : " + vc_2.str);
	}//end of main function
} //end of VarTest_6 class

// VarTest_6.java 파일 내부에 있는 클래스 
class VarClass{

	int i;
	String str;

} // end of VarClass class