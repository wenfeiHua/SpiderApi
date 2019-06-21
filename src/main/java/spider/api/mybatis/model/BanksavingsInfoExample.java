package spider.api.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BanksavingsInfoExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public BanksavingsInfoExample() {
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

		public Criteria andDemanddepositIsNull() {
			addCriterion("demandDeposit is null");
			return (Criteria) this;
		}

		public Criteria andDemanddepositIsNotNull() {
			addCriterion("demandDeposit is not null");
			return (Criteria) this;
		}

		public Criteria andDemanddepositEqualTo(Float value) {
			addCriterion("demandDeposit =", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositNotEqualTo(Float value) {
			addCriterion("demandDeposit <>", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositGreaterThan(Float value) {
			addCriterion("demandDeposit >", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositGreaterThanOrEqualTo(Float value) {
			addCriterion("demandDeposit >=", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositLessThan(Float value) {
			addCriterion("demandDeposit <", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositLessThanOrEqualTo(Float value) {
			addCriterion("demandDeposit <=", value, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositIn(List<Float> values) {
			addCriterion("demandDeposit in", values, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositNotIn(List<Float> values) {
			addCriterion("demandDeposit not in", values, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositBetween(Float value1, Float value2) {
			addCriterion("demandDeposit between", value1, value2, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andDemanddepositNotBetween(Float value1, Float value2) {
			addCriterion("demandDeposit not between", value1, value2, "demanddeposit");
			return (Criteria) this;
		}

		public Criteria andThreemonthsIsNull() {
			addCriterion("threeMonths is null");
			return (Criteria) this;
		}

		public Criteria andThreemonthsIsNotNull() {
			addCriterion("threeMonths is not null");
			return (Criteria) this;
		}

		public Criteria andThreemonthsEqualTo(Float value) {
			addCriterion("threeMonths =", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsNotEqualTo(Float value) {
			addCriterion("threeMonths <>", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsGreaterThan(Float value) {
			addCriterion("threeMonths >", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsGreaterThanOrEqualTo(Float value) {
			addCriterion("threeMonths >=", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsLessThan(Float value) {
			addCriterion("threeMonths <", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsLessThanOrEqualTo(Float value) {
			addCriterion("threeMonths <=", value, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsIn(List<Float> values) {
			addCriterion("threeMonths in", values, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsNotIn(List<Float> values) {
			addCriterion("threeMonths not in", values, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsBetween(Float value1, Float value2) {
			addCriterion("threeMonths between", value1, value2, "threemonths");
			return (Criteria) this;
		}

		public Criteria andThreemonthsNotBetween(Float value1, Float value2) {
			addCriterion("threeMonths not between", value1, value2, "threemonths");
			return (Criteria) this;
		}

		public Criteria andOneyearIsNull() {
			addCriterion("oneYear is null");
			return (Criteria) this;
		}

		public Criteria andOneyearIsNotNull() {
			addCriterion("oneYear is not null");
			return (Criteria) this;
		}

		public Criteria andOneyearEqualTo(Float value) {
			addCriterion("oneYear =", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearNotEqualTo(Float value) {
			addCriterion("oneYear <>", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearGreaterThan(Float value) {
			addCriterion("oneYear >", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearGreaterThanOrEqualTo(Float value) {
			addCriterion("oneYear >=", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearLessThan(Float value) {
			addCriterion("oneYear <", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearLessThanOrEqualTo(Float value) {
			addCriterion("oneYear <=", value, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearIn(List<Float> values) {
			addCriterion("oneYear in", values, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearNotIn(List<Float> values) {
			addCriterion("oneYear not in", values, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearBetween(Float value1, Float value2) {
			addCriterion("oneYear between", value1, value2, "oneyear");
			return (Criteria) this;
		}

		public Criteria andOneyearNotBetween(Float value1, Float value2) {
			addCriterion("oneYear not between", value1, value2, "oneyear");
			return (Criteria) this;
		}

		public Criteria andTwoyearsIsNull() {
			addCriterion("twoYears is null");
			return (Criteria) this;
		}

		public Criteria andTwoyearsIsNotNull() {
			addCriterion("twoYears is not null");
			return (Criteria) this;
		}

		public Criteria andTwoyearsEqualTo(Float value) {
			addCriterion("twoYears =", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsNotEqualTo(Float value) {
			addCriterion("twoYears <>", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsGreaterThan(Float value) {
			addCriterion("twoYears >", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsGreaterThanOrEqualTo(Float value) {
			addCriterion("twoYears >=", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsLessThan(Float value) {
			addCriterion("twoYears <", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsLessThanOrEqualTo(Float value) {
			addCriterion("twoYears <=", value, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsIn(List<Float> values) {
			addCriterion("twoYears in", values, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsNotIn(List<Float> values) {
			addCriterion("twoYears not in", values, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsBetween(Float value1, Float value2) {
			addCriterion("twoYears between", value1, value2, "twoyears");
			return (Criteria) this;
		}

		public Criteria andTwoyearsNotBetween(Float value1, Float value2) {
			addCriterion("twoYears not between", value1, value2, "twoyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsIsNull() {
			addCriterion("threeYears is null");
			return (Criteria) this;
		}

		public Criteria andThreeyearsIsNotNull() {
			addCriterion("threeYears is not null");
			return (Criteria) this;
		}

		public Criteria andThreeyearsEqualTo(Float value) {
			addCriterion("threeYears =", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsNotEqualTo(Float value) {
			addCriterion("threeYears <>", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsGreaterThan(Float value) {
			addCriterion("threeYears >", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsGreaterThanOrEqualTo(Float value) {
			addCriterion("threeYears >=", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsLessThan(Float value) {
			addCriterion("threeYears <", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsLessThanOrEqualTo(Float value) {
			addCriterion("threeYears <=", value, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsIn(List<Float> values) {
			addCriterion("threeYears in", values, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsNotIn(List<Float> values) {
			addCriterion("threeYears not in", values, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsBetween(Float value1, Float value2) {
			addCriterion("threeYears between", value1, value2, "threeyears");
			return (Criteria) this;
		}

		public Criteria andThreeyearsNotBetween(Float value1, Float value2) {
			addCriterion("threeYears not between", value1, value2, "threeyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsIsNull() {
			addCriterion("fiveYears is null");
			return (Criteria) this;
		}

		public Criteria andFiveyearsIsNotNull() {
			addCriterion("fiveYears is not null");
			return (Criteria) this;
		}

		public Criteria andFiveyearsEqualTo(Float value) {
			addCriterion("fiveYears =", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsNotEqualTo(Float value) {
			addCriterion("fiveYears <>", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsGreaterThan(Float value) {
			addCriterion("fiveYears >", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsGreaterThanOrEqualTo(Float value) {
			addCriterion("fiveYears >=", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsLessThan(Float value) {
			addCriterion("fiveYears <", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsLessThanOrEqualTo(Float value) {
			addCriterion("fiveYears <=", value, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsIn(List<Float> values) {
			addCriterion("fiveYears in", values, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsNotIn(List<Float> values) {
			addCriterion("fiveYears not in", values, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsBetween(Float value1, Float value2) {
			addCriterion("fiveYears between", value1, value2, "fiveyears");
			return (Criteria) this;
		}

		public Criteria andFiveyearsNotBetween(Float value1, Float value2) {
			addCriterion("fiveYears not between", value1, value2, "fiveyears");
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