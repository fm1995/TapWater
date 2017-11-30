package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PyUserhistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyUserhistoryExample() {
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

        public Criteria andUsernoIsNull() {
            addCriterion("userno is null");
            return (Criteria) this;
        }

        public Criteria andUsernoIsNotNull() {
            addCriterion("userno is not null");
            return (Criteria) this;
        }

        public Criteria andUsernoEqualTo(String value) {
            addCriterion("userno =", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotEqualTo(String value) {
            addCriterion("userno <>", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThan(String value) {
            addCriterion("userno >", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThanOrEqualTo(String value) {
            addCriterion("userno >=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThan(String value) {
            addCriterion("userno <", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThanOrEqualTo(String value) {
            addCriterion("userno <=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLike(String value) {
            addCriterion("userno like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotLike(String value) {
            addCriterion("userno not like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoIn(List<String> values) {
            addCriterion("userno in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotIn(List<String> values) {
            addCriterion("userno not in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoBetween(String value1, String value2) {
            addCriterion("userno between", value1, value2, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotBetween(String value1, String value2) {
            addCriterion("userno not between", value1, value2, "userno");
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

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderno like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderno not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andDateeIsNull() {
            addCriterion("datee is null");
            return (Criteria) this;
        }

        public Criteria andDateeIsNotNull() {
            addCriterion("datee is not null");
            return (Criteria) this;
        }

        public Criteria andDateeEqualTo(Date value) {
            addCriterion("datee =", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeNotEqualTo(Date value) {
            addCriterion("datee <>", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeGreaterThan(Date value) {
            addCriterion("datee >", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeGreaterThanOrEqualTo(Date value) {
            addCriterion("datee >=", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeLessThan(Date value) {
            addCriterion("datee <", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeLessThanOrEqualTo(Date value) {
            addCriterion("datee <=", value, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeIn(List<Date> values) {
            addCriterion("datee in", values, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeNotIn(List<Date> values) {
            addCriterion("datee not in", values, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeBetween(Date value1, Date value2) {
            addCriterion("datee between", value1, value2, "datee");
            return (Criteria) this;
        }

        public Criteria andDateeNotBetween(Date value1, Date value2) {
            addCriterion("datee not between", value1, value2, "datee");
            return (Criteria) this;
        }

        public Criteria andPrevalueIsNull() {
            addCriterion("prevalue is null");
            return (Criteria) this;
        }

        public Criteria andPrevalueIsNotNull() {
            addCriterion("prevalue is not null");
            return (Criteria) this;
        }

        public Criteria andPrevalueEqualTo(Integer value) {
            addCriterion("prevalue =", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueNotEqualTo(Integer value) {
            addCriterion("prevalue <>", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueGreaterThan(Integer value) {
            addCriterion("prevalue >", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("prevalue >=", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueLessThan(Integer value) {
            addCriterion("prevalue <", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueLessThanOrEqualTo(Integer value) {
            addCriterion("prevalue <=", value, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueIn(List<Integer> values) {
            addCriterion("prevalue in", values, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueNotIn(List<Integer> values) {
            addCriterion("prevalue not in", values, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueBetween(Integer value1, Integer value2) {
            addCriterion("prevalue between", value1, value2, "prevalue");
            return (Criteria) this;
        }

        public Criteria andPrevalueNotBetween(Integer value1, Integer value2) {
            addCriterion("prevalue not between", value1, value2, "prevalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueIsNull() {
            addCriterion("curvalue is null");
            return (Criteria) this;
        }

        public Criteria andCurvalueIsNotNull() {
            addCriterion("curvalue is not null");
            return (Criteria) this;
        }

        public Criteria andCurvalueEqualTo(Integer value) {
            addCriterion("curvalue =", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueNotEqualTo(Integer value) {
            addCriterion("curvalue <>", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueGreaterThan(Integer value) {
            addCriterion("curvalue >", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("curvalue >=", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueLessThan(Integer value) {
            addCriterion("curvalue <", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueLessThanOrEqualTo(Integer value) {
            addCriterion("curvalue <=", value, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueIn(List<Integer> values) {
            addCriterion("curvalue in", values, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueNotIn(List<Integer> values) {
            addCriterion("curvalue not in", values, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueBetween(Integer value1, Integer value2) {
            addCriterion("curvalue between", value1, value2, "curvalue");
            return (Criteria) this;
        }

        public Criteria andCurvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("curvalue not between", value1, value2, "curvalue");
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

        public Criteria andBillmoneyIsNull() {
            addCriterion("billmoney is null");
            return (Criteria) this;
        }

        public Criteria andBillmoneyIsNotNull() {
            addCriterion("billmoney is not null");
            return (Criteria) this;
        }

        public Criteria andBillmoneyEqualTo(BigDecimal value) {
            addCriterion("billmoney =", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyNotEqualTo(BigDecimal value) {
            addCriterion("billmoney <>", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyGreaterThan(BigDecimal value) {
            addCriterion("billmoney >", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("billmoney >=", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyLessThan(BigDecimal value) {
            addCriterion("billmoney <", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("billmoney <=", value, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyIn(List<BigDecimal> values) {
            addCriterion("billmoney in", values, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyNotIn(List<BigDecimal> values) {
            addCriterion("billmoney not in", values, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("billmoney between", value1, value2, "billmoney");
            return (Criteria) this;
        }

        public Criteria andBillmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("billmoney not between", value1, value2, "billmoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNull() {
            addCriterion("paymoney is null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIsNotNull() {
            addCriterion("paymoney is not null");
            return (Criteria) this;
        }

        public Criteria andPaymoneyEqualTo(BigDecimal value) {
            addCriterion("paymoney =", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotEqualTo(BigDecimal value) {
            addCriterion("paymoney <>", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThan(BigDecimal value) {
            addCriterion("paymoney >", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paymoney >=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThan(BigDecimal value) {
            addCriterion("paymoney <", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paymoney <=", value, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyIn(List<BigDecimal> values) {
            addCriterion("paymoney in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotIn(List<BigDecimal> values) {
            addCriterion("paymoney not in", values, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymoney between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymoney not between", value1, value2, "paymoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyIsNull() {
            addCriterion("usermoney is null");
            return (Criteria) this;
        }

        public Criteria andUsermoneyIsNotNull() {
            addCriterion("usermoney is not null");
            return (Criteria) this;
        }

        public Criteria andUsermoneyEqualTo(BigDecimal value) {
            addCriterion("usermoney =", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyNotEqualTo(BigDecimal value) {
            addCriterion("usermoney <>", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyGreaterThan(BigDecimal value) {
            addCriterion("usermoney >", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("usermoney >=", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyLessThan(BigDecimal value) {
            addCriterion("usermoney <", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("usermoney <=", value, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyIn(List<BigDecimal> values) {
            addCriterion("usermoney in", values, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyNotIn(List<BigDecimal> values) {
            addCriterion("usermoney not in", values, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usermoney between", value1, value2, "usermoney");
            return (Criteria) this;
        }

        public Criteria andUsermoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("usermoney not between", value1, value2, "usermoney");
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