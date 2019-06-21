package spider.api.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankloanInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankloanInfoExample() {
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

        public Criteria andShorttermIsNull() {
            addCriterion("shortTerm is null");
            return (Criteria) this;
        }

        public Criteria andShorttermIsNotNull() {
            addCriterion("shortTerm is not null");
            return (Criteria) this;
        }

        public Criteria andShorttermEqualTo(Integer value) {
            addCriterion("shortTerm =", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermNotEqualTo(Integer value) {
            addCriterion("shortTerm <>", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermGreaterThan(Integer value) {
            addCriterion("shortTerm >", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermGreaterThanOrEqualTo(Integer value) {
            addCriterion("shortTerm >=", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermLessThan(Integer value) {
            addCriterion("shortTerm <", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermLessThanOrEqualTo(Integer value) {
            addCriterion("shortTerm <=", value, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermIn(List<Integer> values) {
            addCriterion("shortTerm in", values, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermNotIn(List<Integer> values) {
            addCriterion("shortTerm not in", values, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermBetween(Integer value1, Integer value2) {
            addCriterion("shortTerm between", value1, value2, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermNotBetween(Integer value1, Integer value2) {
            addCriterion("shortTerm not between", value1, value2, "shortterm");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaIsNull() {
            addCriterion("shortTermQuota is null");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaIsNotNull() {
            addCriterion("shortTermQuota is not null");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaEqualTo(String value) {
            addCriterion("shortTermQuota =", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaNotEqualTo(String value) {
            addCriterion("shortTermQuota <>", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaGreaterThan(String value) {
            addCriterion("shortTermQuota >", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaGreaterThanOrEqualTo(String value) {
            addCriterion("shortTermQuota >=", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaLessThan(String value) {
            addCriterion("shortTermQuota <", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaLessThanOrEqualTo(String value) {
            addCriterion("shortTermQuota <=", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaLike(String value) {
            addCriterion("shortTermQuota like", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaNotLike(String value) {
            addCriterion("shortTermQuota not like", value, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaIn(List<String> values) {
            addCriterion("shortTermQuota in", values, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaNotIn(List<String> values) {
            addCriterion("shortTermQuota not in", values, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaBetween(String value1, String value2) {
            addCriterion("shortTermQuota between", value1, value2, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermquotaNotBetween(String value1, String value2) {
            addCriterion("shortTermQuota not between", value1, value2, "shorttermquota");
            return (Criteria) this;
        }

        public Criteria andShorttermloanIsNull() {
            addCriterion("shortTermLoan is null");
            return (Criteria) this;
        }

        public Criteria andShorttermloanIsNotNull() {
            addCriterion("shortTermLoan is not null");
            return (Criteria) this;
        }

        public Criteria andShorttermloanEqualTo(Float value) {
            addCriterion("shortTermLoan =", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanNotEqualTo(Float value) {
            addCriterion("shortTermLoan <>", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanGreaterThan(Float value) {
            addCriterion("shortTermLoan >", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanGreaterThanOrEqualTo(Float value) {
            addCriterion("shortTermLoan >=", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanLessThan(Float value) {
            addCriterion("shortTermLoan <", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanLessThanOrEqualTo(Float value) {
            addCriterion("shortTermLoan <=", value, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanIn(List<Float> values) {
            addCriterion("shortTermLoan in", values, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanNotIn(List<Float> values) {
            addCriterion("shortTermLoan not in", values, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanBetween(Float value1, Float value2) {
            addCriterion("shortTermLoan between", value1, value2, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andShorttermloanNotBetween(Float value1, Float value2) {
            addCriterion("shortTermLoan not between", value1, value2, "shorttermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermIsNull() {
            addCriterion("mediumTerm is null");
            return (Criteria) this;
        }

        public Criteria andMediumtermIsNotNull() {
            addCriterion("mediumTerm is not null");
            return (Criteria) this;
        }

        public Criteria andMediumtermEqualTo(Integer value) {
            addCriterion("mediumTerm =", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermNotEqualTo(Integer value) {
            addCriterion("mediumTerm <>", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermGreaterThan(Integer value) {
            addCriterion("mediumTerm >", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermGreaterThanOrEqualTo(Integer value) {
            addCriterion("mediumTerm >=", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermLessThan(Integer value) {
            addCriterion("mediumTerm <", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermLessThanOrEqualTo(Integer value) {
            addCriterion("mediumTerm <=", value, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermIn(List<Integer> values) {
            addCriterion("mediumTerm in", values, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermNotIn(List<Integer> values) {
            addCriterion("mediumTerm not in", values, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermBetween(Integer value1, Integer value2) {
            addCriterion("mediumTerm between", value1, value2, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermNotBetween(Integer value1, Integer value2) {
            addCriterion("mediumTerm not between", value1, value2, "mediumterm");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaIsNull() {
            addCriterion("mediumTermQuota is null");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaIsNotNull() {
            addCriterion("mediumTermQuota is not null");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaEqualTo(String value) {
            addCriterion("mediumTermQuota =", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaNotEqualTo(String value) {
            addCriterion("mediumTermQuota <>", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaGreaterThan(String value) {
            addCriterion("mediumTermQuota >", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaGreaterThanOrEqualTo(String value) {
            addCriterion("mediumTermQuota >=", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaLessThan(String value) {
            addCriterion("mediumTermQuota <", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaLessThanOrEqualTo(String value) {
            addCriterion("mediumTermQuota <=", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaLike(String value) {
            addCriterion("mediumTermQuota like", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaNotLike(String value) {
            addCriterion("mediumTermQuota not like", value, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaIn(List<String> values) {
            addCriterion("mediumTermQuota in", values, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaNotIn(List<String> values) {
            addCriterion("mediumTermQuota not in", values, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaBetween(String value1, String value2) {
            addCriterion("mediumTermQuota between", value1, value2, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermquotaNotBetween(String value1, String value2) {
            addCriterion("mediumTermQuota not between", value1, value2, "mediumtermquota");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanIsNull() {
            addCriterion("mediumTermLoan is null");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanIsNotNull() {
            addCriterion("mediumTermLoan is not null");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanEqualTo(Float value) {
            addCriterion("mediumTermLoan =", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanNotEqualTo(Float value) {
            addCriterion("mediumTermLoan <>", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanGreaterThan(Float value) {
            addCriterion("mediumTermLoan >", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanGreaterThanOrEqualTo(Float value) {
            addCriterion("mediumTermLoan >=", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanLessThan(Float value) {
            addCriterion("mediumTermLoan <", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanLessThanOrEqualTo(Float value) {
            addCriterion("mediumTermLoan <=", value, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanIn(List<Float> values) {
            addCriterion("mediumTermLoan in", values, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanNotIn(List<Float> values) {
            addCriterion("mediumTermLoan not in", values, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanBetween(Float value1, Float value2) {
            addCriterion("mediumTermLoan between", value1, value2, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andMediumtermloanNotBetween(Float value1, Float value2) {
            addCriterion("mediumTermLoan not between", value1, value2, "mediumtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermIsNull() {
            addCriterion("longTerm is null");
            return (Criteria) this;
        }

        public Criteria andLongtermIsNotNull() {
            addCriterion("longTerm is not null");
            return (Criteria) this;
        }

        public Criteria andLongtermEqualTo(Integer value) {
            addCriterion("longTerm =", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermNotEqualTo(Integer value) {
            addCriterion("longTerm <>", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermGreaterThan(Integer value) {
            addCriterion("longTerm >", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermGreaterThanOrEqualTo(Integer value) {
            addCriterion("longTerm >=", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermLessThan(Integer value) {
            addCriterion("longTerm <", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermLessThanOrEqualTo(Integer value) {
            addCriterion("longTerm <=", value, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermIn(List<Integer> values) {
            addCriterion("longTerm in", values, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermNotIn(List<Integer> values) {
            addCriterion("longTerm not in", values, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermBetween(Integer value1, Integer value2) {
            addCriterion("longTerm between", value1, value2, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermNotBetween(Integer value1, Integer value2) {
            addCriterion("longTerm not between", value1, value2, "longterm");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaIsNull() {
            addCriterion("longTermQuota is null");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaIsNotNull() {
            addCriterion("longTermQuota is not null");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaEqualTo(String value) {
            addCriterion("longTermQuota =", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaNotEqualTo(String value) {
            addCriterion("longTermQuota <>", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaGreaterThan(String value) {
            addCriterion("longTermQuota >", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaGreaterThanOrEqualTo(String value) {
            addCriterion("longTermQuota >=", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaLessThan(String value) {
            addCriterion("longTermQuota <", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaLessThanOrEqualTo(String value) {
            addCriterion("longTermQuota <=", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaLike(String value) {
            addCriterion("longTermQuota like", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaNotLike(String value) {
            addCriterion("longTermQuota not like", value, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaIn(List<String> values) {
            addCriterion("longTermQuota in", values, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaNotIn(List<String> values) {
            addCriterion("longTermQuota not in", values, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaBetween(String value1, String value2) {
            addCriterion("longTermQuota between", value1, value2, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermquotaNotBetween(String value1, String value2) {
            addCriterion("longTermQuota not between", value1, value2, "longtermquota");
            return (Criteria) this;
        }

        public Criteria andLongtermloanIsNull() {
            addCriterion("longTermLoan is null");
            return (Criteria) this;
        }

        public Criteria andLongtermloanIsNotNull() {
            addCriterion("longTermLoan is not null");
            return (Criteria) this;
        }

        public Criteria andLongtermloanEqualTo(Float value) {
            addCriterion("longTermLoan =", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanNotEqualTo(Float value) {
            addCriterion("longTermLoan <>", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanGreaterThan(Float value) {
            addCriterion("longTermLoan >", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanGreaterThanOrEqualTo(Float value) {
            addCriterion("longTermLoan >=", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanLessThan(Float value) {
            addCriterion("longTermLoan <", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanLessThanOrEqualTo(Float value) {
            addCriterion("longTermLoan <=", value, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanIn(List<Float> values) {
            addCriterion("longTermLoan in", values, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanNotIn(List<Float> values) {
            addCriterion("longTermLoan not in", values, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanBetween(Float value1, Float value2) {
            addCriterion("longTermLoan between", value1, value2, "longtermloan");
            return (Criteria) this;
        }

        public Criteria andLongtermloanNotBetween(Float value1, Float value2) {
            addCriterion("longTermLoan not between", value1, value2, "longtermloan");
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