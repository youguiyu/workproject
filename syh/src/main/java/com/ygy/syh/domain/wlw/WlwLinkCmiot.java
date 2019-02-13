package com.ygy.syh.domain.wlw;

import java.io.Serializable;
import java.math.BigDecimal;

public class WlwLinkCmiot implements Serializable {

    private Integer dateId;
    private String apn;
    private BigDecimal userRate;
    private BigDecimal xdrRate;
    private BigDecimal flowRate;
    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public BigDecimal getUserRate() {
        return userRate;
    }

    public void setUserRate(BigDecimal userRate) {
        this.userRate = userRate;
    }

    public BigDecimal getXdrRate() {
        return xdrRate;
    }

    public void setXdrRate(BigDecimal xdrRate) {
        this.xdrRate = xdrRate;
    }

    public BigDecimal getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(BigDecimal flowRate) {
        this.flowRate = flowRate;
    }
}
