package spider.api.mybatis.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BankData extends BaseModel {
	
	private Integer id;

	private String bankname;

	private String bankurl;
	
	private String address;
	
	private String principal;
	
	private String branch;
	
	private Date createtime;

	private Date updatetime;

	private Boolean isdelete;

	public Integer getId() {
		return id;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname == null ? null : bankname.trim();
	}

	public String getBankurl() {
		return bankurl;
	}

	public void setBankurl(String bankurl) {
		this.bankurl = bankurl == null ? null : bankurl.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
	
	/*@Override
	public String toString() {
		return "BankData [bankname=" + bankname + ", bankurl=" + bankurl + ", address=" + address
				+ ", principal=" + principal + ", branch=" + branch + ", createtime=" + createtime + ", updatetime="
				+ updatetime + ", isdelete=" + isdelete + "]";
	}*/

}