package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PyBalancedetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyBalancedetailExample() {
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andBalanceDateIsNull() {
            addCriterion("balance_date is null");
            return (Criteria) this;
        }

        public Criteria andBalanceDateIsNotNull() {
            addCriterion("balance_date is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceDateEqualTo(Date value) {
            addCriterion("balance_date =", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateNotEqualTo(Date value) {
            addCriterion("balance_date <>", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateGreaterThan(Date value) {
            addCriterion("balance_date >", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateGreaterThanOrEqualTo(Date value) {
            addCriterion("balance_date >=", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateLessThan(Date value) {
            addCriterion("balance_date <", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateLessThanOrEqualTo(Date value) {
            addCriterion("balance_date <=", value, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateIn(List<Date> values) {
            addCriterion("balance_date in", values, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateNotIn(List<Date> values) {
            addCriterion("balance_date not in", values, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateBetween(Date value1, Date value2) {
            addCriterion("balance_date between", value1, value2, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceDateNotBetween(Date value1, Date value2) {
            addCriterion("balance_date not between", value1, value2, "balanceDate");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyIsNull() {
            addCriterion("balance_money is null");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyIsNotNull() {
            addCriterion("balance_money is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyEqualTo(BigDecimal value) {
            addCriterion("balance_money =", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("balance_money <>", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyGreaterThan(BigDecimal value) {
            addCriterion("balance_money >", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_money >=", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyLessThan(BigDecimal value) {
            addCriterion("balance_money <", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_money <=", value, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyIn(List<BigDecimal> values) {
            addCriterion("balance_money in", values, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("balance_money not in", values, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_money between", value1, value2, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBalanceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_money not between", value1, value2, "balanceMoney");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("bill_no is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("bill_no =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("bill_no <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("bill_no >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("bill_no >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("bill_no <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("bill_no <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("bill_no like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("bill_no not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("bill_no in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("bill_no not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("bill_no between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("bill_no not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIsNull() {
            addCriterion("bill_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIsNotNull() {
            addCriterion("bill_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdEqualTo(Integer value) {
            addCriterion("bill_detail_id =", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotEqualTo(Integer value) {
            addCriterion("bill_detail_id <>", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThan(Integer value) {
            addCriterion("bill_detail_id >", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_detail_id >=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThan(Integer value) {
            addCriterion("bill_detail_id <", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("bill_detail_id <=", value, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdIn(List<Integer> values) {
            addCriterion("bill_detail_id in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotIn(List<Integer> values) {
            addCriterion("bill_detail_id not in", values, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("bill_detail_id between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andBillDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_detail_id not between", value1, value2, "billDetailId");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeIsNull() {
            addCriterion("cost_type_code is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeIsNotNull() {
            addCriterion("cost_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeEqualTo(String value) {
            addCriterion("cost_type_code =", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeNotEqualTo(String value) {
            addCriterion("cost_type_code <>", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeGreaterThan(String value) {
            addCriterion("cost_type_code >", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cost_type_code >=", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeLessThan(String value) {
            addCriterion("cost_type_code <", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("cost_type_code <=", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeLike(String value) {
            addCriterion("cost_type_code like", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeNotLike(String value) {
            addCriterion("cost_type_code not like", value, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeIn(List<String> values) {
            addCriterion("cost_type_code in", values, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeNotIn(List<String> values) {
            addCriterion("cost_type_code not in", values, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeBetween(String value1, String value2) {
            addCriterion("cost_type_code between", value1, value2, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andCostTypeCodeNotBetween(String value1, String value2) {
            addCriterion("cost_type_code not between", value1, value2, "costTypeCode");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1IsNull() {
            addCriterion("detail_real_money1 is null");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1IsNotNull() {
            addCriterion("detail_real_money1 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1EqualTo(BigDecimal value) {
            addCriterion("detail_real_money1 =", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1NotEqualTo(BigDecimal value) {
            addCriterion("detail_real_money1 <>", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1GreaterThan(BigDecimal value) {
            addCriterion("detail_real_money1 >", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_real_money1 >=", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1LessThan(BigDecimal value) {
            addCriterion("detail_real_money1 <", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_real_money1 <=", value, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1In(List<BigDecimal> values) {
            addCriterion("detail_real_money1 in", values, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1NotIn(List<BigDecimal> values) {
            addCriterion("detail_real_money1 not in", values, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_real_money1 between", value1, value2, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_real_money1 not between", value1, value2, "detailRealMoney1");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2IsNull() {
            addCriterion("detail_real_money2 is null");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2IsNotNull() {
            addCriterion("detail_real_money2 is not null");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2EqualTo(BigDecimal value) {
            addCriterion("detail_real_money2 =", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2NotEqualTo(BigDecimal value) {
            addCriterion("detail_real_money2 <>", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2GreaterThan(BigDecimal value) {
            addCriterion("detail_real_money2 >", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_real_money2 >=", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2LessThan(BigDecimal value) {
            addCriterion("detail_real_money2 <", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_real_money2 <=", value, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2In(List<BigDecimal> values) {
            addCriterion("detail_real_money2 in", values, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2NotIn(List<BigDecimal> values) {
            addCriterion("detail_real_money2 not in", values, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_real_money2 between", value1, value2, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andDetailRealMoney2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_real_money2 not between", value1, value2, "detailRealMoney2");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("pay_no is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("pay_no =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("pay_no <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("pay_no >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_no >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("pay_no <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("pay_no <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("pay_no like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("pay_no not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("pay_no in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("pay_no not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("pay_no between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("pay_no not between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1IsNull() {
            addCriterion("pay_use_money1 is null");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1IsNotNull() {
            addCriterion("pay_use_money1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1EqualTo(BigDecimal value) {
            addCriterion("pay_use_money1 =", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1NotEqualTo(BigDecimal value) {
            addCriterion("pay_use_money1 <>", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1GreaterThan(BigDecimal value) {
            addCriterion("pay_use_money1 >", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_use_money1 >=", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1LessThan(BigDecimal value) {
            addCriterion("pay_use_money1 <", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_use_money1 <=", value, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1In(List<BigDecimal> values) {
            addCriterion("pay_use_money1 in", values, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1NotIn(List<BigDecimal> values) {
            addCriterion("pay_use_money1 not in", values, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_use_money1 between", value1, value2, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_use_money1 not between", value1, value2, "payUseMoney1");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2IsNull() {
            addCriterion("pay_use_money2 is null");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2IsNotNull() {
            addCriterion("pay_use_money2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2EqualTo(BigDecimal value) {
            addCriterion("pay_use_money2 =", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2NotEqualTo(BigDecimal value) {
            addCriterion("pay_use_money2 <>", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2GreaterThan(BigDecimal value) {
            addCriterion("pay_use_money2 >", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_use_money2 >=", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2LessThan(BigDecimal value) {
            addCriterion("pay_use_money2 <", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_use_money2 <=", value, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2In(List<BigDecimal> values) {
            addCriterion("pay_use_money2 in", values, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2NotIn(List<BigDecimal> values) {
            addCriterion("pay_use_money2 not in", values, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_use_money2 between", value1, value2, "payUseMoney2");
            return (Criteria) this;
        }

        public Criteria andPayUseMoney2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_use_money2 not between", value1, value2, "payUseMoney2");
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