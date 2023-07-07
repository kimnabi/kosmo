package a.b.c.com.common.chabun.service;

import a.b.c.com.kos.board.vo.KosBoardVO;
import a.b.c.com.kos.cart.vo.KosmoCartVO;
import a.b.c.com.kos.mem.vo.KosMemberVO;
import a.b.c.com.kos.order.vo.KosmoOrderVO;
import a.b.c.com.kos.product.vo.KosmoProductVO;
import a.b.c.com.kos.rboard.vo.KosRboardVO;

public interface KosChabunService {

	public KosMemberVO getKosMemberChabun();
	
	public KosBoardVO getKosBoardChabun();
	
	public KosRboardVO getKosRboardChabun();
	
	public KosmoProductVO getProductChabun();
	
	public KosmoCartVO getCartChabun();
	
	public KosmoOrderVO getOrderChabun();

}
