package com.ygy.wlwbound.model;

import java.io.Serializable;

public class PageModel implements Serializable {

    private Integer offset;
    private Integer limit;
    private Integer timeselect;

    public Integer getTimeselect() {
        return timeselect;
    }

    public void setTimeselect(Integer timeselect) {
        this.timeselect = timeselect;
    }

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
}
