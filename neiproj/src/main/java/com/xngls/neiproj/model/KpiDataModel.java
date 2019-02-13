package com.xngls.neiproj.model;

import java.io.Serializable;
import java.util.List;

public class KpiDataModel implements Serializable{
    private Integer offset;
    private Integer limit;
    private Integer time1;
    private Integer time2;


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

    public Integer getTime1() {
        return time1;
    }

    public void setTime1(Integer time1) {
        this.time1 = time1;
    }

    public Integer getTime2() {
        return time2;
    }

    public void setTime2(Integer time2) {
        this.time2 = time2;
    }
}
