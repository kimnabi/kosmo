package a.b.c.com.kos.rboard.service;

import java.util.List;

import a.b.c.com.kos.rboard.vo.KosRboardVO;

public interface KosRboardService {

	public int kosRboardInsert(KosRboardVO rbvo);
	public List<KosRboardVO> kosRboardSelectAll(KosRboardVO rbvo);
	public int kosRboardDelete(KosRboardVO rbvo);
}
