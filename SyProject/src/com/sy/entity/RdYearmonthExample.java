package com.sy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RdYearmonthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RdYearmonthExample() {
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

        public Criteria andReadYearIsNull() {
            addCriterion("read_year is null");
            return (Criteria) this;
        }

        public Criteria andReadYearIsNotNull() {
            addCriterion("read_year is not null");
            return (Criteria) this;
        }

        public Criteria andReadYearEqualTo(Integer value) {
            addCriterion("read_year =", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearNotEqualTo(Integer value) {
            addCriterion("read_year <>", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearGreaterThan(Integer value) {
            addCriterion("read_year >", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_year >=", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearLessThan(Integer value) {
            addCriterion("read_year <", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearLessThanOrEqualTo(Integer value) {
            addCriterion("read_year <=", value, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearIn(List<Integer> values) {
            addCriterion("read_year in", values, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearNotIn(List<Integer> values) {
            addCriterion("read_year not in", values, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearBetween(Integer value1, Integer value2) {
            addCriterion("read_year between", value1, value2, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadYearNotBetween(Integer value1, Integer value2) {
            addCriterion("read_year not between", value1, value2, "readYear");
            return (Criteria) this;
        }

        public Criteria andReadMonthIsNull() {
            addCriterion("read_month is null");
            return (Criteria) this;
        }

        public Criteria andReadMonthIsNotNull() {
            addCriterion("read_month is not null");
            return (Criteria) this;
        }

        public Criteria andReadMonthEqualTo(Integer value) {
            addCriterion("read_month =", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthNotEqualTo(Integer value) {
            addCriterion("read_month <>", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthGreaterThan(Integer value) {
            addCriterion("read_month >", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_month >=", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthLessThan(Integer value) {
            addCriterion("read_month <", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthLessThanOrEqualTo(Integer value) {
            addCriterion("read_month <=", value, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthIn(List<Integer> values) {
            addCriterion("read_month in", values, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthNotIn(List<Integer> values) {
            addCriterion("read_month not in", values, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthBetween(Integer value1, Integer value2) {
            addCriterion("read_month between", value1, value2, "readMonth");
            return (Criteria) this;
        }

        public Criteria andReadMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("read_month not between", value1, value2, "readMonth");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIsNull() {
            addCriterion("is_current is null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIsNotNull() {
            addCriterion("is_current is not null");
            return (Criteria) this;
        }

        public Criteria andIsCurrentEqualTo(Boolean value) {
            addCriterion("is_current =", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotEqualTo(Boolean value) {
            addCriterion("is_current <>", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentGreaterThan(Boolean value) {
            addCriterion("is_current >", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_current >=", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentLessThan(Boolean value) {
            addCriterion("is_current <", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_current <=", value, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentIn(List<Boolean> values) {
            addCriterion("is_current in", values, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotIn(List<Boolean> values) {
            addCriterion("is_current not in", values, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_current between", value1, value2, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andIsCurrentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_current not between", value1, value2, "isCurrent");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdIsNull() {
            addCriterion("init_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdIsNotNull() {
            addCriterion("init_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdEqualTo(Integer value) {
            addCriterion("init_emp_id =", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdNotEqualTo(Integer value) {
            addCriterion("init_emp_id <>", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdGreaterThan(Integer value) {
            addCriterion("init_emp_id >", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("init_emp_id >=", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdLessThan(Integer value) {
            addCriterion("init_emp_id <", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("init_emp_id <=", value, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdIn(List<Integer> values) {
            addCriterion("init_emp_id in", values, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdNotIn(List<Integer> values) {
            addCriterion("init_emp_id not in", values, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("init_emp_id between", value1, value2, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("init_emp_id not between", value1, value2, "initEmpId");
            return (Criteria) this;
        }

        public Criteria andInitDateIsNull() {
            addCriterion("init_date is null");
            return (Criteria) this;
        }

        public Criteria andInitDateIsNotNull() {
            addCriterion("init_date is not null");
            return (Criteria) this;
        }

        public Criteria andInitDateEqualTo(Date value) {
            addCriterion("init_date =", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotEqualTo(Date value) {
            addCriterion("init_date <>", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateGreaterThan(Date value) {
            addCriterion("init_date >", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("init_date >=", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateLessThan(Date value) {
            addCriterion("init_date <", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateLessThanOrEqualTo(Date value) {
            addCriterion("init_date <=", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateIn(List<Date> values) {
            addCriterion("init_date in", values, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotIn(List<Date> values) {
            addCriterion("init_date not in", values, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateBetween(Date value1, Date value2) {
            addCriterion("init_date between", value1, value2, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotBetween(Date value1, Date value2) {
            addCriterion("init_date not between", value1, value2, "initDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
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