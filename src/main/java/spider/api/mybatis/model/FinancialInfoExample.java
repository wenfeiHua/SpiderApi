package spider.api.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinancialInfoExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FinancialInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andBanknameIsNull() {
			addCriterion("bankName is null");
			return (Criteria) this;
		}

		public Criteria andBanknameIsNotNull() {
			addCriterion("bankName is not null");
			return (Criteria) this;
		}

		public Criteria andBanknameEqualTo(String value) {
			addCriterion("bankName =", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameNotEqualTo(String value) {
			addCriterion("bankName <>", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameGreaterThan(String value) {
			addCriterion("bankName >", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameGreaterThanOrEqualTo(String value) {
			addCriterion("bankName >=", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameLessThan(String value) {
			addCriterion("bankName <", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameLessThanOrEqualTo(String value) {
			addCriterion("bankName <=", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameLike(String value) {
			addCriterion("bankName like", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameNotLike(String value) {
			addCriterion("bankName not like", value, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameIn(List<String> values) {
			addCriterion("bankName in", values, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameNotIn(List<String> values) {
			addCriterion("bankName not in", values, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameBetween(String value1, String value2) {
			addCriterion("bankName between", value1, value2, "bankname");
			return (Criteria) this;
		}

		public Criteria andBanknameNotBetween(String value1, String value2) {
			addCriterion("bankName not between", value1, value2, "bankname");
			return (Criteria) this;
		}

		public Criteria andProductnameIsNull() {
			addCriterion("productName is null");
			return (Criteria) this;
		}

		public Criteria andProductnameIsNotNull() {
			addCriterion("productName is not null");
			return (Criteria) this;
		}

		public Criteria andProductnameEqualTo(String value) {
			addCriterion("productName =", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameNotEqualTo(String value) {
			addCriterion("productName <>", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameGreaterThan(String value) {
			addCriterion("productName >", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameGreaterThanOrEqualTo(String value) {
			addCriterion("productName >=", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameLessThan(String value) {
			addCriterion("productName <", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameLessThanOrEqualTo(String value) {
			addCriterion("productName <=", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameLike(String value) {
			addCriterion("productName like", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameNotLike(String value) {
			addCriterion("productName not like", value, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameIn(List<String> values) {
			addCriterion("productName in", values, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameNotIn(List<String> values) {
			addCriterion("productName not in", values, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameBetween(String value1, String value2) {
			addCriterion("productName between", value1, value2, "productname");
			return (Criteria) this;
		}

		public Criteria andProductnameNotBetween(String value1, String value2) {
			addCriterion("productName not between", value1, value2, "productname");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeIsNull() {
			addCriterion("investmentTime is null");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeIsNotNull() {
			addCriterion("investmentTime is not null");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeEqualTo(String value) {
			addCriterion("investmentTime =", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeNotEqualTo(String value) {
			addCriterion("investmentTime <>", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeGreaterThan(String value) {
			addCriterion("investmentTime >", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeGreaterThanOrEqualTo(String value) {
			addCriterion("investmentTime >=", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeLessThan(String value) {
			addCriterion("investmentTime <", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeLessThanOrEqualTo(String value) {
			addCriterion("investmentTime <=", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeLike(String value) {
			addCriterion("investmentTime like", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeNotLike(String value) {
			addCriterion("investmentTime not like", value, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeIn(List<String> values) {
			addCriterion("investmentTime in", values, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeNotIn(List<String> values) {
			addCriterion("investmentTime not in", values, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeBetween(String value1, String value2) {
			addCriterion("investmentTime between", value1, value2, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andInvestmenttimeNotBetween(String value1, String value2) {
			addCriterion("investmentTime not between", value1, value2, "investmenttime");
			return (Criteria) this;
		}

		public Criteria andResponserateIsNull() {
			addCriterion("responseRate is null");
			return (Criteria) this;
		}

		public Criteria andResponserateIsNotNull() {
			addCriterion("responseRate is not null");
			return (Criteria) this;
		}

		public Criteria andResponserateEqualTo(Float value) {
			addCriterion("responseRate =", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateNotEqualTo(Float value) {
			addCriterion("responseRate <>", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateGreaterThan(Float value) {
			addCriterion("responseRate >", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateGreaterThanOrEqualTo(Float value) {
			addCriterion("responseRate >=", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateLessThan(Float value) {
			addCriterion("responseRate <", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateLessThanOrEqualTo(Float value) {
			addCriterion("responseRate <=", value, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateIn(List<Float> values) {
			addCriterion("responseRate in", values, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateNotIn(List<Float> values) {
			addCriterion("responseRate not in", values, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateBetween(Float value1, Float value2) {
			addCriterion("responseRate between", value1, value2, "responserate");
			return (Criteria) this;
		}

		public Criteria andResponserateNotBetween(Float value1, Float value2) {
			addCriterion("responseRate not between", value1, value2, "responserate");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createTime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createTime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Date value) {
			addCriterion("createTime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Date value) {
			addCriterion("createTime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Date value) {
			addCriterion("createTime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("createTime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Date value) {
			addCriterion("createTime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
			addCriterion("createTime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Date> values) {
			addCriterion("createTime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Date> values) {
			addCriterion("createTime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Date value1, Date value2) {
			addCriterion("createTime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
			addCriterion("createTime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNull() {
			addCriterion("updateTime is null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIsNotNull() {
			addCriterion("updateTime is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeEqualTo(Date value) {
			addCriterion("updateTime =", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotEqualTo(Date value) {
			addCriterion("updateTime <>", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThan(Date value) {
			addCriterion("updateTime >", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("updateTime >=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThan(Date value) {
			addCriterion("updateTime <", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
			addCriterion("updateTime <=", value, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeIn(List<Date> values) {
			addCriterion("updateTime in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotIn(List<Date> values) {
			addCriterion("updateTime not in", values, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeBetween(Date value1, Date value2) {
			addCriterion("updateTime between", value1, value2, "updatetime");
			return (Criteria) this;
		}

		public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
			addCriterion("updateTime not between", value1, value2, "updatetime");
			return (Criteria) this;
		}

		public Criteria andIsdeleteIsNull() {
			addCriterion("isDelete is null");
			return (Criteria) this;
		}

		public Criteria andIsdeleteIsNotNull() {
			addCriterion("isDelete is not null");
			return (Criteria) this;
		}

		public Criteria andIsdeleteEqualTo(Boolean value) {
			addCriterion("isDelete =", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteNotEqualTo(Boolean value) {
			addCriterion("isDelete <>", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteGreaterThan(Boolean value) {
			addCriterion("isDelete >", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isDelete >=", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteLessThan(Boolean value) {
			addCriterion("isDelete <", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteLessThanOrEqualTo(Boolean value) {
			addCriterion("isDelete <=", value, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteIn(List<Boolean> values) {
			addCriterion("isDelete in", values, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteNotIn(List<Boolean> values) {
			addCriterion("isDelete not in", values, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteBetween(Boolean value1, Boolean value2) {
			addCriterion("isDelete between", value1, value2, "isdelete");
			return (Criteria) this;
		}

		public Criteria andIsdeleteNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isDelete not between", value1, value2, "isdelete");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}