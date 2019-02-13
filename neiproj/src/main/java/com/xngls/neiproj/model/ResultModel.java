package com.xngls.neiproj.model;

import java.io.Serializable;

public class ResultModel implements Serializable{
    private String kpiInfo;
    private String kpiName;
    private String dateId;
    private String city;
    private String currValue;
    private String resultContent;

    public String getKpiInfo() {
        return kpiInfo;
    }

    public void setKpiInfo(String kpiInfo) {
        this.kpiInfo = kpiInfo;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrValue() {
        return currValue;
    }

    public void setCurrValue(String currValue) {
        this.currValue = currValue;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }
}
