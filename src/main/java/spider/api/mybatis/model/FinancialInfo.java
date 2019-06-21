package spider.api.mybatis.model;

import java.util.Date;

public class FinancialInfo extends BaseModel {
	private Integer id;

	private String bankname;

	private String productname;

	private String investmenttime;

	private Float responserate;

	private Date createtime;

	private Date updatetime;

	private Boolean isdelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname == null ? null : bankname.trim();
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname == null ? null : productname.trim();
	}

	public String getInvestmenttime() {
		return investmenttime;
	}

	public void setInvestmenttime(String investmenttime) {
		this.investmenttime = investmenttime == null ? null : investmenttime.trim();
	}

	public Float getResponserate() {
		return responserate;
	}

	public void setResponserate(Float responserate) {
		this.responserate = responserate;
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

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
}