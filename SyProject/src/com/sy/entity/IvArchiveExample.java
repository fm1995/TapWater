package com.sy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IvArchiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IvArchiveExample() {
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

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andInIdIsNull() {
            addCriterion("in_id is null");
            return (Criteria) this;
        }

        public Criteria andInIdIsNotNull() {
            addCriterion("in_id is not null");
            return (Criteria) this;
        }

        public Criteria andInIdEqualTo(Integer value) {
            addCriterion("in_id =", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotEqualTo(Integer value) {
            addCriterion("in_id <>", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdGreaterThan(Integer value) {
            addCriterion("in_id >", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_id >=", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdLessThan(Integer value) {
            addCriterion("in_id <", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_id <=", value, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdIn(List<Integer> values) {
            addCriterion("in_id in", values, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotIn(List<Integer> values) {
            addCriterion("in_id not in", values, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdBetween(Integer value1, Integer value2) {
            addCriterion("in_id between", value1, value2, "inId");
            return (Criteria) this;
        }

        public Criteria andInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_id not between", value1, value2, "inId");
            return (Criteria) this;
        }

        public Criteria andStartNoIsNull() {
            addCriterion("start_no is null");
            return (Criteria) this;
        }

        public Criteria andStartNoIsNotNull() {
            addCriterion("start_no is not null");
            return (Criteria) this;
        }

        public Criteria andStartNoEqualTo(String value) {
            addCriterion("start_no =", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoNotEqualTo(String value) {
            addCriterion("start_no <>", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoGreaterThan(String value) {
            addCriterion("start_no >", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoGreaterThanOrEqualTo(String value) {
            addCriterion("start_no >=", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoLessThan(String value) {
            addCriterion("start_no <", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoLessThanOrEqualTo(String value) {
            addCriterion("start_no <=", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoLike(String value) {
            addCriterion("start_no like", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoNotLike(String value) {
            addCriterion("start_no not like", value, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoIn(List<String> values) {
            addCriterion("start_no in", values, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoNotIn(List<String> values) {
            addCriterion("start_no not in", values, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoBetween(String value1, String value2) {
            addCriterion("start_no between", value1, value2, "startNo");
            return (Criteria) this;
        }

        public Criteria andStartNoNotBetween(String value1, String value2) {
            addCriterion("start_no not between", value1, value2, "startNo");
            return (Criteria) this;
        }

        public Criteria andEndNoIsNull() {
            addCriterion("end_no is null");
            return (Criteria) this;
        }

        public Criteria andEndNoIsNotNull() {
            addCriterion("end_no is not null");
            return (Criteria) this;
        }

        public Criteria andEndNoEqualTo(String value) {
            addCriterion("end_no =", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotEqualTo(String value) {
            addCriterion("end_no <>", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoGreaterThan(String value) {
            addCriterion("end_no >", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoGreaterThanOrEqualTo(String value) {
            addCriterion("end_no >=", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLessThan(String value) {
            addCriterion("end_no <", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLessThanOrEqualTo(String value) {
            addCriterion("end_no <=", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoLike(String value) {
            addCriterion("end_no like", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotLike(String value) {
            addCriterion("end_no not like", value, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoIn(List<String> values) {
            addCriterion("end_no in", values, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotIn(List<String> values) {
            addCriterion("end_no not in", values, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoBetween(String value1, String value2) {
            addCriterion("end_no between", value1, value2, "endNo");
            return (Criteria) this;
        }

        public Criteria andEndNoNotBetween(String value1, String value2) {
            addCriterion("end_no not between", value1, value2, "endNo");
            return (Criteria) this;
        }

        public Criteria andCountsIsNull() {
            addCriterion("counts is null");
            return (Criteria) this;
        }

        public Criteria andCountsIsNotNull() {
            addCriterion("counts is not null");
            return (Criteria) this;
        }

        public Criteria andCountsEqualTo(Integer value) {
            addCriterion("counts =", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotEqualTo(Integer value) {
            addCriterion("counts <>", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThan(Integer value) {
            addCriterion("counts >", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("counts >=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThan(Integer value) {
            addCriterion("counts <", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThanOrEqualTo(Integer value) {
            addCriterion("counts <=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsIn(List<Integer> values) {
            addCriterion("counts in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotIn(List<Integer> values) {
            addCriterion("counts not in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsBetween(Integer value1, Integer value2) {
            addCriterion("counts between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("counts not between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andArchiveDateIsNull() {
            addCriterion("archive_date is null");
            return (Criteria) this;
        }

        public Criteria andArchiveDateIsNotNull() {
            addCriterion("archive_date is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveDateEqualTo(Date value) {
            addCriterion("archive_date =", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateNotEqualTo(Date value) {
            addCriterion("archive_date <>", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateGreaterThan(Date value) {
            addCriterion("archive_date >", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("archive_date >=", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateLessThan(Date value) {
            addCriterion("archive_date <", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateLessThanOrEqualTo(Date value) {
            addCriterion("archive_date <=", value, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateIn(List<Date> values) {
            addCriterion("archive_date in", values, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateNotIn(List<Date> values) {
            addCriterion("archive_date not in", values, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateBetween(Date value1, Date value2) {
            addCriterion("archive_date between", value1, value2, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveDateNotBetween(Date value1, Date value2) {
            addCriterion("archive_date not between", value1, value2, "archiveDate");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdIsNull() {
            addCriterion("archive_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdIsNotNull() {
            addCriterion("archive_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdEqualTo(Integer value) {
            addCriterion("archive_emp_id =", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdNotEqualTo(Integer value) {
            addCriterion("archive_emp_id <>", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdGreaterThan(Integer value) {
            addCriterion("archive_emp_id >", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("archive_emp_id >=", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdLessThan(Integer value) {
            addCriterion("archive_emp_id <", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("archive_emp_id <=", value, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdIn(List<Integer> values) {
            addCriterion("archive_emp_id in", values, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdNotIn(List<Integer> values) {
            addCriterion("archive_emp_id not in", values, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("archive_emp_id between", value1, value2, "archiveEmpId");
            return (Criteria) this;
        }

        public Criteria andArchiveEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("archive_emp_id not between", value1, value2, "archiveEmpId");
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