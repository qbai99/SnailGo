package com.demo.springboot.helloworld.common.domain;

import java.util.ArrayList;
import java.util.List;

public class BrowsingRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrowsingRecordsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andRecordsIdIsNull() {
            addCriterion("records_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordsIdIsNotNull() {
            addCriterion("records_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordsIdEqualTo(Long value) {
            addCriterion("records_id =", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdNotEqualTo(Long value) {
            addCriterion("records_id <>", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdGreaterThan(Long value) {
            addCriterion("records_id >", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("records_id >=", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdLessThan(Long value) {
            addCriterion("records_id <", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdLessThanOrEqualTo(Long value) {
            addCriterion("records_id <=", value, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdIn(List<Long> values) {
            addCriterion("records_id in", values, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdNotIn(List<Long> values) {
            addCriterion("records_id not in", values, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdBetween(Long value1, Long value2) {
            addCriterion("records_id between", value1, value2, "recordsId");
            return (Criteria) this;
        }

        public Criteria andRecordsIdNotBetween(Long value1, Long value2) {
            addCriterion("records_id not between", value1, value2, "recordsId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRecordsIsNull() {
            addCriterion("records is null");
            return (Criteria) this;
        }

        public Criteria andRecordsIsNotNull() {
            addCriterion("records is not null");
            return (Criteria) this;
        }

        public Criteria andRecordsEqualTo(String value) {
            addCriterion("records =", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsNotEqualTo(String value) {
            addCriterion("records <>", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsGreaterThan(String value) {
            addCriterion("records >", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsGreaterThanOrEqualTo(String value) {
            addCriterion("records >=", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsLessThan(String value) {
            addCriterion("records <", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsLessThanOrEqualTo(String value) {
            addCriterion("records <=", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsLike(String value) {
            addCriterion("records like", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsNotLike(String value) {
            addCriterion("records not like", value, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsIn(List<String> values) {
            addCriterion("records in", values, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsNotIn(List<String> values) {
            addCriterion("records not in", values, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsBetween(String value1, String value2) {
            addCriterion("records between", value1, value2, "records");
            return (Criteria) this;
        }

        public Criteria andRecordsNotBetween(String value1, String value2) {
            addCriterion("records not between", value1, value2, "records");
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