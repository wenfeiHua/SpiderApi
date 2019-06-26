package spider.api.model;

import spider.api.mybatis.model.BaseModel;

public class BankUrlModel extends BaseModel{

	private String bankname;

	private String bankurl;

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
	 * @return the bankurl
	 */
	public String getBankurl() {
		return bankurl;
	}

	/**
	 * @param bankurl the bankurl to set
	 */
	public void setBankurl(String bankurl) {
		this.bankurl = bankurl;
	}
}
