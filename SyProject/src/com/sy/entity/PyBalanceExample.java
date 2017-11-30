package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PyBalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyBalanceExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBalancedateIsNull() {
            addCriterion("balancedate is null");
            return (Criteria) this;
        }

        public Criteria andBalancedateIsNotNull() {
            addCriterion("balancedate is not null");
            return (Criteria) this;
        }

        public Criteria andBalancedateEqualTo(Date value) {
            addCriterionForJDBCDate("balancedate =", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("balancedate <>", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateGreaterThan(Date value) {
            addCriterionForJDBCDate("balancedate >", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("balancedate >=", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateLessThan(Date value) {
            addCriterionForJDBCDate("balancedate <", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("balancedate <=", value, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateIn(List<Date> values) {
            addCriterionForJDBCDate("balancedate in", values, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("balancedate not in", values, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("balancedate between", value1, value2, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("balancedate not between", value1, value2, "balancedate");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyIsNull() {
            addCriterion("balancemoney is null");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyIsNotNull() {
            addCriterion("balancemoney is not null");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyEqualTo(BigDecimal value) {
            addCriterion("balancemoney =", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyNotEqualTo(BigDecimal value) {
            addCriterion("balancemoney <>", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyGreaterThan(BigDecimal value) {
            addCriterion("balancemoney >", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balancemoney >=", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyLessThan(BigDecimal value) {
            addCriterion("balancemoney <", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balancemoney <=", value, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyIn(List<BigDecimal> values) {
            addCriterion("balancemoney in", values, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyNotIn(List<BigDecimal> values) {
            addCriterion("balancemoney not in", values, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balancemoney between", value1, value2, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBalancemoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balancemoney not between", value1, value2, "balancemoney");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNull() {
            addCriterion("billno is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("billno is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("billno =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("billno <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("billno >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("billno >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("billno <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("billno <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("billno like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("billno not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("billno in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("billno not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("billno between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("billno not between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1IsNull() {
            addCriterion("billrealmoney1 is null");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1IsNotNull() {
            addCriterion("billrealmoney1 is not null");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1EqualTo(BigDecimal value) {
            addCriterion("billrealmoney1 =", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1NotEqualTo(BigDecimal value) {
            addCriterion("billrealmoney1 <>", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1GreaterThan(BigDecimal value) {
            addCriterion("billrealmoney1 >", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("billrealmoney1 >=", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1LessThan(BigDecimal value) {
            addCriterion("billrealmoney1 <", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("billrealmoney1 <=", value, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1In(List<BigDecimal> values) {
            addCriterion("billrealmoney1 in", values, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1NotIn(List<BigDecimal> values) {
            addCriterion("billrealmoney1 not in", values, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("billrealmoney1 between", value1, value2, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("billrealmoney1 not between", value1, value2, "billrealmoney1");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2IsNull() {
            addCriterion("billrealmoney2 is null");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2IsNotNull() {
            addCriterion("billrealmoney2 is not null");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2EqualTo(BigDecimal value) {
            addCriterion("billrealmoney2 =", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2NotEqualTo(BigDecimal value) {
            addCriterion("billrealmoney2 <>", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2GreaterThan(BigDecimal value) {
            addCriterion("billrealmoney2 >", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("billrealmoney2 >=", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2LessThan(BigDecimal value) {
            addCriterion("billrealmoney2 <", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("billrealmoney2 <=", value, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2In(List<BigDecimal> values) {
            addCriterion("billrealmoney2 in", values, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2NotIn(List<BigDecimal> values) {
            addCriterion("billrealmoney2 not in", values, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("billrealmoney2 between", value1, value2, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andBillrealmoney2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("billrealmoney2 not between", value1, value2, "billrealmoney2");
            return (Criteria) this;
        }

        public Criteria andPaynoIsNull() {
            addCriterion("payno is null");
            return (Criteria) this;
        }

        public Criteria andPaynoIsNotNull() {
            addCriterion("payno is not null");
            return (Criteria) this;
        }

        public Criteria andPaynoEqualTo(String value) {
            addCriterion("payno =", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoNotEqualTo(String value) {
            addCriterion("payno <>", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoGreaterThan(String value) {
            addCriterion("payno >", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoGreaterThanOrEqualTo(String value) {
            addCriterion("payno >=", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoLessThan(String value) {
            addCriterion("payno <", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoLessThanOrEqualTo(String value) {
            addCriterion("payno <=", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoLike(String value) {
            addCriterion("payno like", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoNotLike(String value) {
            addCriterion("payno not like", value, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoIn(List<String> values) {
            addCriterion("payno in", values, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoNotIn(List<String> values) {
            addCriterion("payno not in", values, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoBetween(String value1, String value2) {
            addCriterion("payno between", value1, value2, "payno");
            return (Criteria) this;
        }

        public Criteria andPaynoNotBetween(String value1, String value2) {
            addCriterion("payno not between", value1, value2, "payno");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1IsNull() {
            addCriterion("payusemoney1 is null");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1IsNotNull() {
            addCriterion("payusemoney1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1EqualTo(BigDecimal value) {
            addCriterion("payusemoney1 =", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1NotEqualTo(BigDecimal value) {
            addCriterion("payusemoney1 <>", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1GreaterThan(BigDecimal value) {
            addCriterion("payusemoney1 >", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payusemoney1 >=", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1LessThan(BigDecimal value) {
            addCriterion("payusemoney1 <", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("payusemoney1 <=", value, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1In(List<BigDecimal> values) {
            addCriterion("payusemoney1 in", values, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1NotIn(List<BigDecimal> values) {
            addCriterion("payusemoney1 not in", values, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("payusemoney1 between", value1, value2, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payusemoney1 not between", value1, value2, "payusemoney1");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2IsNull() {
            addCriterion("payusemoney2 is null");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2IsNotNull() {
            addCriterion("payusemoney2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2EqualTo(BigDecimal value) {
            addCriterion("payusemoney2 =", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2NotEqualTo(BigDecimal value) {
            addCriterion("payusemoney2 <>", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2GreaterThan(BigDecimal value) {
            addCriterion("payusemoney2 >", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payusemoney2 >=", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2LessThan(BigDecimal value) {
            addCriterion("payusemoney2 <", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("payusemoney2 <=", value, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2In(List<BigDecimal> values) {
            addCriterion("payusemoney2 in", values, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2NotIn(List<BigDecimal> values) {
            addCriterion("payusemoney2 not in", values, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("payusemoney2 between", value1, value2, "payusemoney2");
            return (Criteria) this;
        }

        public Criteria andPayusemoney2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payusemoney2 not between", value1, value2, "payusemoney2");
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