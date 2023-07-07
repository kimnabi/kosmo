package a.b.c.com.kos.mem.service;

import java.util.List;

import a.b.c.com.kos.mem.vo.KosMemberVO;

public interface KosMemberService {
	
	int kosMemberInsert(KosMemberVO kvo);
	List<KosMemberVO> kosMemberSelectAll(KosMemberVO kvo);
	List<KosMemberVO> kosMemberSelect(KosMemberVO kvo);	
	List<KosMemberVO> kosIdCheck(KosMemberVO kvo);
	List<KosMemberVO> kosEmailCheck(KosMemberVO kvo);
	int kosaddMemberBySNS(KosMemberVO kvo);
	int kosMemberUpdate(KosMemberVO kvo);
	int kosMemberDelete(KosMemberVO kvo);
	List<KosMemberVO> dbCheckIdAndEmail(KosMemberVO kvo);
	int kosMemberUpdatePW(KosMemberVO kvo);
	

}
