package spider.api.model;

import java.util.List;

import spider.api.mybatis.model.BaseModel;

public class ResultModel {
	private int result;

	private String errCode;

	private String errDetail;

	private List<? extends BaseModel> baseModelList;

	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
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
	 * @param errCode the errCode to set
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
	 * @param errDetail the errDetail to set
	 */
	public void setErrDetail(String errDetail) {
		this.errDetail = errDetail;
	}

	/**
	 * @return the baseModelList
	 */
	public List<? extends BaseModel> getBaseModelList() {
		return baseModelList;
	}

	/**
	 * @param baseModelList the baseModelList to set
	 */
	public void setBaseModelList(List<? extends BaseModel> baseModelList) {
		this.baseModelList = baseModelList;
	}
}
