package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SyCostTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyCostTypeExample() {
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

        public Criteria andCosttypeIdIsNull() {
            addCriterion("costtype_id is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdIsNotNull() {
            addCriterion("costtype_id is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdEqualTo(Integer value) {
            addCriterion("costtype_id =", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdNotEqualTo(Integer value) {
            addCriterion("costtype_id <>", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdGreaterThan(Integer value) {
            addCriterion("costtype_id >", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("costtype_id >=", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdLessThan(Integer value) {
            addCriterion("costtype_id <", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("costtype_id <=", value, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdIn(List<Integer> values) {
            addCriterion("costtype_id in", values, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdNotIn(List<Integer> values) {
            addCriterion("costtype_id not in", values, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdBetween(Integer value1, Integer value2) {
            addCriterion("costtype_id between", value1, value2, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("costtype_id not between", value1, value2, "costtypeId");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindIsNull() {
            addCriterion("costtype_kind is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindIsNotNull() {
            addCriterion("costtype_kind is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindEqualTo(Integer value) {
            addCriterion("costtype_kind =", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindNotEqualTo(Integer value) {
            addCriterion("costtype_kind <>", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindGreaterThan(Integer value) {
            addCriterion("costtype_kind >", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("costtype_kind >=", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindLessThan(Integer value) {
            addCriterion("costtype_kind <", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindLessThanOrEqualTo(Integer value) {
            addCriterion("costtype_kind <=", value, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindIn(List<Integer> values) {
            addCriterion("costtype_kind in", values, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindNotIn(List<Integer> values) {
            addCriterion("costtype_kind not in", values, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindBetween(Integer value1, Integer value2) {
            addCriterion("costtype_kind between", value1, value2, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeKindNotBetween(Integer value1, Integer value2) {
            addCriterion("costtype_kind not between", value1, value2, "costtypeKind");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeIsNull() {
            addCriterion("costtype_code is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeIsNotNull() {
            addCriterion("costtype_code is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeEqualTo(String value) {
            addCriterion("costtype_code =", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeNotEqualTo(String value) {
            addCriterion("costtype_code <>", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeGreaterThan(String value) {
            addCriterion("costtype_code >", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("costtype_code >=", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeLessThan(String value) {
            addCriterion("costtype_code <", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeLessThanOrEqualTo(String value) {
            addCriterion("costtype_code <=", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeLike(String value) {
            addCriterion("costtype_code like", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeNotLike(String value) {
            addCriterion("costtype_code not like", value, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeIn(List<String> values) {
            addCriterion("costtype_code in", values, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeNotIn(List<String> values) {
            addCriterion("costtype_code not in", values, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeBetween(String value1, String value2) {
            addCriterion("costtype_code between", value1, value2, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCosttypeCodeNotBetween(String value1, String value2) {
            addCriterion("costtype_code not between", value1, value2, "costtypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIsNull() {
            addCriterion("cost_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIsNotNull() {
            addCriterion("cost_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameEqualTo(String value) {
            addCriterion("cost_type_name =", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotEqualTo(String value) {
            addCriterion("cost_type_name <>", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameGreaterThan(String value) {
            addCriterion("cost_type_name >", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("cost_type_name >=", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLessThan(String value) {
            addCriterion("cost_type_name <", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLessThanOrEqualTo(String value) {
            addCriterion("cost_type_name <=", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLike(String value) {
            addCriterion("cost_type_name like", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotLike(String value) {
            addCriterion("cost_type_name not like", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIn(List<String> values) {
            addCriterion("cost_type_name in", values, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotIn(List<String> values) {
            addCriterion("cost_type_name not in", values, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameBetween(String value1, String value2) {
            addCriterion("cost_type_name between", value1, value2, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotBetween(String value1, String value2) {
            addCriterion("cost_type_name not between", value1, value2, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameIsNull() {
            addCriterion("costtype_full_name is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameIsNotNull() {
            addCriterion("costtype_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameEqualTo(String value) {
            addCriterion("costtype_full_name =", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameNotEqualTo(String value) {
            addCriterion("costtype_full_name <>", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameGreaterThan(String value) {
            addCriterion("costtype_full_name >", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("costtype_full_name >=", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameLessThan(String value) {
            addCriterion("costtype_full_name <", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameLessThanOrEqualTo(String value) {
            addCriterion("costtype_full_name <=", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameLike(String value) {
            addCriterion("costtype_full_name like", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameNotLike(String value) {
            addCriterion("costtype_full_name not like", value, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameIn(List<String> values) {
            addCriterion("costtype_full_name in", values, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameNotIn(List<String> values) {
            addCriterion("costtype_full_name not in", values, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameBetween(String value1, String value2) {
            addCriterion("costtype_full_name between", value1, value2, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypeFullNameNotBetween(String value1, String value2) {
            addCriterion("costtype_full_name not between", value1, value2, "costtypeFullName");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceIsNull() {
            addCriterion("costtype_price is null");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceIsNotNull() {
            addCriterion("costtype_price is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceEqualTo(BigDecimal value) {
            addCriterion("costtype_price =", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceNotEqualTo(BigDecimal value) {
            addCriterion("costtype_price <>", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceGreaterThan(BigDecimal value) {
            addCriterion("costtype_price >", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("costtype_price >=", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceLessThan(BigDecimal value) {
            addCriterion("costtype_price <", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("costtype_price <=", value, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceIn(List<BigDecimal> values) {
            addCriterion("costtype_price in", values, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceNotIn(List<BigDecimal> values) {
            addCriterion("costtype_price not in", values, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costtype_price between", value1, value2, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("costtype_price not between", value1, value2, "costtypePrice");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextIsNull() {
            addCriterion("costtype_surcharge_text is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextIsNotNull() {
            addCriterion("costtype_surcharge_text is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextEqualTo(String value) {
            addCriterion("costtype_surcharge_text =", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextNotEqualTo(String value) {
            addCriterion("costtype_surcharge_text <>", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextGreaterThan(String value) {
            addCriterion("costtype_surcharge_text >", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextGreaterThanOrEqualTo(String value) {
            addCriterion("costtype_surcharge_text >=", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextLessThan(String value) {
            addCriterion("costtype_surcharge_text <", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextLessThanOrEqualTo(String value) {
            addCriterion("costtype_surcharge_text <=", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextLike(String value) {
            addCriterion("costtype_surcharge_text like", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextNotLike(String value) {
            addCriterion("costtype_surcharge_text not like", value, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextIn(List<String> values) {
            addCriterion("costtype_surcharge_text in", values, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextNotIn(List<String> values) {
            addCriterion("costtype_surcharge_text not in", values, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextBetween(String value1, String value2) {
            addCriterion("costtype_surcharge_text between", value1, value2, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeSurchargeTextNotBetween(String value1, String value2) {
            addCriterion("costtype_surcharge_text not between", value1, value2, "costtypeSurchargeText");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkIsNull() {
            addCriterion("costtype_remark is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkIsNotNull() {
            addCriterion("costtype_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkEqualTo(String value) {
            addCriterion("costtype_remark =", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkNotEqualTo(String value) {
            addCriterion("costtype_remark <>", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkGreaterThan(String value) {
            addCriterion("costtype_remark >", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("costtype_remark >=", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkLessThan(String value) {
            addCriterion("costtype_remark <", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkLessThanOrEqualTo(String value) {
            addCriterion("costtype_remark <=", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkLike(String value) {
            addCriterion("costtype_remark like", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkNotLike(String value) {
            addCriterion("costtype_remark not like", value, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkIn(List<String> values) {
            addCriterion("costtype_remark in", values, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkNotIn(List<String> values) {
            addCriterion("costtype_remark not in", values, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkBetween(String value1, String value2) {
            addCriterion("costtype_remark between", value1, value2, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeRemarkNotBetween(String value1, String value2) {
            addCriterion("costtype_remark not between", value1, value2, "costtypeRemark");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledIsNull() {
            addCriterion("costtype_disabled is null");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledIsNotNull() {
            addCriterion("costtype_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledEqualTo(Boolean value) {
            addCriterion("costtype_disabled =", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledNotEqualTo(Boolean value) {
            addCriterion("costtype_disabled <>", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledGreaterThan(Boolean value) {
            addCriterion("costtype_disabled >", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("costtype_disabled >=", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledLessThan(Boolean value) {
            addCriterion("costtype_disabled <", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledLessThanOrEqualTo(Boolean value) {
            addCriterion("costtype_disabled <=", value, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledIn(List<Boolean> values) {
            addCriterion("costtype_disabled in", values, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledNotIn(List<Boolean> values) {
            addCriterion("costtype_disabled not in", values, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledBetween(Boolean value1, Boolean value2) {
            addCriterion("costtype_disabled between", value1, value2, "costtypeDisabled");
            return (Criteria) this;
        }

        public Criteria andCosttypeDisabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("costtype_disabled not between", value1, value2, "costtypeDisabled");
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