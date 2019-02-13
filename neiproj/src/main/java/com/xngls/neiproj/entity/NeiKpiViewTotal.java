package com.xngls.neiproj.entity;

import java.math.BigDecimal;

public class NeiKpiViewTotal {
    private Integer dateId;
    private BigDecimal totalKpiWeight;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public BigDecimal getTotalKpiWeight() {
        return totalKpiWeight;
    }

    public void setTotalKpiWeight(BigDecimal totalKpiWeight) {
        this.totalKpiWeight = totalKpiWeight;
    }
}
