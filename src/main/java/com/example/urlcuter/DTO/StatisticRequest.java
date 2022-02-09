package com.example.urlcuter.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class StatisticRequest {
    private String cutUrlFilter;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fromDateFilter;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime toDateFilter;
    private Integer limit;

    public String getCutUrlFilter() {
        return cutUrlFilter;
    }

    public void setCutUrlFilter(String cutUrlFilter) {
        this.cutUrlFilter = cutUrlFilter;
    }

    public LocalDateTime getFromDateFilter() {
        return fromDateFilter;
    }

    public void setFromDateFilter(LocalDateTime fromDateFilter) {
        this.fromDateFilter = fromDateFilter;
    }

    public LocalDateTime getToDateFilter() {
        return toDateFilter;
    }

    public void setToDateFilter(LocalDateTime toDateFilter) {
        this.toDateFilter = toDateFilter;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
