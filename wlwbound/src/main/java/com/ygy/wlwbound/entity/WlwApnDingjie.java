package com.ygy.wlwbound.entity;

import java.math.BigDecimal;

public class WlwApnDingjie {
    private Integer dateId;
    private String apn;
    private String name;
    private String type;
    private Long userCount;
    private Long attachCount;
    private String userCountDingjieConclusion;
    private BigDecimal flowKb;
    private String flowDingjieConclusion;
    private BigDecimal attachCountRate;
    private String attachSucRateDingjieConclusion;
    private String pdpSucRateDingjieConclusion;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    public Long getAttachCount() {
        return attachCount;
    }

    public void setAttachCount(Long attachCount) {
        this.attachCount = attachCount;
    }

    public String getUserCountDingjieConclusion() {
        return userCountDingjieConclusion;
    }

    public void setUserCountDingjieConclusion(String userCountDingjieConclusion) {
        this.userCountDingjieConclusion = userCountDingjieConclusion;
    }

    public BigDecimal getFlowKb() {
        return flowKb;
    }

    public void setFlowKb(BigDecimal flowKb) {
        this.flowKb = flowKb;
    }

    public String getFlowDingjieConclusion() {
        return flowDingjieConclusion;
    }

    public void setFlowDingjieConclusion(String flowDingjieConclusion) {
        this.flowDingjieConclusion = flowDingjieConclusion;
    }

    public BigDecimal getAttachCountRate() {
        return attachCountRate;
    }

    public void setAttachCountRate(BigDecimal attachCountRate) {
        this.attachCountRate = attachCountRate;
    }

    public String getAttachSucRateDingjieConclusion() {
        return attachSucRateDingjieConclusion;
    }

    public void setAttachSucRateDingjieConclusion(String attachSucRateDingjieConclusion) {
        this.attachSucRateDingjieConclusion = attachSucRateDingjieConclusion;
    }

    public String getPdpSucRateDingjieConclusion() {
        return pdpSucRateDingjieConclusion;
    }

    public void setPdpSucRateDingjieConclusion(String pdpSucRateDingjieConclusion) {
        this.pdpSucRateDingjieConclusion = pdpSucRateDingjieConclusion;
    }
}
