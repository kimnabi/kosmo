package a.b.c.com.kos.product.vo;

public class KosProductPasingVO {
	
	
	
	// 페이징 이동 필드
	private int perPageNum;
	private String groupSize;
	private int curPage;
	private int totalCount;
	
	
		
	// 생성자 
	public KosProductPasingVO() {
		
	}



	public int getPerPageNum() {
		return perPageNum;
	}



	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}



	public String getGroupSize() {
		return groupSize;
	}



	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}



	public int getCurPage() {
		return curPage;
	}



	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}



	public int getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}



	@Override
	public String toString() {
		return "KosBoardPasingVO [perPageNum=" + perPageNum + ", groupSize=" + groupSize + ", curPage=" + curPage
				+ ", totalCount=" + totalCount + "]";
	}

	// 페이지 getter / setter
	
	
}
