package com.ygy.syh.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CellModel implements Serializable{

    private long imsiCnt;
    private BigDecimal avgthrouputdl;
    private BigDecimal totalFlow;

    public long getImsiCnt() {
        return imsiCnt;
    }

    public void setImsiCnt(long imsiCnt) {
        this.imsiCnt = imsiCnt;
    }

    public BigDecimal getAvgthrouputdl() {
        return avgthrouputdl;
    }

    public void setAvgthrouputdl(BigDecimal avgthrouputdl) {
        this.avgthrouputdl = avgthrouputdl;
    }

    public BigDecimal getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(BigDecimal totalFlow) {
        this.totalFlow = totalFlow;
    }
}
