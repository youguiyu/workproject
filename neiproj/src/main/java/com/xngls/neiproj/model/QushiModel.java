package com.xngls.neiproj.model;

import java.io.Serializable;
import java.util.List;

public class QushiModel implements Serializable{
    private String kpiName;
    private String dimension;
    private String selectsilun;
    private Integer cityNum;
    private Integer reportType;
    private Integer timeselect;

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSelectsilun() {
        return selectsilun;
    }

    public void setSelectsilun(String selectsilun) {
        this.selectsilun = selectsilun;
    }



    public Integer getCityNum() {
        return cityNum;
    }

    public void setCityNum(Integer cityNum) {
        this.cityNum = cityNum;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getTimeselect() {
        return timeselect;
    }

    public void setTimeselect(Integer timeselect) {
        this.timeselect = timeselect;
    }
}
