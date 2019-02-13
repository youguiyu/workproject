package com.ygy.syh.domain.wlw;

import java.io.Serializable;

public class TableStatus implements Serializable {
    private Integer dateId;
    private Integer flag;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
