package a.b.c.com.kos.board.vo;

public class KosBoardVO {
	
	private String bnum;
	private String bsubject;
	private String bname;
	private String bcontent;
	private String bfile;
	private String bpw;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 페이징 이동 필드
	private int pageSize;
	private int groupSize;
	private int curPage;
	private int totalCount;
	
	// 조회수 필드
	private int bhit;
	
	//회원 필드
	private String mnum;
	
	// 좋아요 필드 
	private int blnum;
	private int like_cnt_1;
	private int like_cnt_2;
		
	// 생성자 
	public KosBoardVO() {
		
	}

	// setter / getter
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getBsubject() {
		return bsubject;
	}
	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBpw() {
		return bpw;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	// 페이지 getter / setter
	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(int groupSize) {
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


	// 조회수 getter /s etter
	public int getBhit() {
		return bhit;
	}	
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	
	
	// 회원 getter / setter
	public String getMnum() {
		return mnum;
	}


	public void setMnum(String mnum) {
		this.mnum = mnum;
	}


	// 좋아요 getter / setter
	public int getBlnum() {
		return blnum;
	}	
	public void setBlnum(int blnum) {
		this.blnum = blnum;
	}

	public int getLike_cnt_1() {
		return like_cnt_1;
	}
	public int getLike_cnt_2() {
		return like_cnt_2;
	}

	public void setLike_cnt_1(int like_cnt_1) {
		this.like_cnt_1 = like_cnt_1;
	}
	public void setLike_cnt_2(int like_cnt_2) {
		this.like_cnt_2 = like_cnt_2;
	}
	
}
