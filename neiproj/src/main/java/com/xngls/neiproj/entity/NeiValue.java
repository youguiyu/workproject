package com.xngls.neiproj.entity;

import java.math.BigDecimal;

public class NeiValue {
    private String kpiName;
    private Integer dateId;
    private Integer city;
    private BigDecimal currentValue;

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }


    @Override
    public String toString() {
        return "NeiValue{" +
                "kpiName='" + kpiName + '\'' +
                ", dateId=" + dateId +
                ", city=" + city +
                ", currentValue=" + currentValue +
                '}';
    }
}
