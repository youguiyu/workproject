package com.ygy.syh.domain.wlw;

import java.io.Serializable;
import java.math.BigDecimal;

public class WlwField implements Serializable {
    private Integer dateId;
    private String field;
    private Integer apnCnt;
    private Long userCnt;
    private Long xdrCnt;
    private BigDecimal flowGb;

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

    public Integer getApnCnt() {
        return apnCnt;
    }

    public void setApnCnt(Integer apnCnt) {
        this.apnCnt = apnCnt;
    }

    public Long getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(Long userCnt) {
        this.userCnt = userCnt;
    }

    public Long getXdrCnt() {
        return xdrCnt;
    }

    public void setXdrCnt(Long xdrCnt) {
        this.xdrCnt = xdrCnt;
    }

    public BigDecimal getFlowGb() {
        return flowGb;
    }

    public void setFlowGb(BigDecimal flowGb) {
        this.flowGb = flowGb;
    }
}
