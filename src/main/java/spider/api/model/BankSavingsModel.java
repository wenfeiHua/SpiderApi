package spider.api.model;

import spider.api.mybatis.model.BaseModel;

public class BankSavingsModel extends BaseModel{

	private String bankname;

	private Float demanddeposit;

	private Float threemonths;

	private Float oneyear;

	private Float twoyears;

	private Float threeyears;

	private Float fiveyears;

	/**
	 * @return the bankname
	 */
	public String getBankname() {
		return bankname;
	}

	/**
	 * @param bankname the bankname to set
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	/**
	 * @return the demanddeposit
	 */
	public Float getDemanddeposit() {
		return demanddeposit;
	}

	/**
	 * @param demanddeposit the demanddeposit to set
	 */
	public void setDemanddeposit(Float demanddeposit) {
		this.demanddeposit = demanddeposit;
	}

	/**
	 * @return the threemonths
	 */
	public Float getThreemonths() {
		return threemonths;
	}

	/**
	 * @param threemonths the threemonths to set
	 */
	public void setThreemonths(Float threemonths) {
		this.threemonths = threemonths;
	}

	/**
	 * @return the oneyear
	 */
	public Float getOneyear() {
		return oneyear;
	}

	/**
	 * @param oneyear the oneyear to set
	 */
	public void setOneyear(Float oneyear) {
		this.oneyear = oneyear;
	}

	/**
	 * @return the twoyears
	 */
	public Float getTwoyears() {
		return twoyears;
	}

	/**
	 * @param twoyears the twoyears to set
	 */
	public void setTwoyears(Float twoyears) {
		this.twoyears = twoyears;
	}

	/**
	 * @return the threeyears
	 */
	public Float getThreeyears() {
		return threeyears;
	}

	/**
	 * @param threeyears the threeyears to set
	 */
	public void setThreeyears(Float threeyears) {
		this.threeyears = threeyears;
	}

	/**
	 * @return the fiveyears
	 */
	public Float getFiveyears() {
		return fiveyears;
	}

	/**
	 * @param fiveyears the fiveyears to set
	 */
	public void setFiveyears(Float fiveyears) {
		this.fiveyears = fiveyears;
	}
}
