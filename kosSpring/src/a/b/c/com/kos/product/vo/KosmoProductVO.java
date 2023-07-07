package a.b.c.com.kos.product.vo;

public class KosmoProductVO {
	
	private String kpnum;
	private String kpid;
	private String kpname;
	private String kpcompany;
	private String kpfile;
	private String kpcnt;
	private String kpprice;
	private String kpdesc;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 페이징 이동 필드
	private int pageSize;
	private String groupSize;
	private int curPage;
	private int totalCount;
	
	
	// 생성자 
	public KosmoProductVO() {
		
	}

	
	// setter / getter
	public String getKpnum() {
		return kpnum;
	}
	public String getKpid() {
		return kpid;
	}
	public String getKpname() {
		return kpname;
	}
	public String getKpcompany() {
		return kpcompany;
	}
	public String getKpfile() {
		return kpfile;
	}
	public String getKpcnt() {
		return kpcnt;
	}
	public String getKpprice() {
		return kpprice;
	}
	public String getKpdesc() {
		return kpdesc;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public int getPageSize() {
		return pageSize;
	}
	public String getGroupSize() {
		return groupSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setKpnum(String kpnum) {
		this.kpnum = kpnum;
	}
	public void setKpid(String kpid) {
		this.kpid = kpid;
	}
	public void setKpname(String kpname) {
		this.kpname = kpname;
	}
	public void setKpcompany(String kpcompany) {
		this.kpcompany = kpcompany;
	}
	public void setKpfile(String kpfile) {
		this.kpfile = kpfile;
	}
	public void setKpcnt(String kpcnt) {
		this.kpcnt = kpcnt;
	}
	public void setKpprice(String kpprice) {
		this.kpprice = kpprice;
	}
	public void setKpdesc(String kpdesc) {
		this.kpdesc = kpdesc;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
