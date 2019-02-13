package com.ygy.worldcup.domain;

import java.math.BigDecimal;

public class VideoQs {
    private String startTime;
    private Integer city;
    private BigDecimal smoothPlayback;
    private String appSubClassName;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public BigDecimal getSmoothPlayback() {
        return smoothPlayback;
    }

    public void setSmoothPlayback(BigDecimal smoothPlayback) {
        this.smoothPlayback = smoothPlayback;
    }

    public String getAppSubClassName() {
        return appSubClassName;
    }

    public void setAppSubClassName(String appSubClassName) {
        this.appSubClassName = appSubClassName;
    }
}
