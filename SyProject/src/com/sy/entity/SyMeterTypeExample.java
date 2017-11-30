package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class SyMeterTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyMeterTypeExample() {
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

        public Criteria andMetertypeIdIsNull() {
            addCriterion("metertype_id is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdIsNotNull() {
            addCriterion("metertype_id is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdEqualTo(Integer value) {
            addCriterion("metertype_id =", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdNotEqualTo(Integer value) {
            addCriterion("metertype_id <>", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdGreaterThan(Integer value) {
            addCriterion("metertype_id >", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("metertype_id >=", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdLessThan(Integer value) {
            addCriterion("metertype_id <", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("metertype_id <=", value, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdIn(List<Integer> values) {
            addCriterion("metertype_id in", values, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdNotIn(List<Integer> values) {
            addCriterion("metertype_id not in", values, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdBetween(Integer value1, Integer value2) {
            addCriterion("metertype_id between", value1, value2, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMetertypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("metertype_id not between", value1, value2, "metertypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameIsNull() {
            addCriterion("meter_type_name is null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameIsNotNull() {
            addCriterion("meter_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameEqualTo(String value) {
            addCriterion("meter_type_name =", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotEqualTo(String value) {
            addCriterion("meter_type_name <>", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameGreaterThan(String value) {
            addCriterion("meter_type_name >", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("meter_type_name >=", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLessThan(String value) {
            addCriterion("meter_type_name <", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLessThanOrEqualTo(String value) {
            addCriterion("meter_type_name <=", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLike(String value) {
            addCriterion("meter_type_name like", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotLike(String value) {
            addCriterion("meter_type_name not like", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameIn(List<String> values) {
            addCriterion("meter_type_name in", values, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotIn(List<String> values) {
            addCriterion("meter_type_name not in", values, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameBetween(String value1, String value2) {
            addCriterion("meter_type_name between", value1, value2, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotBetween(String value1, String value2) {
            addCriterion("meter_type_name not between", value1, value2, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureIsNull() {
            addCriterion("metertype_aperture is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureIsNotNull() {
            addCriterion("metertype_aperture is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureEqualTo(Integer value) {
            addCriterion("metertype_aperture =", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureNotEqualTo(Integer value) {
            addCriterion("metertype_aperture <>", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureGreaterThan(Integer value) {
            addCriterion("metertype_aperture >", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureGreaterThanOrEqualTo(Integer value) {
            addCriterion("metertype_aperture >=", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureLessThan(Integer value) {
            addCriterion("metertype_aperture <", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureLessThanOrEqualTo(Integer value) {
            addCriterion("metertype_aperture <=", value, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureIn(List<Integer> values) {
            addCriterion("metertype_aperture in", values, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureNotIn(List<Integer> values) {
            addCriterion("metertype_aperture not in", values, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureBetween(Integer value1, Integer value2) {
            addCriterion("metertype_aperture between", value1, value2, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeApertureNotBetween(Integer value1, Integer value2) {
            addCriterion("metertype_aperture not between", value1, value2, "metertypeAperture");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueIsNull() {
            addCriterion("metertype_max_value is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueIsNotNull() {
            addCriterion("metertype_max_value is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueEqualTo(Integer value) {
            addCriterion("metertype_max_value =", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueNotEqualTo(Integer value) {
            addCriterion("metertype_max_value <>", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueGreaterThan(Integer value) {
            addCriterion("metertype_max_value >", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("metertype_max_value >=", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueLessThan(Integer value) {
            addCriterion("metertype_max_value <", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueLessThanOrEqualTo(Integer value) {
            addCriterion("metertype_max_value <=", value, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueIn(List<Integer> values) {
            addCriterion("metertype_max_value in", values, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueNotIn(List<Integer> values) {
            addCriterion("metertype_max_value not in", values, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueBetween(Integer value1, Integer value2) {
            addCriterion("metertype_max_value between", value1, value2, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMaxValueNotBetween(Integer value1, Integer value2) {
            addCriterion("metertype_max_value not between", value1, value2, "metertypeMaxValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueIsNull() {
            addCriterion("metertype_min_value is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueIsNotNull() {
            addCriterion("metertype_min_value is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueEqualTo(Integer value) {
            addCriterion("metertype_min_value =", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueNotEqualTo(Integer value) {
            addCriterion("metertype_min_value <>", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueGreaterThan(Integer value) {
            addCriterion("metertype_min_value >", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("metertype_min_value >=", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueLessThan(Integer value) {
            addCriterion("metertype_min_value <", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueLessThanOrEqualTo(Integer value) {
            addCriterion("metertype_min_value <=", value, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueIn(List<Integer> values) {
            addCriterion("metertype_min_value in", values, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueNotIn(List<Integer> values) {
            addCriterion("metertype_min_value not in", values, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueBetween(Integer value1, Integer value2) {
            addCriterion("metertype_min_value between", value1, value2, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeMinValueNotBetween(Integer value1, Integer value2) {
            addCriterion("metertype_min_value not between", value1, value2, "metertypeMinValue");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeIsNull() {
            addCriterion("metertype_life is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeIsNotNull() {
            addCriterion("metertype_life is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeEqualTo(Integer value) {
            addCriterion("metertype_life =", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeNotEqualTo(Integer value) {
            addCriterion("metertype_life <>", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeGreaterThan(Integer value) {
            addCriterion("metertype_life >", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeGreaterThanOrEqualTo(Integer value) {
            addCriterion("metertype_life >=", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeLessThan(Integer value) {
            addCriterion("metertype_life <", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeLessThanOrEqualTo(Integer value) {
            addCriterion("metertype_life <=", value, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeIn(List<Integer> values) {
            addCriterion("metertype_life in", values, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeNotIn(List<Integer> values) {
            addCriterion("metertype_life not in", values, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeBetween(Integer value1, Integer value2) {
            addCriterion("metertype_life between", value1, value2, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeLifeNotBetween(Integer value1, Integer value2) {
            addCriterion("metertype_life not between", value1, value2, "metertypeLife");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkIsNull() {
            addCriterion("metertype_remark is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkIsNotNull() {
            addCriterion("metertype_remark is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkEqualTo(String value) {
            addCriterion("metertype_remark =", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkNotEqualTo(String value) {
            addCriterion("metertype_remark <>", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkGreaterThan(String value) {
            addCriterion("metertype_remark >", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("metertype_remark >=", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkLessThan(String value) {
            addCriterion("metertype_remark <", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkLessThanOrEqualTo(String value) {
            addCriterion("metertype_remark <=", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkLike(String value) {
            addCriterion("metertype_remark like", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkNotLike(String value) {
            addCriterion("metertype_remark not like", value, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkIn(List<String> values) {
            addCriterion("metertype_remark in", values, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkNotIn(List<String> values) {
            addCriterion("metertype_remark not in", values, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkBetween(String value1, String value2) {
            addCriterion("metertype_remark between", value1, value2, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeRemarkNotBetween(String value1, String value2) {
            addCriterion("metertype_remark not between", value1, value2, "metertypeRemark");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledIsNull() {
            addCriterion("metertype_disabled is null");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledIsNotNull() {
            addCriterion("metertype_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledEqualTo(Boolean value) {
            addCriterion("metertype_disabled =", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledNotEqualTo(Boolean value) {
            addCriterion("metertype_disabled <>", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledGreaterThan(Boolean value) {
            addCriterion("metertype_disabled >", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("metertype_disabled >=", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledLessThan(Boolean value) {
            addCriterion("metertype_disabled <", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledLessThanOrEqualTo(Boolean value) {
            addCriterion("metertype_disabled <=", value, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledIn(List<Boolean> values) {
            addCriterion("metertype_disabled in", values, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledNotIn(List<Boolean> values) {
            addCriterion("metertype_disabled not in", values, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledBetween(Boolean value1, Boolean value2) {
            addCriterion("metertype_disabled between", value1, value2, "metertypeDisabled");
            return (Criteria) this;
        }

        public Criteria andMetertypeDisabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("metertype_disabled not between", value1, value2, "metertypeDisabled");
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