package com.sy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BeOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BeOrderExample() {
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(Integer value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(Integer value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(Integer value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(Integer value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<Integer> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<Integer> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(Integer value1, Integer value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNull() {
            addCriterion("create_emp is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNotNull() {
            addCriterion("create_emp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpEqualTo(Integer value) {
            addCriterion("create_emp =", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotEqualTo(Integer value) {
            addCriterion("create_emp <>", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThan(Integer value) {
            addCriterion("create_emp >", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_emp >=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThan(Integer value) {
            addCriterion("create_emp <", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThanOrEqualTo(Integer value) {
            addCriterion("create_emp <=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIn(List<Integer> values) {
            addCriterion("create_emp in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotIn(List<Integer> values) {
            addCriterion("create_emp not in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpBetween(Integer value1, Integer value2) {
            addCriterion("create_emp between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotBetween(Integer value1, Integer value2) {
            addCriterion("create_emp not between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpIsNull() {
            addCriterion("complete_emp is null");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpIsNotNull() {
            addCriterion("complete_emp is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpEqualTo(Integer value) {
            addCriterion("complete_emp =", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpNotEqualTo(Integer value) {
            addCriterion("complete_emp <>", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpGreaterThan(Integer value) {
            addCriterion("complete_emp >", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpGreaterThanOrEqualTo(Integer value) {
            addCriterion("complete_emp >=", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpLessThan(Integer value) {
            addCriterion("complete_emp <", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpLessThanOrEqualTo(Integer value) {
            addCriterion("complete_emp <=", value, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpIn(List<Integer> values) {
            addCriterion("complete_emp in", values, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpNotIn(List<Integer> values) {
            addCriterion("complete_emp not in", values, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpBetween(Integer value1, Integer value2) {
            addCriterion("complete_emp between", value1, value2, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteEmpNotBetween(Integer value1, Integer value2) {
            addCriterion("complete_emp not between", value1, value2, "completeEmp");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNull() {
            addCriterion("complete_date is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNotNull() {
            addCriterion("complete_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateEqualTo(Date value) {
            addCriterion("complete_date =", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotEqualTo(Date value) {
            addCriterion("complete_date <>", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThan(Date value) {
            addCriterion("complete_date >", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_date >=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThan(Date value) {
            addCriterion("complete_date <", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThanOrEqualTo(Date value) {
            addCriterion("complete_date <=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIn(List<Date> values) {
            addCriterion("complete_date in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotIn(List<Date> values) {
            addCriterion("complete_date not in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateBetween(Date value1, Date value2) {
            addCriterion("complete_date between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotBetween(Date value1, Date value2) {
            addCriterion("complete_date not between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpIsNull() {
            addCriterion("lastEdit_emp is null");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpIsNotNull() {
            addCriterion("lastEdit_emp is not null");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpEqualTo(Integer value) {
            addCriterion("lastEdit_emp =", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpNotEqualTo(Integer value) {
            addCriterion("lastEdit_emp <>", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpGreaterThan(Integer value) {
            addCriterion("lastEdit_emp >", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastEdit_emp >=", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpLessThan(Integer value) {
            addCriterion("lastEdit_emp <", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpLessThanOrEqualTo(Integer value) {
            addCriterion("lastEdit_emp <=", value, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpIn(List<Integer> values) {
            addCriterion("lastEdit_emp in", values, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpNotIn(List<Integer> values) {
            addCriterion("lastEdit_emp not in", values, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpBetween(Integer value1, Integer value2) {
            addCriterion("lastEdit_emp between", value1, value2, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditEmpNotBetween(Integer value1, Integer value2) {
            addCriterion("lastEdit_emp not between", value1, value2, "lasteditEmp");
            return (Criteria) this;
        }

        public Criteria andLasteditDateIsNull() {
            addCriterion("lastEdit_date is null");
            return (Criteria) this;
        }

        public Criteria andLasteditDateIsNotNull() {
            addCriterion("lastEdit_date is not null");
            return (Criteria) this;
        }

        public Criteria andLasteditDateEqualTo(Date value) {
            addCriterion("lastEdit_date =", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateNotEqualTo(Date value) {
            addCriterion("lastEdit_date <>", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateGreaterThan(Date value) {
            addCriterion("lastEdit_date >", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastEdit_date >=", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateLessThan(Date value) {
            addCriterion("lastEdit_date <", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateLessThanOrEqualTo(Date value) {
            addCriterion("lastEdit_date <=", value, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateIn(List<Date> values) {
            addCriterion("lastEdit_date in", values, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateNotIn(List<Date> values) {
            addCriterion("lastEdit_date not in", values, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateBetween(Date value1, Date value2) {
            addCriterion("lastEdit_date between", value1, value2, "lasteditDate");
            return (Criteria) this;
        }

        public Criteria andLasteditDateNotBetween(Date value1, Date value2) {
            addCriterion("lastEdit_date not between", value1, value2, "lasteditDate");
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

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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

        public Criteria andLinkManIsNull() {
            addCriterion("link_man is null");
            return (Criteria) this;
        }

        public Criteria andLinkManIsNotNull() {
            addCriterion("link_man is not null");
            return (Criteria) this;
        }

        public Criteria andLinkManEqualTo(String value) {
            addCriterion("link_man =", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotEqualTo(String value) {
            addCriterion("link_man <>", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThan(String value) {
            addCriterion("link_man >", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("link_man >=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThan(String value) {
            addCriterion("link_man <", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThanOrEqualTo(String value) {
            addCriterion("link_man <=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLike(String value) {
            addCriterion("link_man like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotLike(String value) {
            addCriterion("link_man not like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManIn(List<String> values) {
            addCriterion("link_man in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotIn(List<String> values) {
            addCriterion("link_man not in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManBetween(String value1, String value2) {
            addCriterion("link_man between", value1, value2, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotBetween(String value1, String value2) {
            addCriterion("link_man not between", value1, value2, "linkMan");
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

        public Criteria andUseTargetIsNull() {
            addCriterion("use_target is null");
            return (Criteria) this;
        }

        public Criteria andUseTargetIsNotNull() {
            addCriterion("use_target is not null");
            return (Criteria) this;
        }

        public Criteria andUseTargetEqualTo(String value) {
            addCriterion("use_target =", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetNotEqualTo(String value) {
            addCriterion("use_target <>", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetGreaterThan(String value) {
            addCriterion("use_target >", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetGreaterThanOrEqualTo(String value) {
            addCriterion("use_target >=", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetLessThan(String value) {
            addCriterion("use_target <", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetLessThanOrEqualTo(String value) {
            addCriterion("use_target <=", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetLike(String value) {
            addCriterion("use_target like", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetNotLike(String value) {
            addCriterion("use_target not like", value, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetIn(List<String> values) {
            addCriterion("use_target in", values, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetNotIn(List<String> values) {
            addCriterion("use_target not in", values, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetBetween(String value1, String value2) {
            addCriterion("use_target between", value1, value2, "useTarget");
            return (Criteria) this;
        }

        public Criteria andUseTargetNotBetween(String value1, String value2) {
            addCriterion("use_target not between", value1, value2, "useTarget");
            return (Criteria) this;
        }

        public Criteria andHouseHeightIsNull() {
            addCriterion("house_height is null");
            return (Criteria) this;
        }

        public Criteria andHouseHeightIsNotNull() {
            addCriterion("house_height is not null");
            return (Criteria) this;
        }

        public Criteria andHouseHeightEqualTo(Integer value) {
            addCriterion("house_height =", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightNotEqualTo(Integer value) {
            addCriterion("house_height <>", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightGreaterThan(Integer value) {
            addCriterion("house_height >", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_height >=", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightLessThan(Integer value) {
            addCriterion("house_height <", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightLessThanOrEqualTo(Integer value) {
            addCriterion("house_height <=", value, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightIn(List<Integer> values) {
            addCriterion("house_height in", values, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightNotIn(List<Integer> values) {
            addCriterion("house_height not in", values, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightBetween(Integer value1, Integer value2) {
            addCriterion("house_height between", value1, value2, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andHouseHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("house_height not between", value1, value2, "houseHeight");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNull() {
            addCriterion("max_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEqualTo(Integer value) {
            addCriterion("max_amount =", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotEqualTo(Integer value) {
            addCriterion("max_amount <>", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThan(Integer value) {
            addCriterion("max_amount >", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_amount >=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThan(Integer value) {
            addCriterion("max_amount <", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThanOrEqualTo(Integer value) {
            addCriterion("max_amount <=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIn(List<Integer> values) {
            addCriterion("max_amount in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotIn(List<Integer> values) {
            addCriterion("max_amount not in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountBetween(Integer value1, Integer value2) {
            addCriterion("max_amount between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_amount not between", value1, value2, "maxAmount");
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

        public Criteria andMeterCountIsNull() {
            addCriterion("meter_count is null");
            return (Criteria) this;
        }

        public Criteria andMeterCountIsNotNull() {
            addCriterion("meter_count is not null");
            return (Criteria) this;
        }

        public Criteria andMeterCountEqualTo(Integer value) {
            addCriterion("meter_count =", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountNotEqualTo(Integer value) {
            addCriterion("meter_count <>", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountGreaterThan(Integer value) {
            addCriterion("meter_count >", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("meter_count >=", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountLessThan(Integer value) {
            addCriterion("meter_count <", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountLessThanOrEqualTo(Integer value) {
            addCriterion("meter_count <=", value, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountIn(List<Integer> values) {
            addCriterion("meter_count in", values, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountNotIn(List<Integer> values) {
            addCriterion("meter_count not in", values, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountBetween(Integer value1, Integer value2) {
            addCriterion("meter_count between", value1, value2, "meterCount");
            return (Criteria) this;
        }

        public Criteria andMeterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("meter_count not between", value1, value2, "meterCount");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIsNull() {
            addCriterion("user_remark is null");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIsNotNull() {
            addCriterion("user_remark is not null");
            return (Criteria) this;
        }

        public Criteria andUserRemarkEqualTo(String value) {
            addCriterion("user_remark =", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotEqualTo(String value) {
            addCriterion("user_remark <>", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkGreaterThan(String value) {
            addCriterion("user_remark >", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("user_remark >=", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLessThan(String value) {
            addCriterion("user_remark <", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLessThanOrEqualTo(String value) {
            addCriterion("user_remark <=", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkLike(String value) {
            addCriterion("user_remark like", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotLike(String value) {
            addCriterion("user_remark not like", value, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkIn(List<String> values) {
            addCriterion("user_remark in", values, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotIn(List<String> values) {
            addCriterion("user_remark not in", values, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkBetween(String value1, String value2) {
            addCriterion("user_remark between", value1, value2, "userRemark");
            return (Criteria) this;
        }

        public Criteria andUserRemarkNotBetween(String value1, String value2) {
            addCriterion("user_remark not between", value1, value2, "userRemark");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andBankCompanyIsNull() {
            addCriterion("bank_company is null");
            return (Criteria) this;
        }

        public Criteria andBankCompanyIsNotNull() {
            addCriterion("bank_company is not null");
            return (Criteria) this;
        }

        public Criteria andBankCompanyEqualTo(String value) {
            addCriterion("bank_company =", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyNotEqualTo(String value) {
            addCriterion("bank_company <>", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyGreaterThan(String value) {
            addCriterion("bank_company >", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("bank_company >=", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyLessThan(String value) {
            addCriterion("bank_company <", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyLessThanOrEqualTo(String value) {
            addCriterion("bank_company <=", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyLike(String value) {
            addCriterion("bank_company like", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyNotLike(String value) {
            addCriterion("bank_company not like", value, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyIn(List<String> values) {
            addCriterion("bank_company in", values, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyNotIn(List<String> values) {
            addCriterion("bank_company not in", values, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyBetween(String value1, String value2) {
            addCriterion("bank_company between", value1, value2, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankCompanyNotBetween(String value1, String value2) {
            addCriterion("bank_company not between", value1, value2, "bankCompany");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNull() {
            addCriterion("bank_num is null");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNotNull() {
            addCriterion("bank_num is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumEqualTo(String value) {
            addCriterion("bank_num =", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotEqualTo(String value) {
            addCriterion("bank_num <>", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThan(String value) {
            addCriterion("bank_num >", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThanOrEqualTo(String value) {
            addCriterion("bank_num >=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThan(String value) {
            addCriterion("bank_num <", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThanOrEqualTo(String value) {
            addCriterion("bank_num <=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLike(String value) {
            addCriterion("bank_num like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotLike(String value) {
            addCriterion("bank_num not like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumIn(List<String> values) {
            addCriterion("bank_num in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotIn(List<String> values) {
            addCriterion("bank_num not in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumBetween(String value1, String value2) {
            addCriterion("bank_num between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotBetween(String value1, String value2) {
            addCriterion("bank_num not between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andOldUserNoIsNull() {
            addCriterion("old_user_no is null");
            return (Criteria) this;
        }

        public Criteria andOldUserNoIsNotNull() {
            addCriterion("old_user_no is not null");
            return (Criteria) this;
        }

        public Criteria andOldUserNoEqualTo(String value) {
            addCriterion("old_user_no =", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoNotEqualTo(String value) {
            addCriterion("old_user_no <>", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoGreaterThan(String value) {
            addCriterion("old_user_no >", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("old_user_no >=", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoLessThan(String value) {
            addCriterion("old_user_no <", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoLessThanOrEqualTo(String value) {
            addCriterion("old_user_no <=", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoLike(String value) {
            addCriterion("old_user_no like", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoNotLike(String value) {
            addCriterion("old_user_no not like", value, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoIn(List<String> values) {
            addCriterion("old_user_no in", values, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoNotIn(List<String> values) {
            addCriterion("old_user_no not in", values, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoBetween(String value1, String value2) {
            addCriterion("old_user_no between", value1, value2, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNoNotBetween(String value1, String value2) {
            addCriterion("old_user_no not between", value1, value2, "oldUserNo");
            return (Criteria) this;
        }

        public Criteria andOldUserNameIsNull() {
            addCriterion("old_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOldUserNameIsNotNull() {
            addCriterion("old_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOldUserNameEqualTo(String value) {
            addCriterion("old_user_name =", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameNotEqualTo(String value) {
            addCriterion("old_user_name <>", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameGreaterThan(String value) {
            addCriterion("old_user_name >", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("old_user_name >=", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameLessThan(String value) {
            addCriterion("old_user_name <", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameLessThanOrEqualTo(String value) {
            addCriterion("old_user_name <=", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameLike(String value) {
            addCriterion("old_user_name like", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameNotLike(String value) {
            addCriterion("old_user_name not like", value, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameIn(List<String> values) {
            addCriterion("old_user_name in", values, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameNotIn(List<String> values) {
            addCriterion("old_user_name not in", values, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameBetween(String value1, String value2) {
            addCriterion("old_user_name between", value1, value2, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserNameNotBetween(String value1, String value2) {
            addCriterion("old_user_name not between", value1, value2, "oldUserName");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneIsNull() {
            addCriterion("old_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneIsNotNull() {
            addCriterion("old_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneEqualTo(String value) {
            addCriterion("old_user_phone =", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneNotEqualTo(String value) {
            addCriterion("old_user_phone <>", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneGreaterThan(String value) {
            addCriterion("old_user_phone >", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("old_user_phone >=", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneLessThan(String value) {
            addCriterion("old_user_phone <", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("old_user_phone <=", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneLike(String value) {
            addCriterion("old_user_phone like", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneNotLike(String value) {
            addCriterion("old_user_phone not like", value, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneIn(List<String> values) {
            addCriterion("old_user_phone in", values, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneNotIn(List<String> values) {
            addCriterion("old_user_phone not in", values, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneBetween(String value1, String value2) {
            addCriterion("old_user_phone between", value1, value2, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserPhoneNotBetween(String value1, String value2) {
            addCriterion("old_user_phone not between", value1, value2, "oldUserPhone");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrIsNull() {
            addCriterion("old_user_addr is null");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrIsNotNull() {
            addCriterion("old_user_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrEqualTo(String value) {
            addCriterion("old_user_addr =", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrNotEqualTo(String value) {
            addCriterion("old_user_addr <>", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrGreaterThan(String value) {
            addCriterion("old_user_addr >", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrGreaterThanOrEqualTo(String value) {
            addCriterion("old_user_addr >=", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrLessThan(String value) {
            addCriterion("old_user_addr <", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrLessThanOrEqualTo(String value) {
            addCriterion("old_user_addr <=", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrLike(String value) {
            addCriterion("old_user_addr like", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrNotLike(String value) {
            addCriterion("old_user_addr not like", value, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrIn(List<String> values) {
            addCriterion("old_user_addr in", values, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrNotIn(List<String> values) {
            addCriterion("old_user_addr not in", values, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrBetween(String value1, String value2) {
            addCriterion("old_user_addr between", value1, value2, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldUserAddrNotBetween(String value1, String value2) {
            addCriterion("old_user_addr not between", value1, value2, "oldUserAddr");
            return (Criteria) this;
        }

        public Criteria andOldMeterIsNull() {
            addCriterion("old_meter is null");
            return (Criteria) this;
        }

        public Criteria andOldMeterIsNotNull() {
            addCriterion("old_meter is not null");
            return (Criteria) this;
        }

        public Criteria andOldMeterEqualTo(String value) {
            addCriterion("old_meter =", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterNotEqualTo(String value) {
            addCriterion("old_meter <>", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterGreaterThan(String value) {
            addCriterion("old_meter >", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterGreaterThanOrEqualTo(String value) {
            addCriterion("old_meter >=", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterLessThan(String value) {
            addCriterion("old_meter <", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterLessThanOrEqualTo(String value) {
            addCriterion("old_meter <=", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterLike(String value) {
            addCriterion("old_meter like", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterNotLike(String value) {
            addCriterion("old_meter not like", value, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterIn(List<String> values) {
            addCriterion("old_meter in", values, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterNotIn(List<String> values) {
            addCriterion("old_meter not in", values, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterBetween(String value1, String value2) {
            addCriterion("old_meter between", value1, value2, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andOldMeterNotBetween(String value1, String value2) {
            addCriterion("old_meter not between", value1, value2, "oldMeter");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIsNull() {
            addCriterion("audit_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIsNotNull() {
            addCriterion("audit_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdEqualTo(Integer value) {
            addCriterion("audit_emp_id =", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotEqualTo(Integer value) {
            addCriterion("audit_emp_id <>", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdGreaterThan(Integer value) {
            addCriterion("audit_emp_id >", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_emp_id >=", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdLessThan(Integer value) {
            addCriterion("audit_emp_id <", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("audit_emp_id <=", value, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdIn(List<Integer> values) {
            addCriterion("audit_emp_id in", values, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotIn(List<Integer> values) {
            addCriterion("audit_emp_id not in", values, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("audit_emp_id between", value1, value2, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_emp_id not between", value1, value2, "auditEmpId");
            return (Criteria) this;
        }

        public Criteria andAuditMessageIsNull() {
            addCriterion("audit_message is null");
            return (Criteria) this;
        }

        public Criteria andAuditMessageIsNotNull() {
            addCriterion("audit_message is not null");
            return (Criteria) this;
        }

        public Criteria andAuditMessageEqualTo(String value) {
            addCriterion("audit_message =", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageNotEqualTo(String value) {
            addCriterion("audit_message <>", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageGreaterThan(String value) {
            addCriterion("audit_message >", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageGreaterThanOrEqualTo(String value) {
            addCriterion("audit_message >=", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageLessThan(String value) {
            addCriterion("audit_message <", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageLessThanOrEqualTo(String value) {
            addCriterion("audit_message <=", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageLike(String value) {
            addCriterion("audit_message like", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageNotLike(String value) {
            addCriterion("audit_message not like", value, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageIn(List<String> values) {
            addCriterion("audit_message in", values, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageNotIn(List<String> values) {
            addCriterion("audit_message not in", values, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageBetween(String value1, String value2) {
            addCriterion("audit_message between", value1, value2, "auditMessage");
            return (Criteria) this;
        }

        public Criteria andAuditMessageNotBetween(String value1, String value2) {
            addCriterion("audit_message not between", value1, value2, "auditMessage");
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

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andProjectDate1IsNull() {
            addCriterion("project_date1 is null");
            return (Criteria) this;
        }

        public Criteria andProjectDate1IsNotNull() {
            addCriterion("project_date1 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDate1EqualTo(Date value) {
            addCriterion("project_date1 =", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1NotEqualTo(Date value) {
            addCriterion("project_date1 <>", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1GreaterThan(Date value) {
            addCriterion("project_date1 >", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1GreaterThanOrEqualTo(Date value) {
            addCriterion("project_date1 >=", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1LessThan(Date value) {
            addCriterion("project_date1 <", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1LessThanOrEqualTo(Date value) {
            addCriterion("project_date1 <=", value, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1In(List<Date> values) {
            addCriterion("project_date1 in", values, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1NotIn(List<Date> values) {
            addCriterion("project_date1 not in", values, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1Between(Date value1, Date value2) {
            addCriterion("project_date1 between", value1, value2, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate1NotBetween(Date value1, Date value2) {
            addCriterion("project_date1 not between", value1, value2, "projectDate1");
            return (Criteria) this;
        }

        public Criteria andProjectDate2IsNull() {
            addCriterion("project_date2 is null");
            return (Criteria) this;
        }

        public Criteria andProjectDate2IsNotNull() {
            addCriterion("project_date2 is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDate2EqualTo(Date value) {
            addCriterion("project_date2 =", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2NotEqualTo(Date value) {
            addCriterion("project_date2 <>", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2GreaterThan(Date value) {
            addCriterion("project_date2 >", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2GreaterThanOrEqualTo(Date value) {
            addCriterion("project_date2 >=", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2LessThan(Date value) {
            addCriterion("project_date2 <", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2LessThanOrEqualTo(Date value) {
            addCriterion("project_date2 <=", value, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2In(List<Date> values) {
            addCriterion("project_date2 in", values, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2NotIn(List<Date> values) {
            addCriterion("project_date2 not in", values, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2Between(Date value1, Date value2) {
            addCriterion("project_date2 between", value1, value2, "projectDate2");
            return (Criteria) this;
        }

        public Criteria andProjectDate2NotBetween(Date value1, Date value2) {
            addCriterion("project_date2 not between", value1, value2, "projectDate2");
            return (Criteria) this;
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

        public Criteria andAbortCauseIsNull() {
            addCriterion("abort_cause is null");
            return (Criteria) this;
        }

        public Criteria andAbortCauseIsNotNull() {
            addCriterion("abort_cause is not null");
            return (Criteria) this;
        }

        public Criteria andAbortCauseEqualTo(String value) {
            addCriterion("abort_cause =", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseNotEqualTo(String value) {
            addCriterion("abort_cause <>", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseGreaterThan(String value) {
            addCriterion("abort_cause >", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseGreaterThanOrEqualTo(String value) {
            addCriterion("abort_cause >=", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseLessThan(String value) {
            addCriterion("abort_cause <", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseLessThanOrEqualTo(String value) {
            addCriterion("abort_cause <=", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseLike(String value) {
            addCriterion("abort_cause like", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseNotLike(String value) {
            addCriterion("abort_cause not like", value, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseIn(List<String> values) {
            addCriterion("abort_cause in", values, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseNotIn(List<String> values) {
            addCriterion("abort_cause not in", values, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseBetween(String value1, String value2) {
            addCriterion("abort_cause between", value1, value2, "abortCause");
            return (Criteria) this;
        }

        public Criteria andAbortCauseNotBetween(String value1, String value2) {
            addCriterion("abort_cause not between", value1, value2, "abortCause");
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