package a.b.c.ch4;

import java.util.ArrayList;
// MemberDAO 구현 클래스
public class MemberDAOImpl implements MemberDAO {

	@Override
	public int memInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl :: memInsert() 함수 >>> :"+mvo.getName());
		System.out.println("MemberDAOImpl :: memInsert() 함수 >>> :"+mvo.getEmail());
		System.out.println("MemberDAOImpl :: memInsert() 함수 >>> :"+mvo.getHp());
		System.out.println("MemberDAOImpl :: memInsert() 함수 >>> :"+mvo.getAddr());
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList memSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("memSelect() 함수 >>> :");
		return null;
	}

	@Override
	public int memUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("memUpdate() 함수 >>> :");
		return 0;
	}

	@Override
	public int memDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("memDlete() 함수 >>> :");
		return 0;
	}

}
