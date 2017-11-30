package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class SyAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyAreaExample() {
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

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkIsNull() {
            addCriterion("area_remark is null");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkIsNotNull() {
            addCriterion("area_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkEqualTo(String value) {
            addCriterion("area_remark =", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkNotEqualTo(String value) {
            addCriterion("area_remark <>", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkGreaterThan(String value) {
            addCriterion("area_remark >", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("area_remark >=", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkLessThan(String value) {
            addCriterion("area_remark <", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkLessThanOrEqualTo(String value) {
            addCriterion("area_remark <=", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkLike(String value) {
            addCriterion("area_remark like", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkNotLike(String value) {
            addCriterion("area_remark not like", value, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkIn(List<String> values) {
            addCriterion("area_remark in", values, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkNotIn(List<String> values) {
            addCriterion("area_remark not in", values, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkBetween(String value1, String value2) {
            addCriterion("area_remark between", value1, value2, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaRemarkNotBetween(String value1, String value2) {
            addCriterion("area_remark not between", value1, value2, "areaRemark");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledIsNull() {
            addCriterion("area_disabled is null");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledIsNotNull() {
            addCriterion("area_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledEqualTo(Boolean value) {
            addCriterion("area_disabled =", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledNotEqualTo(Boolean value) {
            addCriterion("area_disabled <>", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledGreaterThan(Boolean value) {
            addCriterion("area_disabled >", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("area_disabled >=", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledLessThan(Boolean value) {
            addCriterion("area_disabled <", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledLessThanOrEqualTo(Boolean value) {
            addCriterion("area_disabled <=", value, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledIn(List<Boolean> values) {
            addCriterion("area_disabled in", values, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledNotIn(List<Boolean> values) {
            addCriterion("area_disabled not in", values, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledBetween(Boolean value1, Boolean value2) {
            addCriterion("area_disabled between", value1, value2, "areaDisabled");
            return (Criteria) this;
        }

        public Criteria andAreaDisabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("area_disabled not between", value1, value2, "areaDisabled");
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