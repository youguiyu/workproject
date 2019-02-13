package com.ygy.lteproj.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class WlwKqiField implements Serializable {
    private Integer dateId;
    private String field;
    private Long attachCount;
    private BigDecimal attachRate;
    private BigDecimal tcpCoreRate;
    private BigDecimal tcpWxRate;
    private BigDecimal httpRate;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getAttachCount() {
        return attachCount;
    }

    public void setAttachCount(Long attachCount) {
        this.attachCount = attachCount;
    }

    public BigDecimal getAttachRate() {
        return attachRate;
    }

    public void setAttachRate(BigDecimal attachRate) {
        this.attachRate = attachRate;
    }

    public BigDecimal getTcpCoreRate() {
        return tcpCoreRate;
    }

    public void setTcpCoreRate(BigDecimal tcpCoreRate) {
        this.tcpCoreRate = tcpCoreRate;
    }

    public BigDecimal getTcpWxRate() {
        return tcpWxRate;
    }

    public void setTcpWxRate(BigDecimal tcpWxRate) {
        this.tcpWxRate = tcpWxRate;
    }

    public BigDecimal getHttpRate() {
        return httpRate;
    }

    public void setHttpRate(BigDecimal httpRate) {
        this.httpRate = httpRate;
    }
}
