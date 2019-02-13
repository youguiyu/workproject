package com.xngls.neiproj.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NeiKpiAndNeiValue {
    private String kpiName;
    private String id;
    private String kpiInfo;
    private String kpiDefinition;
    private String businessType;
    private  String  dimension;
    private  String subDimension;
    private  String department;
    private  String manager;
    private  String fetchAlgorithm;
    private  String fetchApproach;
    private  String fetchPlatform;
    private  String fetchWay;
    private  String timeGranularity;
    private  String areaGranularity;
    private BigDecimal benchmarkValue;
    private BigDecimal challengeValue;
    private BigDecimal flagValue;
    private boolean isTrend;
    private  String other;
    private  BigDecimal kpiWight;
    private  Integer sort;
    private Integer dateId;
    private Integer city;
    private BigDecimal currentValue;

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKpiInfo() {
        return kpiInfo;
    }

    public void setKpiInfo(String kpiInfo) {
        this.kpiInfo = kpiInfo;
    }

    public String getKpiDefinition() {
        return kpiDefinition;
    }

    public void setKpiDefinition(String kpiDefinition) {
        this.kpiDefinition = kpiDefinition;
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

    public String getSubDimension() {
        return subDimension;
    }

    public void setSubDimension(String subDimension) {
        this.subDimension = subDimension;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getFetchAlgorithm() {
        return fetchAlgorithm;
    }

    public void setFetchAlgorithm(String fetchAlgorithm) {
        this.fetchAlgorithm = fetchAlgorithm;
    }

    public String getFetchApproach() {
        return fetchApproach;
    }

    public void setFetchApproach(String fetchApproach) {
        this.fetchApproach = fetchApproach;
    }

    public String getFetchPlatform() {
        return fetchPlatform;
    }

    public void setFetchPlatform(String fetchPlatform) {
        this.fetchPlatform = fetchPlatform;
    }

    public String getFetchWay() {
        return fetchWay;
    }

    public void setFetchWay(String fetchWay) {
        this.fetchWay = fetchWay;
    }

    public String getTimeGranularity() {
        return timeGranularity;
    }

    public void setTimeGranularity(String timeGranularity) {
        this.timeGranularity = timeGranularity;
    }

    public String getAreaGranularity() {
        return areaGranularity;
    }

    public void setAreaGranularity(String areaGranularity) {
        this.areaGranularity = areaGranularity;
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

    public BigDecimal getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(BigDecimal flagValue) {
        this.flagValue = flagValue;
    }

    public boolean isTrend() {
        return isTrend;
    }

    public void setTrend(boolean trend) {
        isTrend = trend;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public BigDecimal getKpiWight() {
        return kpiWight;
    }

    public void setKpiWight(BigDecimal kpiWight) {
        this.kpiWight = kpiWight;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
}
