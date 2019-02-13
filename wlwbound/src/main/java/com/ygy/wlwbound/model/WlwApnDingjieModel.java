package com.ygy.wlwbound.model;

import java.math.BigDecimal;

public class WlwApnDingjieModel {
    private Integer dateId;
    private String apn;
    private String name;
    private String type;
    private Long userCount;
    private Double attachCountPDP;
    private Double attachCount;


    private String userCountDingjieConclusion;
    private BigDecimal flowKb;
    private String flow_dingjie_conclusion;
    private BigDecimal attachCountRate;
    private String attachSucRateDingjieConclusion;
    private BigDecimal pdpCountRate;
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

    public Double getAttachCountPDP() {
        return attachCountPDP;
    }

    public void setAttachCountPDP(Double attachCountPDP) {
        this.attachCountPDP = attachCountPDP;
    }

    public Double getAttachCount() {
        return attachCount;
    }

    public void setAttachCount(Double attachCount) {
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

    public String getFlow_dingjie_conclusion() {
        return flow_dingjie_conclusion;
    }

    public void setFlow_dingjie_conclusion(String flow_dingjie_conclusion) {
        this.flow_dingjie_conclusion = flow_dingjie_conclusion;
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

    public BigDecimal getPdpCountRate() {
        return pdpCountRate;
    }

    public void setPdpCountRate(BigDecimal pdpCountRate) {
        this.pdpCountRate = pdpCountRate;
    }

    public String getPdpSucRateDingjieConclusion() {
        return pdpSucRateDingjieConclusion;
    }

    public void setPdpSucRateDingjieConclusion(String pdpSucRateDingjieConclusion) {
        this.pdpSucRateDingjieConclusion = pdpSucRateDingjieConclusion;
    }
}
