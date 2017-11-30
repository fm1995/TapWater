package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class BeFormulaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BeFormulaExample() {
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

        public Criteria andOrderUserIdIsNull() {
            addCriterion("order_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNotNull() {
            addCriterion("order_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdEqualTo(Integer value) {
            addCriterion("order_user_id =", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotEqualTo(Integer value) {
            addCriterion("order_user_id <>", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThan(Integer value) {
            addCriterion("order_user_id >", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_user_id >=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThan(Integer value) {
            addCriterion("order_user_id <", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_user_id <=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIn(List<Integer> values) {
            addCriterion("order_user_id in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotIn(List<Integer> values) {
            addCriterion("order_user_id not in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdBetween(Integer value1, Integer value2) {
            addCriterion("order_user_id between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_user_id not between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeIsNull() {
            addCriterion("water_type_code is null");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeIsNotNull() {
            addCriterion("water_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeEqualTo(String value) {
            addCriterion("water_type_code =", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeNotEqualTo(String value) {
            addCriterion("water_type_code <>", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeGreaterThan(String value) {
            addCriterion("water_type_code >", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("water_type_code >=", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeLessThan(String value) {
            addCriterion("water_type_code <", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("water_type_code <=", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeLike(String value) {
            addCriterion("water_type_code like", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeNotLike(String value) {
            addCriterion("water_type_code not like", value, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeIn(List<String> values) {
            addCriterion("water_type_code in", values, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeNotIn(List<String> values) {
            addCriterion("water_type_code not in", values, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeBetween(String value1, String value2) {
            addCriterion("water_type_code between", value1, value2, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andWaterTypeCodeNotBetween(String value1, String value2) {
            addCriterion("water_type_code not between", value1, value2, "waterTypeCode");
            return (Criteria) this;
        }

        public Criteria andAllotTextIsNull() {
            addCriterion("allot_text is null");
            return (Criteria) this;
        }

        public Criteria andAllotTextIsNotNull() {
            addCriterion("allot_text is not null");
            return (Criteria) this;
        }

        public Criteria andAllotTextEqualTo(String value) {
            addCriterion("allot_text =", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextNotEqualTo(String value) {
            addCriterion("allot_text <>", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextGreaterThan(String value) {
            addCriterion("allot_text >", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextGreaterThanOrEqualTo(String value) {
            addCriterion("allot_text >=", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextLessThan(String value) {
            addCriterion("allot_text <", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextLessThanOrEqualTo(String value) {
            addCriterion("allot_text <=", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextLike(String value) {
            addCriterion("allot_text like", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextNotLike(String value) {
            addCriterion("allot_text not like", value, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextIn(List<String> values) {
            addCriterion("allot_text in", values, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextNotIn(List<String> values) {
            addCriterion("allot_text not in", values, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextBetween(String value1, String value2) {
            addCriterion("allot_text between", value1, value2, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTextNotBetween(String value1, String value2) {
            addCriterion("allot_text not between", value1, value2, "allotText");
            return (Criteria) this;
        }

        public Criteria andAllotTypeIsNull() {
            addCriterion("allot_type is null");
            return (Criteria) this;
        }

        public Criteria andAllotTypeIsNotNull() {
            addCriterion("allot_type is not null");
            return (Criteria) this;
        }

        public Criteria andAllotTypeEqualTo(Integer value) {
            addCriterion("allot_type =", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeNotEqualTo(Integer value) {
            addCriterion("allot_type <>", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeGreaterThan(Integer value) {
            addCriterion("allot_type >", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("allot_type >=", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeLessThan(Integer value) {
            addCriterion("allot_type <", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeLessThanOrEqualTo(Integer value) {
            addCriterion("allot_type <=", value, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeIn(List<Integer> values) {
            addCriterion("allot_type in", values, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeNotIn(List<Integer> values) {
            addCriterion("allot_type not in", values, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeBetween(Integer value1, Integer value2) {
            addCriterion("allot_type between", value1, value2, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("allot_type not between", value1, value2, "allotType");
            return (Criteria) this;
        }

        public Criteria andAllotValueIsNull() {
            addCriterion("allot_value is null");
            return (Criteria) this;
        }

        public Criteria andAllotValueIsNotNull() {
            addCriterion("allot_value is not null");
            return (Criteria) this;
        }

        public Criteria andAllotValueEqualTo(Integer value) {
            addCriterion("allot_value =", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueNotEqualTo(Integer value) {
            addCriterion("allot_value <>", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueGreaterThan(Integer value) {
            addCriterion("allot_value >", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("allot_value >=", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueLessThan(Integer value) {
            addCriterion("allot_value <", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueLessThanOrEqualTo(Integer value) {
            addCriterion("allot_value <=", value, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueIn(List<Integer> values) {
            addCriterion("allot_value in", values, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueNotIn(List<Integer> values) {
            addCriterion("allot_value not in", values, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueBetween(Integer value1, Integer value2) {
            addCriterion("allot_value between", value1, value2, "allotValue");
            return (Criteria) this;
        }

        public Criteria andAllotValueNotBetween(Integer value1, Integer value2) {
            addCriterion("allot_value not between", value1, value2, "allotValue");
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