package a.b.c.com.kos.cart.vo;
import java.util.ArrayList;
import java.util.List;

import a.b.c.com.kos.product.vo.KosmoProductVO;

public class KosmoCart {
	private List<KosmoProductVO> itemSetList = new ArrayList<KosmoProductVO>();
	//getter
	public List<KosmoProductVO> getItemSetList() {
		return itemSetList;
	}
	//같은 상품인 경우 수량만 증가하도록 프로그램 수정
	public void push(KosmoProductVO itemSet) {
	
		itemSetList.add(itemSet);
	}
}
