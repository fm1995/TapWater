package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BeOrderuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BeOrderuserExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneIsNull() {
            addCriterion("sms_phone is null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneIsNotNull() {
            addCriterion("sms_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneEqualTo(String value) {
            addCriterion("sms_phone =", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotEqualTo(String value) {
            addCriterion("sms_phone <>", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneGreaterThan(String value) {
            addCriterion("sms_phone >", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sms_phone >=", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLessThan(String value) {
            addCriterion("sms_phone <", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLessThanOrEqualTo(String value) {
            addCriterion("sms_phone <=", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLike(String value) {
            addCriterion("sms_phone like", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotLike(String value) {
            addCriterion("sms_phone not like", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneIn(List<String> values) {
            addCriterion("sms_phone in", values, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotIn(List<String> values) {
            addCriterion("sms_phone not in", values, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBetween(String value1, String value2) {
            addCriterion("sms_phone between", value1, value2, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotBetween(String value1, String value2) {
            addCriterion("sms_phone not between", value1, value2, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNull() {
            addCriterion("project_money is null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIsNotNull() {
            addCriterion("project_money is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyEqualTo(BigDecimal value) {
            addCriterion("project_money =", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotEqualTo(BigDecimal value) {
            addCriterion("project_money <>", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThan(BigDecimal value) {
            addCriterion("project_money >", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_money >=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThan(BigDecimal value) {
            addCriterion("project_money <", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_money <=", value, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyIn(List<BigDecimal> values) {
            addCriterion("project_money in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotIn(List<BigDecimal> values) {
            addCriterion("project_money not in", values, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_money between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andProjectMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_money not between", value1, value2, "projectMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNull() {
            addCriterion("real_money is null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNotNull() {
            addCriterion("real_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyEqualTo(BigDecimal value) {
            addCriterion("real_money =", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotEqualTo(BigDecimal value) {
            addCriterion("real_money <>", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThan(BigDecimal value) {
            addCriterion("real_money >", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_money >=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThan(BigDecimal value) {
            addCriterion("real_money <", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_money <=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIn(List<BigDecimal> values) {
            addCriterion("real_money in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotIn(List<BigDecimal> values) {
            addCriterion("real_money not in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_money between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_money not between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNull() {
            addCriterion("invoice_no is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("invoice_no is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(String value) {
            addCriterion("invoice_no =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(String value) {
            addCriterion("invoice_no <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(String value) {
            addCriterion("invoice_no >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_no >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(String value) {
            addCriterion("invoice_no <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(String value) {
            addCriterion("invoice_no <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLike(String value) {
            addCriterion("invoice_no like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotLike(String value) {
            addCriterion("invoice_no not like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<String> values) {
            addCriterion("invoice_no in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<String> values) {
            addCriterion("invoice_no not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(String value1, String value2) {
            addCriterion("invoice_no between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(String value1, String value2) {
            addCriterion("invoice_no not between", value1, value2, "invoiceNo");
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

        public Criteria andContractNumIsNull() {
            addCriterion("contract_num is null");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNotNull() {
            addCriterion("contract_num is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumEqualTo(String value) {
            addCriterion("contract_num =", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotEqualTo(String value) {
            addCriterion("contract_num <>", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThan(String value) {
            addCriterion("contract_num >", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThanOrEqualTo(String value) {
            addCriterion("contract_num >=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThan(String value) {
            addCriterion("contract_num <", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThanOrEqualTo(String value) {
            addCriterion("contract_num <=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLike(String value) {
            addCriterion("contract_num like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotLike(String value) {
            addCriterion("contract_num not like", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumIn(List<String> values) {
            addCriterion("contract_num in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotIn(List<String> values) {
            addCriterion("contract_num not in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumBetween(String value1, String value2) {
            addCriterion("contract_num between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotBetween(String value1, String value2) {
            addCriterion("contract_num not between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdIsNull() {
            addCriterion("meter_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdIsNotNull() {
            addCriterion("meter_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdEqualTo(Integer value) {
            addCriterion("meter_type_id =", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdNotEqualTo(Integer value) {
            addCriterion("meter_type_id <>", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdGreaterThan(Integer value) {
            addCriterion("meter_type_id >", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("meter_type_id >=", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdLessThan(Integer value) {
            addCriterion("meter_type_id <", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("meter_type_id <=", value, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdIn(List<Integer> values) {
            addCriterion("meter_type_id in", values, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdNotIn(List<Integer> values) {
            addCriterion("meter_type_id not in", values, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("meter_type_id between", value1, value2, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("meter_type_id not between", value1, value2, "meterTypeId");
            return (Criteria) this;
        }

        public Criteria andMeterNameIsNull() {
            addCriterion("meter_name is null");
            return (Criteria) this;
        }

        public Criteria andMeterNameIsNotNull() {
            addCriterion("meter_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeterNameEqualTo(String value) {
            addCriterion("meter_name =", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameNotEqualTo(String value) {
            addCriterion("meter_name <>", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameGreaterThan(String value) {
            addCriterion("meter_name >", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameGreaterThanOrEqualTo(String value) {
            addCriterion("meter_name >=", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameLessThan(String value) {
            addCriterion("meter_name <", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameLessThanOrEqualTo(String value) {
            addCriterion("meter_name <=", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameLike(String value) {
            addCriterion("meter_name like", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameNotLike(String value) {
            addCriterion("meter_name not like", value, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameIn(List<String> values) {
            addCriterion("meter_name in", values, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameNotIn(List<String> values) {
            addCriterion("meter_name not in", values, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameBetween(String value1, String value2) {
            addCriterion("meter_name between", value1, value2, "meterName");
            return (Criteria) this;
        }

        public Criteria andMeterNameNotBetween(String value1, String value2) {
            addCriterion("meter_name not between", value1, value2, "meterName");
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

        public Criteria andStartValueIsNull() {
            addCriterion("start_value is null");
            return (Criteria) this;
        }

        public Criteria andStartValueIsNotNull() {
            addCriterion("start_value is not null");
            return (Criteria) this;
        }

        public Criteria andStartValueEqualTo(Integer value) {
            addCriterion("start_value =", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotEqualTo(Integer value) {
            addCriterion("start_value <>", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueGreaterThan(Integer value) {
            addCriterion("start_value >", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_value >=", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueLessThan(Integer value) {
            addCriterion("start_value <", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueLessThanOrEqualTo(Integer value) {
            addCriterion("start_value <=", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueIn(List<Integer> values) {
            addCriterion("start_value in", values, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotIn(List<Integer> values) {
            addCriterion("start_value not in", values, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueBetween(Integer value1, Integer value2) {
            addCriterion("start_value between", value1, value2, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotBetween(Integer value1, Integer value2) {
            addCriterion("start_value not between", value1, value2, "startValue");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryIsNull() {
            addCriterion("meter_factory is null");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryIsNotNull() {
            addCriterion("meter_factory is not null");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryEqualTo(String value) {
            addCriterion("meter_factory =", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryNotEqualTo(String value) {
            addCriterion("meter_factory <>", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryGreaterThan(String value) {
            addCriterion("meter_factory >", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("meter_factory >=", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryLessThan(String value) {
            addCriterion("meter_factory <", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryLessThanOrEqualTo(String value) {
            addCriterion("meter_factory <=", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryLike(String value) {
            addCriterion("meter_factory like", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryNotLike(String value) {
            addCriterion("meter_factory not like", value, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryIn(List<String> values) {
            addCriterion("meter_factory in", values, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryNotIn(List<String> values) {
            addCriterion("meter_factory not in", values, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryBetween(String value1, String value2) {
            addCriterion("meter_factory between", value1, value2, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andMeterFactoryNotBetween(String value1, String value2) {
            addCriterion("meter_factory not between", value1, value2, "meterFactory");
            return (Criteria) this;
        }

        public Criteria andDocNumIsNull() {
            addCriterion("doc_num is null");
            return (Criteria) this;
        }

        public Criteria andDocNumIsNotNull() {
            addCriterion("doc_num is not null");
            return (Criteria) this;
        }

        public Criteria andDocNumEqualTo(String value) {
            addCriterion("doc_num =", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotEqualTo(String value) {
            addCriterion("doc_num <>", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumGreaterThan(String value) {
            addCriterion("doc_num >", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumGreaterThanOrEqualTo(String value) {
            addCriterion("doc_num >=", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLessThan(String value) {
            addCriterion("doc_num <", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLessThanOrEqualTo(String value) {
            addCriterion("doc_num <=", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumLike(String value) {
            addCriterion("doc_num like", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotLike(String value) {
            addCriterion("doc_num not like", value, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumIn(List<String> values) {
            addCriterion("doc_num in", values, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotIn(List<String> values) {
            addCriterion("doc_num not in", values, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumBetween(String value1, String value2) {
            addCriterion("doc_num between", value1, value2, "docNum");
            return (Criteria) this;
        }

        public Criteria andDocNumNotBetween(String value1, String value2) {
            addCriterion("doc_num not between", value1, value2, "docNum");
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