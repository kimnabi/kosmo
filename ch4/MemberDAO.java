package a.b.c.ch4;

import java.util.ArrayList;
// 모델 인터페이스 클래스 MemberDAO
// 데이타베이스 연동 할 CRUD 함수  선언
public interface MemberDAO {
      
	public int memInsert(MemberVO mvo);
	public ArrayList memSelect(MemberVO mvo);
	public int memUpdate(MemberVO mvo);
	public int memDelete(MemberVO mvo);
}
