package com.demo.springboot.helloworld.common.domain;

import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessIsNull() {
            addCriterion("shop_main_bussiness is null");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessIsNotNull() {
            addCriterion("shop_main_bussiness is not null");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessEqualTo(String value) {
            addCriterion("shop_main_bussiness =", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessNotEqualTo(String value) {
            addCriterion("shop_main_bussiness <>", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessGreaterThan(String value) {
            addCriterion("shop_main_bussiness >", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessGreaterThanOrEqualTo(String value) {
            addCriterion("shop_main_bussiness >=", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessLessThan(String value) {
            addCriterion("shop_main_bussiness <", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessLessThanOrEqualTo(String value) {
            addCriterion("shop_main_bussiness <=", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessLike(String value) {
            addCriterion("shop_main_bussiness like", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessNotLike(String value) {
            addCriterion("shop_main_bussiness not like", value, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessIn(List<String> values) {
            addCriterion("shop_main_bussiness in", values, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessNotIn(List<String> values) {
            addCriterion("shop_main_bussiness not in", values, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessBetween(String value1, String value2) {
            addCriterion("shop_main_bussiness between", value1, value2, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopMainBussinessNotBetween(String value1, String value2) {
            addCriterion("shop_main_bussiness not between", value1, value2, "shopMainBussiness");
            return (Criteria) this;
        }

        public Criteria andShopStarIsNull() {
            addCriterion("shop_star is null");
            return (Criteria) this;
        }

        public Criteria andShopStarIsNotNull() {
            addCriterion("shop_star is not null");
            return (Criteria) this;
        }

        public Criteria andShopStarEqualTo(Double value) {
            addCriterion("shop_star =", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotEqualTo(Double value) {
            addCriterion("shop_star <>", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarGreaterThan(Double value) {
            addCriterion("shop_star >", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_star >=", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarLessThan(Double value) {
            addCriterion("shop_star <", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarLessThanOrEqualTo(Double value) {
            addCriterion("shop_star <=", value, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarIn(List<Double> values) {
            addCriterion("shop_star in", values, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotIn(List<Double> values) {
            addCriterion("shop_star not in", values, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarBetween(Double value1, Double value2) {
            addCriterion("shop_star between", value1, value2, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopStarNotBetween(Double value1, Double value2) {
            addCriterion("shop_star not between", value1, value2, "shopStar");
            return (Criteria) this;
        }

        public Criteria andShopDspIsNull() {
            addCriterion("shop_dsp is null");
            return (Criteria) this;
        }

        public Criteria andShopDspIsNotNull() {
            addCriterion("shop_dsp is not null");
            return (Criteria) this;
        }

        public Criteria andShopDspEqualTo(String value) {
            addCriterion("shop_dsp =", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspNotEqualTo(String value) {
            addCriterion("shop_dsp <>", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspGreaterThan(String value) {
            addCriterion("shop_dsp >", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspGreaterThanOrEqualTo(String value) {
            addCriterion("shop_dsp >=", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspLessThan(String value) {
            addCriterion("shop_dsp <", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspLessThanOrEqualTo(String value) {
            addCriterion("shop_dsp <=", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspLike(String value) {
            addCriterion("shop_dsp like", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspNotLike(String value) {
            addCriterion("shop_dsp not like", value, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspIn(List<String> values) {
            addCriterion("shop_dsp in", values, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspNotIn(List<String> values) {
            addCriterion("shop_dsp not in", values, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspBetween(String value1, String value2) {
            addCriterion("shop_dsp between", value1, value2, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopDspNotBetween(String value1, String value2) {
            addCriterion("shop_dsp not between", value1, value2, "shopDsp");
            return (Criteria) this;
        }

        public Criteria andShopLocIsNull() {
            addCriterion("shop_loc is null");
            return (Criteria) this;
        }

        public Criteria andShopLocIsNotNull() {
            addCriterion("shop_loc is not null");
            return (Criteria) this;
        }

        public Criteria andShopLocEqualTo(String value) {
            addCriterion("shop_loc =", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocNotEqualTo(String value) {
            addCriterion("shop_loc <>", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocGreaterThan(String value) {
            addCriterion("shop_loc >", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocGreaterThanOrEqualTo(String value) {
            addCriterion("shop_loc >=", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocLessThan(String value) {
            addCriterion("shop_loc <", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocLessThanOrEqualTo(String value) {
            addCriterion("shop_loc <=", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocLike(String value) {
            addCriterion("shop_loc like", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocNotLike(String value) {
            addCriterion("shop_loc not like", value, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocIn(List<String> values) {
            addCriterion("shop_loc in", values, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocNotIn(List<String> values) {
            addCriterion("shop_loc not in", values, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocBetween(String value1, String value2) {
            addCriterion("shop_loc between", value1, value2, "shopLoc");
            return (Criteria) this;
        }

        public Criteria andShopLocNotBetween(String value1, String value2) {
            addCriterion("shop_loc not between", value1, value2, "shopLoc");
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