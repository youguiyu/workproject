package com.xngls.neiproj.entity;

import java.math.BigDecimal;

public class NeiKpiView {

    private String dateId;
    private String kpiName;
    private String businessType;
    private Integer city;
    private String other;
    private BigDecimal KpiWeight;
    private BigDecimal benchmarkValue;
    private BigDecimal challengeValue;
    private BigDecimal currentValue;
    private BigDecimal score;
    private String dimension;
    private BigDecimal weightTotal;

    public BigDecimal getWeightTotal() {
        return weightTotal;
    }

    public void setWeightTotal(BigDecimal weightTotal) {
        this.weightTotal = weightTotal;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BigDecimal getBenchmarkValue() {
        return benchmarkValue;
    }

    public void setBenchmarkValue(BigDecimal benchmarkValue) {
        this.benchmarkValue = benchmarkValue;
    }

    public BigDecimal getChallengeValue() {
        return challengeValue;
    }

    public void setChallengeValue(BigDecimal challengeValue) {
        this.challengeValue = challengeValue;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public BigDecimal getKpiWeight() {
        return KpiWeight;
    }

    public void setKpiWeight(BigDecimal kpiWeight) {
        KpiWeight = kpiWeight;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
