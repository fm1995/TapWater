package com.sy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RdReadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RdReadExample() {
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

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoIsNull() {
            addCriterion("meter_no is null");
            return (Criteria) this;
        }

        public Criteria andMeterNoIsNotNull() {
            addCriterion("meter_no is not null");
            return (Criteria) this;
        }

        public Criteria andMeterNoEqualTo(String value) {
            addCriterion("meter_no =", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotEqualTo(String value) {
            addCriterion("meter_no <>", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoGreaterThan(String value) {
            addCriterion("meter_no >", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoGreaterThanOrEqualTo(String value) {
            addCriterion("meter_no >=", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLessThan(String value) {
            addCriterion("meter_no <", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLessThanOrEqualTo(String value) {
            addCriterion("meter_no <=", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoLike(String value) {
            addCriterion("meter_no like", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotLike(String value) {
            addCriterion("meter_no not like", value, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoIn(List<String> values) {
            addCriterion("meter_no in", values, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotIn(List<String> values) {
            addCriterion("meter_no not in", values, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoBetween(String value1, String value2) {
            addCriterion("meter_no between", value1, value2, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMeterNoNotBetween(String value1, String value2) {
            addCriterion("meter_no not between", value1, value2, "meterNo");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNull() {
            addCriterion("max_value is null");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNotNull() {
            addCriterion("max_value is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValueEqualTo(Integer value) {
            addCriterion("max_value =", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotEqualTo(Integer value) {
            addCriterion("max_value <>", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThan(Integer value) {
            addCriterion("max_value >", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_value >=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThan(Integer value) {
            addCriterion("max_value <", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThanOrEqualTo(Integer value) {
            addCriterion("max_value <=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIn(List<Integer> values) {
            addCriterion("max_value in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotIn(List<Integer> values) {
            addCriterion("max_value not in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueBetween(Integer value1, Integer value2) {
            addCriterion("max_value between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotBetween(Integer value1, Integer value2) {
            addCriterion("max_value not between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andVolumeIdIsNull() {
            addCriterion("volume_id is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIdIsNotNull() {
            addCriterion("volume_id is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeIdEqualTo(Integer value) {
            addCriterion("volume_id =", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdNotEqualTo(Integer value) {
            addCriterion("volume_id <>", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdGreaterThan(Integer value) {
            addCriterion("volume_id >", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume_id >=", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdLessThan(Integer value) {
            addCriterion("volume_id <", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdLessThanOrEqualTo(Integer value) {
            addCriterion("volume_id <=", value, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdIn(List<Integer> values) {
            addCriterion("volume_id in", values, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdNotIn(List<Integer> values) {
            addCriterion("volume_id not in", values, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdBetween(Integer value1, Integer value2) {
            addCriterion("volume_id between", value1, value2, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("volume_id not between", value1, value2, "volumeId");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexIsNull() {
            addCriterion("volume_index is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexIsNotNull() {
            addCriterion("volume_index is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexEqualTo(Integer value) {
            addCriterion("volume_index =", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexNotEqualTo(Integer value) {
            addCriterion("volume_index <>", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexGreaterThan(Integer value) {
            addCriterion("volume_index >", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("volume_index >=", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexLessThan(Integer value) {
            addCriterion("volume_index <", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("volume_index <=", value, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexIn(List<Integer> values) {
            addCriterion("volume_index in", values, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexNotIn(List<Integer> values) {
            addCriterion("volume_index not in", values, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexBetween(Integer value1, Integer value2) {
            addCriterion("volume_index between", value1, value2, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andVolumeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("volume_index not between", value1, value2, "volumeIndex");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdIsNull() {
            addCriterion("read_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdIsNotNull() {
            addCriterion("read_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdEqualTo(Integer value) {
            addCriterion("read_emp_id =", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdNotEqualTo(Integer value) {
            addCriterion("read_emp_id <>", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdGreaterThan(Integer value) {
            addCriterion("read_emp_id >", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_emp_id >=", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdLessThan(Integer value) {
            addCriterion("read_emp_id <", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("read_emp_id <=", value, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdIn(List<Integer> values) {
            addCriterion("read_emp_id in", values, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdNotIn(List<Integer> values) {
            addCriterion("read_emp_id not in", values, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("read_emp_id between", value1, value2, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("read_emp_id not between", value1, value2, "readEmpId");
            return (Criteria) this;
        }

        public Criteria andReadDateIsNull() {
            addCriterion("read_date is null");
            return (Criteria) this;
        }

        public Criteria andReadDateIsNotNull() {
            addCriterion("read_date is not null");
            return (Criteria) this;
        }

        public Criteria andReadDateEqualTo(Date value) {
            addCriterion("read_date =", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateNotEqualTo(Date value) {
            addCriterion("read_date <>", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateGreaterThan(Date value) {
            addCriterion("read_date >", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("read_date >=", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateLessThan(Date value) {
            addCriterion("read_date <", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateLessThanOrEqualTo(Date value) {
            addCriterion("read_date <=", value, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateIn(List<Date> values) {
            addCriterion("read_date in", values, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateNotIn(List<Date> values) {
            addCriterion("read_date not in", values, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateBetween(Date value1, Date value2) {
            addCriterion("read_date between", value1, value2, "readDate");
            return (Criteria) this;
        }

        public Criteria andReadDateNotBetween(Date value1, Date value2) {
            addCriterion("read_date not between", value1, value2, "readDate");
            return (Criteria) this;
        }

        public Criteria andPreValueIsNull() {
            addCriterion("pre_value is null");
            return (Criteria) this;
        }

        public Criteria andPreValueIsNotNull() {
            addCriterion("pre_value is not null");
            return (Criteria) this;
        }

        public Criteria andPreValueEqualTo(Integer value) {
            addCriterion("pre_value =", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueNotEqualTo(Integer value) {
            addCriterion("pre_value <>", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueGreaterThan(Integer value) {
            addCriterion("pre_value >", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_value >=", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueLessThan(Integer value) {
            addCriterion("pre_value <", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueLessThanOrEqualTo(Integer value) {
            addCriterion("pre_value <=", value, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueIn(List<Integer> values) {
            addCriterion("pre_value in", values, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueNotIn(List<Integer> values) {
            addCriterion("pre_value not in", values, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueBetween(Integer value1, Integer value2) {
            addCriterion("pre_value between", value1, value2, "preValue");
            return (Criteria) this;
        }

        public Criteria andPreValueNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_value not between", value1, value2, "preValue");
            return (Criteria) this;
        }

        public Criteria andEnterIsNull() {
            addCriterion("enter is null");
            return (Criteria) this;
        }

        public Criteria andEnterIsNotNull() {
            addCriterion("enter is not null");
            return (Criteria) this;
        }

        public Criteria andEnterEqualTo(Boolean value) {
            addCriterion("enter =", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterNotEqualTo(Boolean value) {
            addCriterion("enter <>", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterGreaterThan(Boolean value) {
            addCriterion("enter >", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enter >=", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterLessThan(Boolean value) {
            addCriterion("enter <", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterLessThanOrEqualTo(Boolean value) {
            addCriterion("enter <=", value, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterIn(List<Boolean> values) {
            addCriterion("enter in", values, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterNotIn(List<Boolean> values) {
            addCriterion("enter not in", values, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterBetween(Boolean value1, Boolean value2) {
            addCriterion("enter between", value1, value2, "enter");
            return (Criteria) this;
        }

        public Criteria andEnterNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enter not between", value1, value2, "enter");
            return (Criteria) this;
        }

        public Criteria andCurValueIsNull() {
            addCriterion("cur_value is null");
            return (Criteria) this;
        }

        public Criteria andCurValueIsNotNull() {
            addCriterion("cur_value is not null");
            return (Criteria) this;
        }

        public Criteria andCurValueEqualTo(Integer value) {
            addCriterion("cur_value =", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueNotEqualTo(Integer value) {
            addCriterion("cur_value <>", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueGreaterThan(Integer value) {
            addCriterion("cur_value >", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_value >=", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueLessThan(Integer value) {
            addCriterion("cur_value <", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueLessThanOrEqualTo(Integer value) {
            addCriterion("cur_value <=", value, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueIn(List<Integer> values) {
            addCriterion("cur_value in", values, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueNotIn(List<Integer> values) {
            addCriterion("cur_value not in", values, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueBetween(Integer value1, Integer value2) {
            addCriterion("cur_value between", value1, value2, "curValue");
            return (Criteria) this;
        }

        public Criteria andCurValueNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_value not between", value1, value2, "curValue");
            return (Criteria) this;
        }

        public Criteria andDialIsNull() {
            addCriterion("dial is null");
            return (Criteria) this;
        }

        public Criteria andDialIsNotNull() {
            addCriterion("dial is not null");
            return (Criteria) this;
        }

        public Criteria andDialEqualTo(Boolean value) {
            addCriterion("dial =", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialNotEqualTo(Boolean value) {
            addCriterion("dial <>", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialGreaterThan(Boolean value) {
            addCriterion("dial >", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dial >=", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialLessThan(Boolean value) {
            addCriterion("dial <", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialLessThanOrEqualTo(Boolean value) {
            addCriterion("dial <=", value, "dial");
            return (Criteria) this;
        }

        public Criteria andDialIn(List<Boolean> values) {
            addCriterion("dial in", values, "dial");
            return (Criteria) this;
        }

        public Criteria andDialNotIn(List<Boolean> values) {
            addCriterion("dial not in", values, "dial");
            return (Criteria) this;
        }

        public Criteria andDialBetween(Boolean value1, Boolean value2) {
            addCriterion("dial between", value1, value2, "dial");
            return (Criteria) this;
        }

        public Criteria andDialNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dial not between", value1, value2, "dial");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNull() {
            addCriterion("formula is null");
            return (Criteria) this;
        }

        public Criteria andFormulaIsNotNull() {
            addCriterion("formula is not null");
            return (Criteria) this;
        }

        public Criteria andFormulaEqualTo(String value) {
            addCriterion("formula =", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotEqualTo(String value) {
            addCriterion("formula <>", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThan(String value) {
            addCriterion("formula >", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("formula >=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThan(String value) {
            addCriterion("formula <", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLessThanOrEqualTo(String value) {
            addCriterion("formula <=", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaLike(String value) {
            addCriterion("formula like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotLike(String value) {
            addCriterion("formula not like", value, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaIn(List<String> values) {
            addCriterion("formula in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotIn(List<String> values) {
            addCriterion("formula not in", values, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaBetween(String value1, String value2) {
            addCriterion("formula between", value1, value2, "formula");
            return (Criteria) this;
        }

        public Criteria andFormulaNotBetween(String value1, String value2) {
            addCriterion("formula not between", value1, value2, "formula");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Boolean value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Boolean value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Boolean value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Boolean value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Boolean value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Boolean> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Boolean> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Boolean value1, Boolean value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIsNull() {
            addCriterion("audit_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIsNotNull() {
            addCriterion("audit_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdEqualTo(Integer value) {
            addCriterion("audit_emp_id =", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotEqualTo(Integer value) {
            addCriterion("audit_emp_id <>", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdGreaterThan(Integer value) {
            addCriterion("audit_emp_id >", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_emp_id >=", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdLessThan(Integer value) {
            addCriterion("audit_emp_id <", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("audit_emp_id <=", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIn(List<Integer> values) {
            addCriterion("audit_emp_id in", values, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotIn(List<Integer> values) {
            addCriterion("audit_emp_id not in", values, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("audit_emp_id between", value1, value2, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_emp_id not between", value1, value2, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNull() {
            addCriterion("audit_date is null");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDateEqualTo(Date value) {
            addCriterion("audit_date =", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotEqualTo(Date value) {
            addCriterion("audit_date <>", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThan(Date value) {
            addCriterion("audit_date >", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_date >=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThan(Date value) {
            addCriterion("audit_date <", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThanOrEqualTo(Date value) {
            addCriterion("audit_date <=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIn(List<Date> values) {
            addCriterion("audit_date in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotIn(List<Date> values) {
            addCriterion("audit_date not in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateBetween(Date value1, Date value2) {
            addCriterion("audit_date between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotBetween(Date value1, Date value2) {
            addCriterion("audit_date not between", value1, value2, "auditDate");
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