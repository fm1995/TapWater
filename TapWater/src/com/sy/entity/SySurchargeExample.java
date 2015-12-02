package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class SySurchargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SySurchargeExample() {
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

        public Criteria andSurchargeIdIsNull() {
            addCriterion("surcharge_id is null");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdIsNotNull() {
            addCriterion("surcharge_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdEqualTo(Integer value) {
            addCriterion("surcharge_id =", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdNotEqualTo(Integer value) {
            addCriterion("surcharge_id <>", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdGreaterThan(Integer value) {
            addCriterion("surcharge_id >", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("surcharge_id >=", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdLessThan(Integer value) {
            addCriterion("surcharge_id <", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdLessThanOrEqualTo(Integer value) {
            addCriterion("surcharge_id <=", value, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdIn(List<Integer> values) {
            addCriterion("surcharge_id in", values, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdNotIn(List<Integer> values) {
            addCriterion("surcharge_id not in", values, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdBetween(Integer value1, Integer value2) {
            addCriterion("surcharge_id between", value1, value2, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andSurchargeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("surcharge_id not between", value1, value2, "surchargeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdIsNull() {
            addCriterion("water_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdIsNotNull() {
            addCriterion("water_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdEqualTo(Integer value) {
            addCriterion("water_type_id =", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdNotEqualTo(Integer value) {
            addCriterion("water_type_id <>", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdGreaterThan(Integer value) {
            addCriterion("water_type_id >", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("water_type_id >=", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdLessThan(Integer value) {
            addCriterion("water_type_id <", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("water_type_id <=", value, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdIn(List<Integer> values) {
            addCriterion("water_type_id in", values, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdNotIn(List<Integer> values) {
            addCriterion("water_type_id not in", values, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("water_type_id between", value1, value2, "waterTypeId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("water_type_id not between", value1, value2, "waterTypeId");
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