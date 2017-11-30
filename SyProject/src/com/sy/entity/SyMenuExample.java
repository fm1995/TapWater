package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class SyMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuParentIsNull() {
            addCriterion("menu_parent is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIsNotNull() {
            addCriterion("menu_parent is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentEqualTo(Integer value) {
            addCriterion("menu_parent =", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotEqualTo(Integer value) {
            addCriterion("menu_parent <>", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentGreaterThan(Integer value) {
            addCriterion("menu_parent >", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_parent >=", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentLessThan(Integer value) {
            addCriterion("menu_parent <", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentLessThanOrEqualTo(Integer value) {
            addCriterion("menu_parent <=", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentIn(List<Integer> values) {
            addCriterion("menu_parent in", values, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotIn(List<Integer> values) {
            addCriterion("menu_parent not in", values, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent between", value1, value2, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_parent not between", value1, value2, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickIsNull() {
            addCriterion("menu_on_click is null");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickIsNotNull() {
            addCriterion("menu_on_click is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickEqualTo(String value) {
            addCriterion("menu_on_click =", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickNotEqualTo(String value) {
            addCriterion("menu_on_click <>", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickGreaterThan(String value) {
            addCriterion("menu_on_click >", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickGreaterThanOrEqualTo(String value) {
            addCriterion("menu_on_click >=", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickLessThan(String value) {
            addCriterion("menu_on_click <", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickLessThanOrEqualTo(String value) {
            addCriterion("menu_on_click <=", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickLike(String value) {
            addCriterion("menu_on_click like", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickNotLike(String value) {
            addCriterion("menu_on_click not like", value, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickIn(List<String> values) {
            addCriterion("menu_on_click in", values, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickNotIn(List<String> values) {
            addCriterion("menu_on_click not in", values, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickBetween(String value1, String value2) {
            addCriterion("menu_on_click between", value1, value2, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuOnClickNotBetween(String value1, String value2) {
            addCriterion("menu_on_click not between", value1, value2, "menuOnClick");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("menu_icon is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("menu_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("menu_icon =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("menu_icon <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("menu_icon >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("menu_icon >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("menu_icon <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("menu_icon <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("menu_icon like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("menu_icon not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("menu_icon in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("menu_icon not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("menu_icon between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("menu_icon not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexIsNull() {
            addCriterion("menu_order_index is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexIsNotNull() {
            addCriterion("menu_order_index is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexEqualTo(Integer value) {
            addCriterion("menu_order_index =", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexNotEqualTo(Integer value) {
            addCriterion("menu_order_index <>", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexGreaterThan(Integer value) {
            addCriterion("menu_order_index >", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_order_index >=", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexLessThan(Integer value) {
            addCriterion("menu_order_index <", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexLessThanOrEqualTo(Integer value) {
            addCriterion("menu_order_index <=", value, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexIn(List<Integer> values) {
            addCriterion("menu_order_index in", values, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexNotIn(List<Integer> values) {
            addCriterion("menu_order_index not in", values, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexBetween(Integer value1, Integer value2) {
            addCriterion("menu_order_index between", value1, value2, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_order_index not between", value1, value2, "menuOrderIndex");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Integer value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Integer value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Integer value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Integer value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Integer> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Integer> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Integer value1, Integer value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledIsNull() {
            addCriterion("menu_disabled is null");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledIsNotNull() {
            addCriterion("menu_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledEqualTo(Boolean value) {
            addCriterion("menu_disabled =", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledNotEqualTo(Boolean value) {
            addCriterion("menu_disabled <>", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledGreaterThan(Boolean value) {
            addCriterion("menu_disabled >", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("menu_disabled >=", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledLessThan(Boolean value) {
            addCriterion("menu_disabled <", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledLessThanOrEqualTo(Boolean value) {
            addCriterion("menu_disabled <=", value, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledIn(List<Boolean> values) {
            addCriterion("menu_disabled in", values, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledNotIn(List<Boolean> values) {
            addCriterion("menu_disabled not in", values, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_disabled between", value1, value2, "menuDisabled");
            return (Criteria) this;
        }

        public Criteria andMenuDisabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("menu_disabled not between", value1, value2, "menuDisabled");
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