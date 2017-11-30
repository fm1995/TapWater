package com.sy.entity;

import java.util.ArrayList;
import java.util.List;

public class SyEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyEmpExample() {
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

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNoIsNull() {
            addCriterion("emp_no is null");
            return (Criteria) this;
        }

        public Criteria andEmpNoIsNotNull() {
            addCriterion("emp_no is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNoEqualTo(String value) {
            addCriterion("emp_no =", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotEqualTo(String value) {
            addCriterion("emp_no <>", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoGreaterThan(String value) {
            addCriterion("emp_no >", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoGreaterThanOrEqualTo(String value) {
            addCriterion("emp_no >=", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLessThan(String value) {
            addCriterion("emp_no <", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLessThanOrEqualTo(String value) {
            addCriterion("emp_no <=", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoLike(String value) {
            addCriterion("emp_no like", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotLike(String value) {
            addCriterion("emp_no not like", value, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoIn(List<String> values) {
            addCriterion("emp_no in", values, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotIn(List<String> values) {
            addCriterion("emp_no not in", values, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoBetween(String value1, String value2) {
            addCriterion("emp_no between", value1, value2, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpNoNotBetween(String value1, String value2) {
            addCriterion("emp_no not between", value1, value2, "empNo");
            return (Criteria) this;
        }

        public Criteria andEmpPwdIsNull() {
            addCriterion("emp_pwd is null");
            return (Criteria) this;
        }

        public Criteria andEmpPwdIsNotNull() {
            addCriterion("emp_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPwdEqualTo(String value) {
            addCriterion("emp_pwd =", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdNotEqualTo(String value) {
            addCriterion("emp_pwd <>", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdGreaterThan(String value) {
            addCriterion("emp_pwd >", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdGreaterThanOrEqualTo(String value) {
            addCriterion("emp_pwd >=", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdLessThan(String value) {
            addCriterion("emp_pwd <", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdLessThanOrEqualTo(String value) {
            addCriterion("emp_pwd <=", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdLike(String value) {
            addCriterion("emp_pwd like", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdNotLike(String value) {
            addCriterion("emp_pwd not like", value, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdIn(List<String> values) {
            addCriterion("emp_pwd in", values, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdNotIn(List<String> values) {
            addCriterion("emp_pwd not in", values, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdBetween(String value1, String value2) {
            addCriterion("emp_pwd between", value1, value2, "empPwd");
            return (Criteria) this;
        }

        public Criteria andEmpPwdNotBetween(String value1, String value2) {
            addCriterion("emp_pwd not between", value1, value2, "empPwd");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIsNull() {
            addCriterion("emp_remark is null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIsNotNull() {
            addCriterion("emp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkEqualTo(String value) {
            addCriterion("emp_remark =", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotEqualTo(String value) {
            addCriterion("emp_remark <>", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkGreaterThan(String value) {
            addCriterion("emp_remark >", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("emp_remark >=", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLessThan(String value) {
            addCriterion("emp_remark <", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLessThanOrEqualTo(String value) {
            addCriterion("emp_remark <=", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkLike(String value) {
            addCriterion("emp_remark like", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotLike(String value) {
            addCriterion("emp_remark not like", value, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkIn(List<String> values) {
            addCriterion("emp_remark in", values, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotIn(List<String> values) {
            addCriterion("emp_remark not in", values, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkBetween(String value1, String value2) {
            addCriterion("emp_remark between", value1, value2, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpRemarkNotBetween(String value1, String value2) {
            addCriterion("emp_remark not between", value1, value2, "empRemark");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledIsNull() {
            addCriterion("emp_disabled is null");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledIsNotNull() {
            addCriterion("emp_disabled is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledEqualTo(Boolean value) {
            addCriterion("emp_disabled =", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledNotEqualTo(Boolean value) {
            addCriterion("emp_disabled <>", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledGreaterThan(Boolean value) {
            addCriterion("emp_disabled >", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("emp_disabled >=", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledLessThan(Boolean value) {
            addCriterion("emp_disabled <", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledLessThanOrEqualTo(Boolean value) {
            addCriterion("emp_disabled <=", value, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledIn(List<Boolean> values) {
            addCriterion("emp_disabled in", values, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledNotIn(List<Boolean> values) {
            addCriterion("emp_disabled not in", values, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledBetween(Boolean value1, Boolean value2) {
            addCriterion("emp_disabled between", value1, value2, "empDisabled");
            return (Criteria) this;
        }

        public Criteria andEmpDisabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("emp_disabled not between", value1, value2, "empDisabled");
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