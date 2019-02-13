package com.xngls.neiproj.model;

import java.io.Serializable;
import java.util.List;

public class ZhibiaoTiaoModel implements Serializable{
    private Integer offset;
    private Integer limit;
    private String selectsilun;
    private List<String> selecttenW;
    private Integer cityNum;
    private Integer reportType;
    private Integer timeselect;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSelectsilun() {
        return selectsilun;
    }

    public void setSelectsilun(String selectsilun) {
        this.selectsilun = selectsilun;
    }

    public List<String> getSelecttenW() {
        return selecttenW;
    }

    public void setSelecttenW(List<String> selecttenW) {
        this.selecttenW = selecttenW;
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
