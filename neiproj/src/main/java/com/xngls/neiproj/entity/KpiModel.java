package com.xngls.neiproj.entity;

public class KpiModel {

    private Integer dateId;
    private String fetchPlatform;
    private Integer kpiNameCountOri;
    private Integer kpiNameCountNow;
    private Integer kpiCountValue;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getFetchPlatform() {
        return fetchPlatform;
    }

    public void setFetchPlatform(String fetchPlatform) {
        this.fetchPlatform = fetchPlatform;
    }

    public Integer getKpiNameCountOri() {
        return kpiNameCountOri;
    }

    public void setKpiNameCountOri(Integer kpiNameCountOri) {
        this.kpiNameCountOri = kpiNameCountOri;
    }

    public Integer getKpiNameCountNow() {
        if(this.kpiNameCountNow==null){
            return 0;
        }
        return kpiNameCountNow;
    }

    public void setKpiNameCountNow(Integer kpiNameCountNow) {
        this.kpiNameCountNow = kpiNameCountNow;
    }

    public Integer getKpiCountValue() {
        if(this.kpiCountValue==null){
            return kpiNameCountOri;
        }
        return kpiCountValue;
    }

    public void setKpiCountValue(Integer kpiCountValue) {
        this.kpiCountValue = kpiCountValue;
    }
}
