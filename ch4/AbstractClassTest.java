package a.b.c.ch4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractClassTest extends AbstractClass{

	@Override // 어노테이션 Annotation
	public void abstractMethod() {
		// TODO Auto-generated method stub
		System.out.println("abstractMethod() >>> : ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 추상클래스는 new 연산자로 사용할 수 없다.
		// AbstractClass ab = new AbstractClass();
		
		AbstractClassTest act = new AbstractClassTest();
		act.abstractMethod();
		
		// 회원번호 만들기 
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		String ymd = sdf.format(d);
		System.out.println("ymd >>> : " + ymd);
//		String mnum = AbstractClass.BIZ_GUBUN_MEMBER + "20230310" + "0001";
		String mnum = AbstractClass.BIZ_GUBUN_MEMBER + ymd + "0001";
		System.out.println("mnum >>> : " + mnum);
	}
}
