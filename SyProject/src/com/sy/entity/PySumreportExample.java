package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class PySumreportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PySumreportExample() {
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

        public Criteria andTypeeIsNull() {
            addCriterion("typee is null");
            return (Criteria) this;
        }

        public Criteria andTypeeIsNotNull() {
            addCriterion("typee is not null");
            return (Criteria) this;
        }

        public Criteria andTypeeEqualTo(Integer value) {
            addCriterion("typee =", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeNotEqualTo(Integer value) {
            addCriterion("typee <>", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeGreaterThan(Integer value) {
            addCriterion("typee >", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("typee >=", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeLessThan(Integer value) {
            addCriterion("typee <", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeLessThanOrEqualTo(Integer value) {
            addCriterion("typee <=", value, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeIn(List<Integer> values) {
            addCriterion("typee in", values, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeNotIn(List<Integer> values) {
            addCriterion("typee not in", values, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeBetween(Integer value1, Integer value2) {
            addCriterion("typee between", value1, value2, "typee");
            return (Criteria) this;
        }

        public Criteria andTypeeNotBetween(Integer value1, Integer value2) {
            addCriterion("typee not between", value1, value2, "typee");
            return (Criteria) this;
        }

        public Criteria andReportYearIsNull() {
            addCriterion("report_year is null");
            return (Criteria) this;
        }

        public Criteria andReportYearIsNotNull() {
            addCriterion("report_year is not null");
            return (Criteria) this;
        }

        public Criteria andReportYearEqualTo(Integer value) {
            addCriterion("report_year =", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotEqualTo(Integer value) {
            addCriterion("report_year <>", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearGreaterThan(Integer value) {
            addCriterion("report_year >", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_year >=", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearLessThan(Integer value) {
            addCriterion("report_year <", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearLessThanOrEqualTo(Integer value) {
            addCriterion("report_year <=", value, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearIn(List<Integer> values) {
            addCriterion("report_year in", values, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotIn(List<Integer> values) {
            addCriterion("report_year not in", values, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearBetween(Integer value1, Integer value2) {
            addCriterion("report_year between", value1, value2, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportYearNotBetween(Integer value1, Integer value2) {
            addCriterion("report_year not between", value1, value2, "reportYear");
            return (Criteria) this;
        }

        public Criteria andReportMonthIsNull() {
            addCriterion("report_month is null");
            return (Criteria) this;
        }

        public Criteria andReportMonthIsNotNull() {
            addCriterion("report_month is not null");
            return (Criteria) this;
        }

        public Criteria andReportMonthEqualTo(Integer value) {
            addCriterion("report_month =", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotEqualTo(Integer value) {
            addCriterion("report_month <>", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthGreaterThan(Integer value) {
            addCriterion("report_month >", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_month >=", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthLessThan(Integer value) {
            addCriterion("report_month <", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthLessThanOrEqualTo(Integer value) {
            addCriterion("report_month <=", value, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthIn(List<Integer> values) {
            addCriterion("report_month in", values, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotIn(List<Integer> values) {
            addCriterion("report_month not in", values, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthBetween(Integer value1, Integer value2) {
            addCriterion("report_month between", value1, value2, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andReportMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("report_month not between", value1, value2, "reportMonth");
            return (Criteria) this;
        }

        public Criteria andLineNoIsNull() {
            addCriterion("line_no is null");
            return (Criteria) this;
        }

        public Criteria andLineNoIsNotNull() {
            addCriterion("line_no is not null");
            return (Criteria) this;
        }

        public Criteria andLineNoEqualTo(Integer value) {
            addCriterion("line_no =", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotEqualTo(Integer value) {
            addCriterion("line_no <>", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoGreaterThan(Integer value) {
            addCriterion("line_no >", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_no >=", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoLessThan(Integer value) {
            addCriterion("line_no <", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoLessThanOrEqualTo(Integer value) {
            addCriterion("line_no <=", value, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoIn(List<Integer> values) {
            addCriterion("line_no in", values, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotIn(List<Integer> values) {
            addCriterion("line_no not in", values, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoBetween(Integer value1, Integer value2) {
            addCriterion("line_no between", value1, value2, "lineNo");
            return (Criteria) this;
        }

        public Criteria andLineNoNotBetween(Integer value1, Integer value2) {
            addCriterion("line_no not between", value1, value2, "lineNo");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(String value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(String value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(String value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(String value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(String value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(String value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Like(String value) {
            addCriterion("c1 like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotLike(String value) {
            addCriterion("c1 not like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<String> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<String> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(String value1, String value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(String value1, String value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(String value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(String value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(String value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(String value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(String value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(String value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Like(String value) {
            addCriterion("c2 like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotLike(String value) {
            addCriterion("c2 not like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<String> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<String> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(String value1, String value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(String value1, String value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC3IsNull() {
            addCriterion("c3 is null");
            return (Criteria) this;
        }

        public Criteria andC3IsNotNull() {
            addCriterion("c3 is not null");
            return (Criteria) this;
        }

        public Criteria andC3EqualTo(String value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(String value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(String value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(String value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(String value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(String value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Like(String value) {
            addCriterion("c3 like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotLike(String value) {
            addCriterion("c3 not like", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<String> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<String> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(String value1, String value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(String value1, String value2) {
            addCriterion("c3 not between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC4IsNull() {
            addCriterion("c4 is null");
            return (Criteria) this;
        }

        public Criteria andC4IsNotNull() {
            addCriterion("c4 is not null");
            return (Criteria) this;
        }

        public Criteria andC4EqualTo(String value) {
            addCriterion("c4 =", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotEqualTo(String value) {
            addCriterion("c4 <>", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThan(String value) {
            addCriterion("c4 >", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4GreaterThanOrEqualTo(String value) {
            addCriterion("c4 >=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThan(String value) {
            addCriterion("c4 <", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4LessThanOrEqualTo(String value) {
            addCriterion("c4 <=", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Like(String value) {
            addCriterion("c4 like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotLike(String value) {
            addCriterion("c4 not like", value, "c4");
            return (Criteria) this;
        }

        public Criteria andC4In(List<String> values) {
            addCriterion("c4 in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotIn(List<String> values) {
            addCriterion("c4 not in", values, "c4");
            return (Criteria) this;
        }

        public Criteria andC4Between(String value1, String value2) {
            addCriterion("c4 between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC4NotBetween(String value1, String value2) {
            addCriterion("c4 not between", value1, value2, "c4");
            return (Criteria) this;
        }

        public Criteria andC5IsNull() {
            addCriterion("c5 is null");
            return (Criteria) this;
        }

        public Criteria andC5IsNotNull() {
            addCriterion("c5 is not null");
            return (Criteria) this;
        }

        public Criteria andC5EqualTo(String value) {
            addCriterion("c5 =", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotEqualTo(String value) {
            addCriterion("c5 <>", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5GreaterThan(String value) {
            addCriterion("c5 >", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5GreaterThanOrEqualTo(String value) {
            addCriterion("c5 >=", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5LessThan(String value) {
            addCriterion("c5 <", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5LessThanOrEqualTo(String value) {
            addCriterion("c5 <=", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5Like(String value) {
            addCriterion("c5 like", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotLike(String value) {
            addCriterion("c5 not like", value, "c5");
            return (Criteria) this;
        }

        public Criteria andC5In(List<String> values) {
            addCriterion("c5 in", values, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotIn(List<String> values) {
            addCriterion("c5 not in", values, "c5");
            return (Criteria) this;
        }

        public Criteria andC5Between(String value1, String value2) {
            addCriterion("c5 between", value1, value2, "c5");
            return (Criteria) this;
        }

        public Criteria andC5NotBetween(String value1, String value2) {
            addCriterion("c5 not between", value1, value2, "c5");
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