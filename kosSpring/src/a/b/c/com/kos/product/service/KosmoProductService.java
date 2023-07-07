package a.b.c.com.kos.product.service;

import java.util.List;

import a.b.c.com.kos.product.vo.KosmoProductVO;

public interface KosmoProductService {
	
	public int kosmoProductInsert(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelectAll(KosmoProductVO kpvo);
	public List<KosmoProductVO> kosmoProductSelect(KosmoProductVO kpvo);
	public int getProductTotalCount();

}
