package a.b.c.com.kos.board.dao;

import java.util.List;

import a.b.c.com.kos.board.vo.KosBoardLikeVO;
import a.b.c.com.kos.board.vo.KosBoardVO;

public interface KosBoardDAO {
	
	public int kosBoardInsert(KosBoardVO kbvo);
	public List<KosBoardVO> kosBoardSelectAll(KosBoardVO kbvo);
	public List<KosBoardVO> kosBoardSelect(KosBoardVO kbvo);	
	
	public List<KosBoardVO> kosBoardPwCheck(KosBoardVO kbvo);
	//좋아요 조회
	public List<KosBoardLikeVO> kosBoardLikeSelect(KosBoardLikeVO kblvo);
	
	public int kosBoardLikeInsert(KosBoardLikeVO blvo);
	
	public int kosBoardLikeUpdate_1(KosBoardLikeVO blvo);
	
	public int kosBoardLikeUpdate_2(KosBoardLikeVO blvo);
	// 게시글 조회 수 
	public int kobBoardBhit(KosBoardVO kbvo);
	
	// 20221111 수정 삭제 추가 eunbh
	public int kosBoardUpdate(KosBoardVO kbvo);
	public int kosBoardDelete(KosBoardVO kbvo);

	public int getTotalCount();
	

}
