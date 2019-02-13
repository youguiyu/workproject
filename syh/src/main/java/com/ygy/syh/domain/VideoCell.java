package com.ygy.syh.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class VideoCell implements Serializable {

    //小区名
    private String labelCn;
    private Integer imsiCntSum;
    private BigDecimal totalFlowSum;
    private BigDecimal waittime;

    public String getLabelCn() {
        return this.labelCn.split("-")[1];
    }

    public void setLabelCn(String labelCn) {
        this.labelCn = labelCn;
    }

    public Integer getImsiCntSum() {
        return imsiCntSum;
    }

    public void setImsiCntSum(Integer imsiCntSum) {
        this.imsiCntSum = imsiCntSum;
    }

    public BigDecimal getTotalFlowSum() {
        return totalFlowSum;
    }

    public void setTotalFlowSum(BigDecimal totalFlowSum) {
        this.totalFlowSum = totalFlowSum;
    }

    public BigDecimal getWaittime() {
        return waittime;
    }

    public void setWaittime(BigDecimal waittime) {
        this.waittime = waittime;
    }
}
