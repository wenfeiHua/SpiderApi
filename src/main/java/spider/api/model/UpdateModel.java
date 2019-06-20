package spider.api.model;

public class UpdateModel {

	private int result;

	private String errCode;

	private String errDetail;

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errDetail
	 */
	public String getErrDetail() {
		return errDetail;
	}

	/**
	 * @param errDetail
	 *            the errDetail to set
	 */
	public void setErrDetail(String errDetail) {
		this.errDetail = errDetail;
	}
}
