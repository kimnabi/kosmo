package a.b.c.com.login.service;

import java.util.List;

import a.b.c.com.kos.mem.vo.KosMemberVO;

public interface KosLoginService {
	
	public List<KosMemberVO> kosLoginCheck(KosMemberVO kvo);

	public List<KosMemberVO> kakaoLogin(KosMemberVO kvo);
}
