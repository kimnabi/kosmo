package a.b.c.com.kos.cart.vo;

import java.util.Arrays;

public class KosmoCartVO {

	private String kcnum;
	private String kpid;
	private String kpname;
	private String kpfile;
	private String kpcnt;
	private String kpprice;
	private String kppricesum;	
	private String kpnum;
	private String kmnum;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	private String kcnumarr[];

	public KosmoCartVO() {
		super();
	}

	public String getKcnum() {
		return kcnum;
	}

	public void setKcnum(String kcnum) {
		this.kcnum = kcnum;
	}

	public String getKpid() {
		return kpid;
	}

	public void setKpid(String kpid) {
		this.kpid = kpid;
	}

	public String getKpname() {
		return kpname;
	}

	public void setKpname(String kpname) {
		this.kpname = kpname;
	}

	public String getKpfile() {
		return kpfile;
	}

	public void setKpfile(String kpfile) {
		this.kpfile = kpfile;
	}

	public String getKpcnt() {
		return kpcnt;
	}

	public void setKpcnt(String kpcnt) {
		this.kpcnt = kpcnt;
	}

	public String getKpprice() {
		return kpprice;
	}

	public void setKpprice(String kpprice) {
		this.kpprice = kpprice;
	}

	public String getKppricesum() {
		return kppricesum;
	}

	public void setKppricesum(String kppricesum) {
		this.kppricesum = kppricesum;
	}

	public String getKpnum() {
		return kpnum;
	}

	public void setKpnum(String kpnum) {
		this.kpnum = kpnum;
	}

	public String getKmnum() {
		return kmnum;
	}

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
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

	public String[] getKcnumarr() {
		return kcnumarr;
	}

	public void setKcnumarr(String[] kcnumarr) {
		this.kcnumarr = kcnumarr;
	}

	@Override
	public String toString() {
		return "KosmoCartVO [kcnum=" + kcnum + ", kpid=" + kpid + ", kpname=" + kpname + ", kpfile=" + kpfile
				+ ", kpcnt=" + kpcnt + ", kpprice=" + kpprice + ", kppricesum=" + kppricesum + ", kpnum=" + kpnum
				+ ", kmnum=" + kmnum + ", deleteyn=" + deleteyn + ", insertdate=" + insertdate + ", updatedate="
				+ updatedate + ", kcnumarr=" + Arrays.toString(kcnumarr) + "]";
	}
	
	
}
