package a.b.c.com.login.dao;

import java.util.List;

import a.b.c.com.kos.mem.vo.KosMemberVO;

public interface KosLoginDAO {
	
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo);

	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo);
}
