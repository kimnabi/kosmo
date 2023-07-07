package a.b.c.com.kos.cart.dao;

import java.util.ArrayList;
import java.util.List;

import a.b.c.com.kos.cart.vo.KosmoCartVO;

public interface KosmoCartDAO {
	
	public int kosmoCartInsert(KosmoCartVO kcvo);
	public List<KosmoCartVO> kosmoCartSelectAll(KosmoCartVO kcvo);
	public int kosmoCartDelete(KosmoCartVO kcvo);
	public int kosmoCartDeleteArray(ArrayList<KosmoCartVO> aList);
}
