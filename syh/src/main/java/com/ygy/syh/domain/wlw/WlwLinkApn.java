package com.ygy.syh.domain.wlw;

import java.io.Serializable;

public class WlwLinkApn implements Serializable {

    private  Integer dateId;
    private String upDownType;
    private Integer apnCnt;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getUpDownType() {
        return upDownType;
    }

    public void setUpDownType(String upDownType) {
        this.upDownType = upDownType;
    }

    public Integer getApnCnt() {
        return apnCnt;
    }

    public void setApnCnt(Integer apnCnt) {
        this.apnCnt = apnCnt;
    }
}
