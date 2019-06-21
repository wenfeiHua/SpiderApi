package spider.api.mybatis.model;

import java.util.Date;

public class BanksavingsInfo extends BaseModel {
	private Integer id;

	private String bankname;

	private Float demanddeposit;

	private Float threemonths;

	private Float oneyear;

	private Float twoyears;

	private Float threeyears;

	private Float fiveyears;

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

	public Float getDemanddeposit() {
		return demanddeposit;
	}

	public void setDemanddeposit(Float demanddeposit) {
		this.demanddeposit = demanddeposit;
	}

	public Float getThreemonths() {
		return threemonths;
	}

	public void setThreemonths(Float threemonths) {
		this.threemonths = threemonths;
	}

	public Float getOneyear() {
		return oneyear;
	}

	public void setOneyear(Float oneyear) {
		this.oneyear = oneyear;
	}

	public Float getTwoyears() {
		return twoyears;
	}

	public void setTwoyears(Float twoyears) {
		this.twoyears = twoyears;
	}

	public Float getThreeyears() {
		return threeyears;
	}

	public void setThreeyears(Float threeyears) {
		this.threeyears = threeyears;
	}

	public Float getFiveyears() {
		return fiveyears;
	}

	public void setFiveyears(Float fiveyears) {
		this.fiveyears = fiveyears;
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