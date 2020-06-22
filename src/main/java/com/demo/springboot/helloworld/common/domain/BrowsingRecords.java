package com.demo.springboot.helloworld.common.domain;

public class BrowsingRecords {
    private Long recordsId;

    private Long userId;

    private String records;

    public Long getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Long recordsId) {
        this.recordsId = recordsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records == null ? null : records.trim();
    }
}