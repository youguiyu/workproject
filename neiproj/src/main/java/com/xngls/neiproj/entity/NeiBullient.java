package com.xngls.neiproj.entity;

import java.math.BigDecimal;

public class NeiBullient {
    private String businessType;
    private  String  dimension;
    private String kpiInfo;
    private String kpiName;
    private BigDecimal lastPeriod;
    private BigDecimal currentPeriod;
    private BigDecimal countryWide;
    private BigDecimal bestValue;
    private BigDecimal worstValue;
    private String rankingPeriod;
    private BigDecimal kpiWeight;
    private String other;

    private BigDecimal benchmarkValue;
    private BigDecimal challengeValue;

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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

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

    public BigDecimal getLastPeriod() {
        return lastPeriod;
    }

    public void setLastPeriod(BigDecimal lastPeriod) {
        this.lastPeriod = lastPeriod;
    }

    public BigDecimal getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(BigDecimal currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public BigDecimal getCountryWide() {
        return countryWide;
    }

    public void setCountryWide(BigDecimal countryWide) {
        this.countryWide = countryWide;
    }

    public BigDecimal getBestValue() {
        return bestValue;
    }

    public void setBestValue(BigDecimal bestValue) {
        this.bestValue = bestValue;
    }

    public BigDecimal getWorstValue() {
        return worstValue;
    }

    public void setWorstValue(BigDecimal worstValue) {
        this.worstValue = worstValue;
    }

    public String getRankingPeriod() {
        return rankingPeriod;
    }

    public void setRankingPeriod(String rankingPeriod) {
        this.rankingPeriod = rankingPeriod;
    }

    public BigDecimal getKpiWeight() {
        return kpiWeight;
    }

    public void setKpiWeight(BigDecimal kpiWeight) {
        this.kpiWeight = kpiWeight;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
